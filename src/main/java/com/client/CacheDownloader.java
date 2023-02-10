package com.client;

import com.client.sign.Signlink;
import com.google.common.base.Preconditions;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class CacheDownloader {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(CacheDownloader.class.getName());

	public static int cacheVersionRemote;
	public static int cacheVersionLocal;

	private final Client client;

	private static final int BUFFER = 2048;

	private final Path fileLocation;

	public CacheDownloader(Client client) {
		Objects.requireNonNull(Signlink.getCacheDirectory());
		this.client = client;
		fileLocation = Paths.get(Signlink.getCacheDirectory(), getArchivedName());
	}

	private int getLocalVersion() {
		try(BufferedReader fr = new BufferedReader(new FileReader(Signlink.getCacheDirectory() + File.separator + "version.dat"))){
			return Integer.parseInt(fr.readLine());
		} catch (Exception e) {
			return -1;
		}
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	public void writeVersion(int version) {
		File versionFile = new File(Signlink.getCacheDirectory() + File.separator + "version.dat");
		if(versionFile.exists()) {
			versionFile.delete();
		}
		try(BufferedWriter br = new BufferedWriter(new FileWriter(versionFile))) {
			br.write(version + "");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteZip() {
		try {
			Files.deleteIfExists(fileLocation);
		} catch (IOException ex) {
			log.severe("Cannot delete cache zip file.");
		}
	}

	public CacheDownloader downloadCache() {
		if (Signlink.usingDevCache()) {
			System.out.println("Using local_cache, skipping cache update.");
			return null;
		}

		try {
			File location = new File(Signlink.getCacheDirectory());
			File version = new File(Signlink.getCacheDirectory() + "/version.dat");
			cacheVersionRemote = Configuration.CACHE_VERSION;
			if (!location.exists() || !version.exists()) {
				log.info("Cache does not exist, downloading.");
				update();
			} else {
				cacheVersionLocal = getLocalVersion();
				log.info("Cache version local=" + cacheVersionLocal + ", remote=" + cacheVersionRemote);
				if (cacheVersionRemote != cacheVersionLocal) {
					update();
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void update() throws IOException {
		downloadFile(getArchivedName());
		unZip();
		writeVersion(cacheVersionRemote);
		deleteZip();
	}

	private void downloadFile(String localFileName) throws IOException {
		OutputStream out = null;
		URLConnection conn;
		InputStream in = null;

		try {
			URL url = new URL(Configuration.CACHE_LINK);
			out = new BufferedOutputStream(new FileOutputStream(Signlink.getCacheDirectory() + "/" + localFileName));

			conn = url.openConnection();
			in = conn.getInputStream();

			byte[] data = new byte[BUFFER];

			int numRead;
			long numWritten = 0;
			int fileSize = conn.getContentLength();

			while ((numRead = in.read(data)) != -1) {
				out.write(data, 0, numRead);
				numWritten += numRead;

				int percentage = (int) (((double) numWritten / (double) fileSize) * 100D);

				client.drawLoadingText(percentage,  "Exilius by VG - Downloading Cache " + percentage + "%");
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private String getArchivedName() {
		int lastSlashIndex = Configuration.CACHE_LINK.lastIndexOf('/');
		String u = Configuration.CACHE_LINK.substring(lastSlashIndex + 1);
		return u.replace("?dl=1", "");
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	private void unZip() throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(fileLocation.toString()));
		ZipInputStream zin = new ZipInputStream(in);
		ZipEntry e;
		int files = countRegularFiles(new ZipFile(fileLocation.toString()));

		int numWritten = 0;
		while ((e = zin.getNextEntry()) != null) {
			String fileName = e.getName();
			File newFile = new File(Signlink.getCacheDirectory() + File.separator + fileName);
			if (e.isDirectory()) {
				(new File(Signlink.getCacheDirectory() + e.getName())).mkdir();
			} else {
				int percentage = (int) (((double) numWritten++ / (double) files) * 100D);
				client.drawLoadingText(percentage, Configuration.CLIENT_TITLE + " - Installing Cache " + percentage + "%");
				if (e.getName().equals(fileLocation.toString())) {
					unzip(zin, fileLocation.toString());
					break;
				}
				File file = new File(newFile.getParent());
				if (!file.exists()) {
					Preconditions.checkState(file.mkdirs(), "Cannot create file.");
				}
				unzip(zin, Signlink.getCacheDirectory() + e.getName());
			}
		}
		zin.close();
	}

	private static int countRegularFiles(final ZipFile zipFile) {
		final Enumeration<? extends ZipEntry> entries = zipFile.entries();
		int numRegularFiles = 0;
		while (entries.hasMoreElements()) {
			if (! entries.nextElement().isDirectory()) {
				++numRegularFiles;
			}
		}
		return numRegularFiles;
	}

	private void unzip(ZipInputStream zin, String s) throws IOException {
		try (FileOutputStream out = new FileOutputStream(s)) {
			byte[] b = new byte[BUFFER];
			int len;
			while ((len = zin.read(b)) != -1)
				out.write(b, 0, len);
		}
	}

}