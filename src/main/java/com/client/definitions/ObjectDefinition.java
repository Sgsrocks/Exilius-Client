package com.client.definitions;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSBuffer;
import net.runelite.rs.api.RSIterableNodeHashTable;
import net.runelite.rs.api.RSObjectComposition;
import org.apache.commons.lang3.StringUtils;

import com.client.AnimFrame;
import com.client.Client;
import com.client.ReferenceCache;
import com.client.Model;
import com.client.OnDemandFetcher;
import com.client.Buffer;
import com.client.FileArchive;

public final class ObjectDefinition implements RSObjectComposition {


	public static ObjectDefinition lookup(int i) {
		if (i > streamIndices.length)
			i = streamIndices.length - 2;

		if (i == 25913 || i == 25916 || i == 25917)
			i = 15552;

		for (int j = 0; j < 20; j++)
			if (cache[j].type == i)
				return cache[j];

		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDefinition objectDef = cache[cacheIndex];
		stream.currentPosition = streamIndices[i];
		objectDef.type = i;
		objectDef.setDefaults();
		objectDef.decode(stream);
		if (i >= 26281 && i <= 26290) {
			objectDef.actions = new String[] { "Choose", null, null, null, null };
		}
		switch (i) {
			case 36201: // Raids 1 lobby entrance
				objectDef.actions = new String[]{ "Enter", null, null, null, null};
				break;
			case 591:
				objectDef.name = "Item Upgrades Table";
				objectDef.actions = new String[]{"Forge", null, null, null, null};
				break;
			case 33320:
				objectDef.name = "Fire of Exchange";
				objectDef.actions = new String[] { "Burn", "Burn Rates", null, null, null };
				break;
			case 36062:
				objectDef.description = "Teleports you anywhere around Exilius.";
				objectDef.actions = new String[] { "Activate", "Previous Location", null, null, null };
				break;
			case 4152:
				objectDef.name = "Skilling Portal";
				objectDef.description = "Teleports you to various skilling areas.";
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;
			case 1206:
				objectDef.name = "Hespori Vines";
				objectDef.description = "The vines of Hespori.";
				objectDef.actions = new String[] { "Pick", null, null, null, null };
				break;
			case 33222:
				objectDef.name = "Burning Ore";
				objectDef.description = "I should try heating this up.";
				objectDef.actions = new String[] { "Mine", null, null, null, null };
				break;
			case 8880:
				objectDef.name = "Tool Box";
				objectDef.description = "Useful tools for resources in the area.";
				objectDef.actions = new String[] { "Take-tools", null, null, null, null };
				break;
			case 29771:
				objectDef.name = "Tools";
				objectDef.description = "Useful tools for resources in the area.";
				objectDef.actions = new String[] { null , null, null, null, null };
				break;
			case 33223:
				objectDef.name = "Enchanted stone";
				objectDef.description = "A fragile ancient stone.";
				objectDef.actions = new String[] { "Mine", null, null, null, null };
				break;

			case 33311:
				objectDef.name = "Fire";
				objectDef.description = "Looks very hot.";
				objectDef.actions = new String[] { "Burn-essence", "Burn-runes", null, null, null };
				break;
			case 12768:
				objectDef.name = "@gre@Nature Chest";
				objectDef.description = "Requires a Hespori key to open.";
				break;
			case 37743: // nightmare good flower
				objectDef.readyanim = 8617;
				break;
			case 37740: // nightmare bad flower
				objectDef.readyanim = 8623;
				break;
			case 37738: // nightmare spore spawn
				objectDef.readyanim = 8630;
				break;
			case 35914:
				objectDef.name = "Ahrim The Blighted";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 9362:
				objectDef.name = "Dharok The Wretched";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 14766:
				objectDef.name = "Verac The Defiled";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 9360:
				objectDef.name = "Torag The Corrupted";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 28723:
				objectDef.name = "Karil The Tainted";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 31716:
				objectDef.name = "Guthan The Infested";
				objectDef.actions = new String[] { "Awaken", null, null, null, null };
				break;
			case 31622:
				objectDef.name = "Outlast Entrance";
				objectDef.actions = new String[] { "Enter", "Check Players", "Check Active", null, null };
				break;
			case 43751:
				objectDef.name = "Nex Angel Of Death Entrance";
				objectDef.actions = new String[] { "Enter", "Check Players", "Check Active", null, null };
				break;
			case 38829:
				objectDef.name = "World Event Exit";
				objectDef.actions = new String[] { "Enter", "Check Players", "Check Active", null, null };
				break;
			case 31624:
				objectDef.name = "@pur@Platinum Altar";
				break;
			case 29064:
				objectDef.name = "Exilius Leaderboards";
				objectDef.actions = new String[] { "View", null, null, null, null };
				break;

			case 33318:
				objectDef.name = "Fire of Destruction";
				objectDef.actions = new String[] { "Sacrifice", null, null, null, null };
				break;
			case 37341:
				objectDef.name = "Hunllef's Chest";
				objectDef.actions = new String[] { "Unlock", null, null, null, null };
				break;
			case 6097:
				objectDef.actions = new String[] { "Donate", null, null, null, null };
				break;
			case 14888:
				objectDef.name = "Jewelry Oven";
				break;
			case 29165:
				objectDef.name = "Coin Stack";
				objectDef.actions = new String[] { null, "Steal From", null, null, null };
				break;
			case 13681:
				objectDef.name = "Animal Cage";
				objectDef.actions = new String[] { null, null, null, null, null };
				break;
			case 38003:
				objectDef.name = "Tokkul-Pit";
				objectDef.actions = new String[] { "Enter", null, null, null, null };
				break;
			case 33983:
				objectDef.name = "Anima Patch";
				objectDef.actions = new String[] { "Rake", "Plant", null, null, null };
				break;
			case 30720:
				objectDef.name = "@red@Corrupt Chest";
				objectDef.actions = new String[] { "Open", null, null, null, null };
				break;
			case 34662:
				objectDef.actions = new String[] { "Open", "Teleport", null, null, null };
				break;
			case 12202:
				objectDef.actions = new String[] { "Dig", null, null, null, null };
				break;
			case 30107:
				objectDef.name = "Raids Reward Chest";
				objectDef.actions = new String[] { "Open", null, null, null, null };
				break;
			case 46220:
				objectDef.name = "Enter";
				objectDef.actions = new String[] { "Open", null, null, null, null };
				break;
			case 30018:
				objectDef.name = "Enter";
				objectDef.actions = new String[] { "Cross", null, null, null, null };
				break;
			case 36197:
				objectDef.name = "Home Teleport";

				break;
			case 10562:
				objectDef.actions = new String[] { "Open", null, null, null, null };
				break;
			case 8207:
				objectDef.actions = new String[] { "Care-To", null, null, null, null };
				objectDef.name = "Herb Patch";
				break;
			case 8720:
				objectDef.name = "Vote shop";
				break;
			case 8210:
				objectDef.actions = new String[] { "Rake", null, null, null, null };
				objectDef.name = "Herb Patch";
				break;
			case 29150:
				objectDef.actions = new String[] { "Venerate", null, null, null, null };
				break;
			case 6764:
				objectDef.name = null;
				objectDef.actions = new String[] { null, null, null, null, null };
				break;
			case 8139:
			case 8140:
			case 8141:
			case 8142:
				objectDef.actions = new String[] { "Inspect", null, null, null, null };
				objectDef.name = "Herbs";
				break;
			case 2341:
				objectDef.actions = new String[] { null, null, null, null, null };
				break;
			case 14217:
				objectDef.actions = new String[5];
				break;
			case 3840:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Fill";
				objectDef.actions[1] = "Empty-From";
				objectDef.name = "Compost Bin";
				break;
			case 172:
				objectDef.name = "Ckey chest";
				break;
			case 31925:
				objectDef.name = "Max Island";
				objectDef.actions = new String[] { "Tele to", null, null, null, null };
				break;
			case 2996:
				objectDef.name = "Vote Chest";
				objectDef.actions = new String[] { "Unlock", null, null, null, null };
				break;

			case 12309:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Bank";
				objectDef.actions[1] = "Buy gloves";
				objectDef.actions[2] = null;
				objectDef.name = "Chest";
				break;
			case 32572:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Bank";
				objectDef.name = "Group chest";
				break;
			case 31625:
				objectDef.name = "Fountain of Healing";
				objectDef.actions = new String[] { "Drink", null, null, null, null };
				break;
			case 41808:
				objectDef.name = "@bl3@Lone Survivor Entrance";
				objectDef.actions = new String[] { "Enter", "Check Players", "Check Active", null, null };
				break;
			case 1750:
				objectDef.models = new int[] { 8131, };
				objectDef.name = "Willow";
				objectDef.length = 2;
				objectDef.width = 2;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Chop down", null, null, null, null };
				objectDef.mapscene = 3;
				break;
			case 26782:
				objectDef.actions = new String[] { "Recharge", null, null, null, null };
				break;

			case 1751:
				objectDef.models = new int[] { 8037, 8040, };
				objectDef.name = "Oak";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Chop down", null, null, null, null };
				objectDef.mapscene = 1;
				break;

			case 7814:
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;

			case 8356:
				objectDef.actions = new String[] { "Teleport", "Mt. Quidamortem", null, null, null };
				break;

			case 28900:
				objectDef.actions = new String[] { "Teleport", "Recharge Crystals", null, null, null };
				break;
			case 26740:
				objectDef.name = "Player Outlast";
				objectDef.actions = new String[] { "Join", "Setup", null, null, null };
				break;

			case 28837:
				objectDef.actions = new String[] { "Set Destination", null, null, null, null };
				break;

			case 7811:
				objectDef.name = "District Supplies";
				objectDef.actions = new String[] { "Blood Money", "Free", "Quick-Sets", null, null };
				break;
			case 10061:
			case 10060:
				objectDef.name = "Trading Post";
				objectDef.actions = new String[] { "Bank", "Open", "Collect", null, null };
				break;
			case 13287:
				objectDef.name = "Storage chest (UIM)";
				objectDef.description = "A chest to store items for UIM.";
				break;
			case 1752:
				objectDef.models = new int[] { 53166, };
				objectDef.name = "AFK TREE";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Chop down", null, null, null, null };
				objectDef.mapscene = 0;
				break;
			case 4873:
				objectDef.name = "Wilderness Lever";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Enter Deep Wildy", null, null, null, null };
				objectDef.mapscene = 3;
				break;
			case 29735:
				objectDef.name = "Basic Slayer Dungeon";
				break;
			case 2544:
				objectDef.name = "Dagannoth Manhole";
				break;
			case 29345:
				objectDef.name = "Training Teleports Portal";
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;
			case 29346:
				objectDef.name = "Wilderness Teleports Portal";
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;
			case 29347:
				objectDef.name = "Boss Teleports Portal";
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;
			case 29349:
				objectDef.name = "Mini-Game Teleports Portal";
				objectDef.actions = new String[] { "Teleport", null, null, null, null };
				break;
			case 7127:
				objectDef.models = new int[] { 36457, };
				objectDef.name = "pp";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Chop down", null, null, null, null };
				objectDef.mapscene = 3;
				break;
			case 4155:
				objectDef.name = "Zul Andra Portal";
				break;
			case 2123:
				objectDef.name = "Mt. Quidamortem Slayer Dungeon";
				break;
			case 4150:
				objectDef.name = "Warriors Guild Mini-game Portal";
				break;
			case 11803:
				objectDef.name = "Donator Slayer Dungeon";
				break;
			case 4151:
				objectDef.name = "Barrows Mini-game Portal";
				break;
			case 1753:
				objectDef.models = new int[] { 53166, };
				objectDef.name = "Yew";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { "Chop down", null, null, null, null };
				objectDef.mapscene = 3;
				break;

			case 6943:
				objectDef.models = new int[] { 1270, };
				objectDef.name = "Bank booth";
				objectDef.blocksProjectile = false;
				objectDef.ambient = 25;
				objectDef.contrast = 25;
				objectDef.actions = new String[] { null, "Bank", "Collect", null, null };
				break;
			case 25017:
			case 25018:
			case 25029:
				objectDef.actions = new String[] { "Push-Through", null, null, null, null };
				break;
			case 8747:
				objectDef.actions = new String[] { "Smith", null, null, null, null };
				break;
			case 19038:
				objectDef.models = new int[] { 60998, };
				objectDef.name = "Mod Icon";
				objectDef.length = 2;
				objectDef.width = 2;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { null, null, null, null, null };
				objectDef.mapscene = 3;
				break;

			case 18826:
			case 18819:
			case 18818:
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.scaleZ = 200; // Width
				objectDef.scaleX = 200; // Thickness
				objectDef.scaleY = 100; // Height
				break;

			case 27777:
				objectDef.models = new int[] { 61149, };
				objectDef.name = "Donator Store icon";
				objectDef.length = 2;
				objectDef.width = 2;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { null, null, null, null, null };
				objectDef.mapscene = 3;
				break;
			case 13641:
				objectDef.models = new int[] { 61305, };
				objectDef.name = "Discord icon";
				objectDef.length = 2;
				objectDef.width = 2;
				objectDef.ambient = 25;
				objectDef.actions = new String[] { null, null, null, null, null };
				objectDef.mapscene = 3;
				break;

			case 29333:
				objectDef.name = "Trading post";
				objectDef.actions = new String[] { "Open", null, "Collect", null, null };
				objectDef.models = new int[] { 60884 };
				objectDef.ambient = 25;
				objectDef.sharelight = false;
				objectDef.description = "Buy and sell items with players here!";
				break;

			case 11700:
				objectDef.models = new int[] { 4086 };
				objectDef.name = "Venom";
				objectDef.length = 3;
				objectDef.width = 3;
				objectDef.blockWalk = false;
				objectDef.contouredGround = true;
				objectDef.readyanim = 1261;
				objectDef.recolorToFind = new short[] { 31636 };
				objectDef.recolorToReplace = new short[] { 10543 };
				objectDef.scaleX = 160;
				objectDef.scaleY = 160;
				objectDef.scaleZ = 160;
				objectDef.actions = new String[5];
				// objectDef.description = new String(
				// "It's a cloud of venomous smoke that is extremely toxic.");
				break;

			case 11601: // 11601
				objectDef.textureFind = new short[] { 2 };
				objectDef.textureReplace = new short[] { 46 };
				break;
		}
		if (Client.debugModels) {

			if (objectDef.name == null || objectDef.name.equalsIgnoreCase("null"))
				objectDef.name = "test";

			objectDef.isInteractive = true;
		}
		return objectDef;
	}

	public static void dumpList() {
		try {
			FileWriter fw = new FileWriter("./temp/" + "object_data.json");
			fw.write("[\n");
			for (int i = 0; i < totalObjects; i++) {
				ObjectDefinition def = ObjectDefinition.lookup(i);
				String output = "[\"" + StringUtils.join(def.actions, "\", \"") + "\"],";

				String finalOutput = "	{\n" + "		\"id\": " + def.type + ",\n		" + "\"name\": \"" + def.name
						+ "\",\n		\"models\": " + Arrays.toString(def.models) + ",\n		\"actions\": "
						+ output.replaceAll(", \"\"]", ", \"Examine\"]").replaceAll("\"\"", "null")
								.replace("[\"null\"]", "[null, null, null, null, \"Examine\"]")
								.replaceAll(", \"Remove\"", ", \"Remove\", \"Examine\"")
						+ "	\n		\"width\": " + def.scaleZ + "\n	},";
				fw.write(finalOutput.replaceAll("\"name\": \"null\",", "\"name\": null,"));
				fw.write(System.getProperty("line.separator"));
			}
			fw.write("]");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void setDefaults() {
		models = null;
		shapes = null;
		name = null;
		description = null;
		recolorToFind = null;
		recolorToReplace = null;
		textureFind = null;
		textureReplace = null;
		length = 1;
		width = 1;
		blockWalk = true;
		blocksProjectile = true;
		isInteractive = false;
		contouredGround = false;
		sharelight = false;
		occludes = false;
		readyanim = -1;
		decorDisplacement = 16;
		ambient = 0;
		contrast = 0;
		actions = null;
		minimapFunction = -1;
		mapscene = -1;
		inverted = false;
		castsShadow = true;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		blocksides = 0;
		translateX = 0;
		translateY = 0;
		translateZ = 0;
		obstructsGround = false;
		removeClipping = false;
		supportItems = -1;
		varbitID = -1;
		varpID = -1;
		configs = null;
	}

	public void method574(OnDemandFetcher class42_sub1) {
		if (models == null)
			return;
		for (int j = 0; j < models.length; j++)
			class42_sub1.method560(models[j] & 0xffff, 0);
	}

	public static void nullLoader() {
		baseModels = null;
		recent_models = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static int totalObjects;

	public static void init(FileArchive streamLoader) {
		stream = new Buffer(streamLoader.readFile("loc.dat"));
		Buffer stream = new Buffer(streamLoader.readFile("loc.idx"));
		totalObjects = stream.readUShort();
		streamIndices = new int[totalObjects];
		int i = 2;
		for (int j = 0; j < totalObjects; j++) {
			streamIndices[j] = i;
			i += stream.readUShort();
		}
		cache = new ObjectDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new ObjectDefinition();
	}

	public boolean modelTypeCached(int i) {
		if (shapes == null) {
			if (models == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			Model model = (Model) ObjectDefinition.recent_models.get(type);
			for (int k = 0; k < models.length; k++)
				flag1 &= Model.isCached(models[k] & 0xffff);

			return flag1;
		}
		Model model = (Model) ObjectDefinition.recent_models.get(type);
		for (int j = 0; j < shapes.length; j++)
			if (shapes[j] == i)
				return Model.isCached(models[j] & 0xffff);

		return true;
	}

	public Model modelAt(int type, int orientation, int aY, int bY, int cY, int dY, int frameId, AnimationDefinition seqtype) {
		Model model = model(type, frameId, orientation, seqtype);
		if (model == null)
			return null;
		if (contouredGround || sharelight)
			model = new Model(contouredGround, sharelight, model);
		if (contouredGround) {
			int y = (aY + bY + cY + dY) / 4;
			for (int vertex = 0; vertex < model.vertex_count; vertex++) {
				int x = model.verticesX[vertex];
				int z = model.verticesZ[vertex];
				int l2 = aY + ((bY - aY) * (x + 64)) / 128;
				int i3 = dY + ((cY - dY) * (x + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (z + 64)) / 128;
				model.verticesY[vertex] += j3 - y;
			}

			model.normalise();
			model.resetBounds();
		}
		return model;
	}

	public boolean modelCached() {
		if (models == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < models.length; i++)
			flag1 &= Model.isCached(models[i] & 0xffff);
		return flag1;
	}

	public ObjectDefinition method580() {
		int i = -1;
		if (varpID != -1) {
			VarBit varBit = VarBit.cache[varpID];
			int j = varBit.setting;
			int k = varBit.start;
			int l = varBit.end;
			int i1 = Client.BIT_MASKS[l - k];
			i = clientInstance.variousSettings[j] >> k & i1;
		} else if (varbitID != -1)
			i = clientInstance.variousSettings[varbitID];
		int var3;
		if (i >= 0 && i < configs.length)
			var3 = configs[i];
		else
			var3 = configs[configs.length - 1];
		return var3 == -1 ? null : lookup(var3);
	}

	public Model model(int j, int frame, int l, AnimationDefinition seqtype) {
		Model model = null;
		long l1;
		if (shapes == null) {
			if (j != 10)
				return null;
			l1 = (long) ((type << 6) + l) + ((long) (frame + 1) << 32);
			Model model_1 = (Model) recent_models.get(l1);
			if (model_1 != null) {
				return model_1;
			}
			if (models == null)
				return null;
			boolean flag1 = inverted ^ (l > 3);
			int k1 = models.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = models[i2];
				if (flag1)
					l2 += 0x10000;
				model = (Model) baseModels.get(l2);
				if (model == null) {
					model = Model.getModel(l2 & 0xffff);
					if (model == null)
						return null;
					if (flag1)
						model.mirror();
					baseModels.put(model, l2);
				}
				if (k1 > 1)
					aModelArray741s[i2] = model;
			}

			if (k1 > 1)
				model = new Model(k1, aModelArray741s);
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < shapes.length; j1++) {
				if (shapes[j1] != j)
					continue;
				i1 = j1;
				break;
			}

			if (i1 == -1)
				return null;
			l1 = (long) ((type << 8) + (i1 << 3) + l) + ((long) (frame + 1) << 32);
			Model model_2 = (Model) recent_models.get(l1);
			if (model_2 != null) {
				return model_2;
			}
			if (models == null) {
				return null;
			}
			int j2 = models[i1];
			boolean flag3 = inverted ^ (l > 3);
			if (flag3)
				j2 += 0x10000;
			model = (Model) baseModels.get(j2);
			if (model == null) {
				model = Model.getModel(j2 & 0xffff);
				if (model == null)
					return null;
				if (flag3)
					model.mirror();
				baseModels.put(model, j2);
			}
		}
		boolean flag;
		flag = scaleX != 128 || scaleY != 128 || scaleZ != 128;
		boolean flag2;
		flag2 = translateX != 0 || translateY != 0 || translateZ != 0;
		Model model_3 = new Model(recolorToFind == null,
				AnimFrame.noAnimationInProgress(frame), l == 0 && frame == -1 && !flag
				&& !flag2, textureFind == null, model);
		if (frame != -1) {
			model_3.apply_label_groups();
			model_3.animate_either(seqtype, frame);
			model_3.face_label_groups = null;
			model_3.vertex_label_groups = null;
		}
		while (l-- > 0)
			model_3.rotate90Degrees();

		if (recolorToFind != null) {
			for (int k2 = 0; k2 < recolorToFind.length; k2++)
				model_3.recolor(recolorToFind[k2],
						recolorToReplace[k2]);

		}
		if (textureFind != null) {
			for (int k2 = 0; k2 < textureFind.length; k2++)
				model_3.retexture(textureFind[k2],
						textureReplace[k2]);

		}
		if (flag)
			model_3.scale(scaleX, scaleZ, scaleY);
		if (flag2)
			model_3.offsetBy(translateX, translateY, translateZ);
		model_3.light(85 + ambient, 768 + contrast, -50, -10, -50, !sharelight);
		if (supportItems == 1)
			model_3.itemDropHeight = model_3.modelBaseY;
		recent_models.put(model_3, l1);
		return model_3;
	}

	public int category;
	public int[] ambientSoundIds;
	private int ambientSoundId;
	private boolean randomAnimStart;
	private int ambientSoundMin;
	private int ambientSoundMax;
	public int ambientSoundID;
	public int ambientSoundRange;
	private Map<Integer, Object> params = null;

	public void decode(Buffer buffer) {
		int prev_op = -1;
		while(true) {
			int opcode = buffer.get_unsignedbyte();

			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				int len = buffer.get_unsignedbyte();
				if (len > 0) {
					if (models == null) {
						shapes = new int[len];
						models = new int[len];

						for (int i = 0; i < len; i++) {
							models[i] = buffer.readUShort();
							shapes[i] = buffer.get_unsignedbyte();
						}
					} else {
						buffer.currentPosition += len * 3;
					}
				}
			} else if (opcode == 2) {
				name = buffer.readString();
			} else if (opcode == 5) {
				int len = buffer.get_unsignedbyte();
				if (len > 0) {
					if (models == null) {
						shapes = null;
						models = new int[len];
						for (int i = 0; i < len; i++) {
							models[i] = buffer.readUShort();
						}
					} else {
						buffer.currentPosition += len * 2;
					}
				}
			} else if (opcode == 14) {
				length = buffer.get_unsignedbyte();
			} else if (opcode == 15) {
				width = buffer.get_unsignedbyte();
			} else if (opcode == 17) {
				blockWalk = false;
				blocksProjectile = false;
			} else if (opcode == 18) {
				blocksProjectile = false;
			} else if (opcode == 19) {
				isInteractive = (buffer.get_unsignedbyte() == 1);
			} else if (opcode == 21) {
				contouredGround = true;
			} else if (opcode == 22) {
				sharelight = true;
			} else if (opcode == 23) {
				occludes = true;
			} else if (opcode == 24) {
				readyanim = buffer.readUShort();
				if (readyanim == 0xFFFF) {
					readyanim = -1;
				}
			} else if (opcode == 27) {
				blockWalk = true;
			} else if (opcode == 28) {
				decorDisplacement = buffer.get_unsignedbyte();
			} else if (opcode == 29) {
				ambient = buffer.readSignedByte();
			} else if (opcode == 39) {
				contrast = buffer.readSignedByte() * 25;
			} else if (opcode >= 30 && opcode < 35) {
				if (actions == null) {
					actions = new String[5];
				}
				actions[opcode - 30] = buffer.readString();
				if (actions[opcode - 30].equalsIgnoreCase("Hidden")) {
					actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				int len = buffer.get_unsignedbyte();
				recolorToFind = new short[len];
				recolorToReplace = new short[len];
				for (int i = 0; i < len; i++) {
					recolorToFind[i] = (short) buffer.readUShort();
					recolorToReplace[i] = (short) buffer.readUShort();
				}
			} else if (opcode == 41) {
				int len = buffer.get_unsignedbyte();
				textureFind = new short[len];
				textureReplace = new short[len];
				for (int i = 0; i < len; i++) {
					textureFind[i] = (short) buffer.readUShort();
					textureReplace[i] = (short) buffer.readUShort();
				}
			} else if (opcode == 61) {
				category = buffer.readUShort();
			} else if (opcode == 62) {
				inverted = true;
			} else if (opcode == 64) {
				castsShadow = false;
			} else if (opcode == 65) {
				scaleX = buffer.readUShort();
			} else if (opcode == 66) {
				scaleY = buffer.readUShort();
			} else if (opcode == 67) {
				scaleZ = buffer.readUShort();
			} else if (opcode == 68) {
				mapscene = buffer.readUShort();
			} else if (opcode == 69) {
				blocksides = buffer.get_unsignedbyte();
			} else if (opcode == 70) {
				translateX = buffer.readUShort();
			} else if (opcode == 71) {
				translateY = buffer.readUShort();
			} else if (opcode == 72) {
				translateZ = buffer.readUShort();
			} else if (opcode == 73) {
				obstructsGround = true;
			} else if (opcode == 74) {
				removeClipping = true;
			} else if (opcode == 75) {
				supportItems = buffer.get_unsignedbyte();
			} else if (opcode == 77 || opcode == 92) {
				varpID = buffer.readUShort();

				if (varpID == 0xFFFF) {
					varpID = -1;
				}

				varbitID = buffer.readUShort();

				if (varbitID == 0xFFFF) {
					varbitID = -1;
				}

				int value = -1;

				if (opcode == 92) {
					value = buffer.readUShort();

					if (value == 0xFFFF) {
						value = -1;
					}
				}

				int len = buffer.get_unsignedbyte();

				configs = new int[len + 2];
				for (int i = 0; i <= len; ++i) {
					configs[i] = buffer.readUShort();
					if (configs[i] == 0xFFFF) {
						configs[i] = -1;
					}
				}
				configs[len + 1] = value;
			} else if (opcode == 78) {
				ambientSoundID = buffer.readUShort(); // ambient sound id
				ambientSoundRange = buffer.get_unsignedbyte();
			} else if (opcode == 79) {
				ambientSoundMin = buffer.readUShort();
				ambientSoundMax = buffer.readUShort();
				ambientSoundRange = buffer.get_unsignedbyte();

				int length = buffer.get_unsignedbyte();
				int[] anims = new int[length];

				for (int index = 0; index < length; ++index)
				{
					anims[index] = buffer.readUShort();
				}
				ambientSoundIds = anims;
			} else if (opcode == 81) {
				buffer.get_unsignedbyte();
			} else if (opcode == 82) {
				minimapFunction = buffer.readUShort();
			} else if (opcode == 89) {
				randomAnimStart = true;
			} else if (opcode == 249) {
				int length = buffer.get_unsignedbyte();

				Map<Integer, Object> params = new HashMap<>(length);
				for (int i = 0; i < length; i++)
				{
					boolean isString = buffer.get_unsignedbyte() == 1;
					int key = buffer.read24Int();
					Object value;

					if (isString) {
						value = buffer.readString();
						System.out.println(value);
					} else {
						value = buffer.readInt();
					}

					params.put(key, value);
				}

				this.params = params;
			} else {
				System.err.printf("Error unrecognised {Loc} opcode: %d last %d%n%n", opcode, prev_op);

			}
			prev_op = opcode;

		}

		if (name != null && !name.equals("null")) {
			isInteractive = models != null && (shapes == null || shapes[0] == 10);
			if (actions != null)
				isInteractive = true;
		}

		if (removeClipping) {
			blockWalk = false;
			blocksProjectile = false;
		}

		if (supportItems == -1) {
			supportItems = blockWalk ? 1 : 0;
		}
	}

	private ObjectDefinition() {
		type = -1;
	}

	private short[] textureFind;
	private short[] textureReplace;
	public boolean obstructsGround;
	@SuppressWarnings("unused")
	private int contrast;
	@SuppressWarnings("unused")
	private int ambient;
	private int translateX;
	public String name;
	private int scaleZ;
	private static final Model[] aModelArray741s = new Model[4];
	public int length;
	private int translateY;
	public int minimapFunction;
	private short[] recolorToReplace;
	private int scaleX;
	public int varbitID;
	private boolean inverted;
	public static boolean lowMem;
	private static Buffer stream;
	public int type;
	public static int[] streamIndices;
	public boolean blocksProjectile;
	public int mapscene;
	public int configs[];
	public int supportItems;
	public int width;
	public boolean contouredGround;
	public boolean occludes;
	public static Client clientInstance;
	private boolean removeClipping;
	public boolean blockWalk;
	public int blocksides;
	private boolean sharelight;
	private static int cacheIndex;
	private int scaleY;
	public int[] models;
	public int varpID;
	public int decorDisplacement;
	private int[] shapes;
	public String description;
	public boolean isInteractive;
	public boolean castsShadow;
	public static ReferenceCache recent_models = new ReferenceCache(30);
	public int readyanim;
	private static ObjectDefinition[] cache;
	private int translateZ;
	private short[] recolorToFind;
	public static ReferenceCache baseModels = new ReferenceCache(500);
	public String actions[];

	@Override
	public int getAccessBitMask() {
		return blocksides;
	}

	@Override
	public int getIntValue(int paramID) {
		Object r = params.get(paramID);
		if(r instanceof Integer) {
			return (int) r;
		}
		return -1;
	}

	@Override
	public void setValue(int paramID, int value) {
		params.put(paramID, value);
	}

	@Override
	public String getStringValue(int paramID) {
		Object r = params.get(paramID);
		if(r instanceof String) {
			return (String) r;
		}
		return "";
	}

	@Override
	public void setValue(int paramID, String value) {
		params.put(paramID, value);
	}

	@Override
	public int getId() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String[] getActions() {
		return actions;
	}

	@Override
	public int getMapSceneId() {
		return mapscene;
	}

	@Override
	public int getMapIconId() {
		return minimapFunction;
	}

	@Override
	public int[] getImpostorIds() {
		return configs;
	}

	@Override
	public RSObjectComposition getImpostor() {
		return method580();
	}

	@Override
	public RSIterableNodeHashTable getParams() {
		return null;// client doesnt have iterablenodehashtable
	}

	@Override
	public void setParams(IterableHashTable params) {

	}

	@Override
	public void setParams(RSIterableNodeHashTable params) {

	}

	@Override
	public void decodeNext(RSBuffer buffer, int opcode) {

	}

	@Override
	public int[] getModelIds() {
		return models;
	}

	@Override
	public void setModelIds(int[] modelIds) {
		this.models = new int[modelIds.length];
		System.arraycopy(modelIds, 0, this.models, 0, modelIds.length);
	}

	@Override
	public int[] getModels() {
		return shapes;
	}

	@Override
	public void setModels(int[] models) {
		this.shapes = new int[models.length];
		System.arraycopy(models, 0, this.shapes, 0, models.length);
	}

	@Override
	public boolean getObjectDefinitionIsLowDetail() {
		return lowMem;
	}

	@Override
	public int getSizeX() {
		return length;
	}

	@Override
	public void setSizeX(int sizeX) {
		this.length = sizeX;
	}

	@Override
	public int getSizeY() {
		return width;
	}

	@Override
	public void setSizeY(int sizeY) {
		this.width = sizeY;
	}

	@Override
	public int getInteractType() {
		return blockWalk ? 1 : 0;
	}

	@Override
	public void setInteractType(int interactType) {
		this.blockWalk = interactType == 1;
	}

	@Override
	public boolean getBoolean1() {
		return blocksProjectile;
	}

	@Override
	public void setBoolean1(boolean boolean1) {
		this.blocksProjectile = boolean1;
	}

	@Override
	public int getInt1() {
		return isInteractive ? 1 : 0;
	}

	@Override
	public void setInt1(int int1) {
		this.isInteractive = int1 == 1;
	}

	@Override
	public int getInt2() {
		return decorDisplacement;
	}

	@Override
	public void setInt2(int int2) {
		this.decorDisplacement = int2;
	}

	@Override
	public int getClipType() {
		return contouredGround ? 0 : 1;
	}

	@Override
	public void setClipType(int clipType) {
		this.contouredGround = clipType == 0;
	}

	@Override
	public boolean getNonFlatShading() {
		return sharelight;
	}

	@Override
	public void setNonFlatShading(boolean nonFlatShading) {
		this.sharelight = nonFlatShading;
	}

	@Override
	public void setModelClipped(boolean modelClipped) {
		occludes = modelClipped;
	}

	@Override
	public boolean getModelClipped() {
		return occludes;
	}

	@Override
	public int getAnimationId() {
		return readyanim;
	}

	@Override
	public void setAnimationId(int animationId) {
		this.readyanim = animationId;
	}

	@Override
	public int getAmbient() {
		return ambient;
	}

	@Override
	public void setAmbient(int ambient) {
		this.ambient = ambient;
	}

	@Override
	public int getContrast() {
		return contrast;
	}

	@Override
	public void setContrast(int contrast) {
		this.contrast = contrast;
	}

	@Override
	public short[] getRecolorFrom() {
		return recolorToFind;
	}

	@Override
	public void setRecolorFrom(short[] recolorFrom) {
		this.recolorToFind = new short[recolorFrom.length];
		System.arraycopy(recolorFrom, 0, this.recolorToFind, 0, recolorFrom.length);
	}

	@Override
	public short[] getRecolorTo() {
		return recolorToReplace;
	}

	@Override
	public void setRecolorTo(short[] recolorTo) {
		this.recolorToReplace = new short[recolorTo.length];
		System.arraycopy(recolorTo, 0, this.recolorToReplace, 0, recolorTo.length);
	}

	@Override
	public short[] getRetextureFrom() {
		return textureFind;
	}

	@Override
	public void setRetextureFrom(short[] retextureFrom) {
		this.textureFind = new short[retextureFrom.length];
		System.arraycopy(retextureFrom, 0, this.textureFind, 0, retextureFrom.length);
	}

	@Override
	public short[] getRetextureTo() {
		return textureReplace;
	}

	@Override
	public void setRetextureTo(short[] retextureTo) {
		this.textureReplace = new short[retextureTo.length];
		System.arraycopy(retextureTo, 0, this.textureReplace, 0, retextureTo.length);
	}

	@Override
	public void setIsRotated(boolean rotated) {
		this.inverted = rotated;
	}

	@Override
	public boolean getIsRotated() {
		return inverted;
	}

	@Override
	public void setClipped(boolean clipped) {
		this.castsShadow = clipped;
	}

	@Override
	public boolean getClipped() {
		return castsShadow;
	}

	@Override
	public void setMapSceneId(int mapSceneId) {
		this.mapscene = mapSceneId;
	}

	@Override
	public void setModelSizeX(int modelSizeX) {
		this.scaleX = modelSizeX;
	}

	@Override
	public int getModelSizeX() {
		return scaleX;
	}

	@Override
	public void setModelHeight(int modelHeight) {
		this.scaleY = modelHeight;
	}

	@Override
	public void setModelSizeY(int modelSizeY) {
		this.scaleZ = modelSizeY;
	}

	@Override
	public void setOffsetX(int modelSizeY) {
		this.translateX = modelSizeY;
	}

	@Override
	public void setOffsetHeight(int offsetHeight) {
		this.translateY = offsetHeight;
	}

	@Override
	public void setOffsetY(int offsetY) {
		this.translateZ = offsetY;
	}

	@Override
	public void setInt3(int int3) {
		this.supportItems = int3;
	}

	@Override
	public void setInt5(int int5) {
		this.ambientSoundMin = int5;
	}

	@Override
	public void setInt6(int int6) {
		this.ambientSoundMax = int6;
	}

	@Override
	public void setInt7(int int7) {
		this.ambientSoundRange = int7;
	}

	@Override
	public void setBoolean2(boolean boolean2) {
		this.obstructsGround = boolean2;
	}

	@Override
	public void setIsSolid(boolean isSolid) {
		this.removeClipping = isSolid;
	}

	@Override
	public void setAmbientSoundId(int ambientSoundId) {
		this.ambientSoundID = ambientSoundId;
	}

	@Override
	public void setSoundEffectIds(int[] soundEffectIds) {
		this.ambientSoundIds = new int[soundEffectIds.length];
		System.arraycopy(soundEffectIds, 0, this.ambientSoundIds, 0, soundEffectIds.length);
	}

	@Override
	public int[] getSoundEffectIds() {
		return ambientSoundIds;
	}

	@Override
	public void setMapIconId(int mapIconId) {
		this.minimapFunction = mapIconId;
	}

	@Override
	public void setBoolean3(boolean boolean3) {
		this.randomAnimStart = !boolean3;
	}

	@Override
	public void setTransformVarbit(int transformVarbit) {
		this.varbitID = transformVarbit;
	}

	@Override
	public int getTransformVarbit() {
		return varbitID;
	}

	@Override
	public void setTransformVarp(int transformVarp) {
		this.varpID = transformVarp;
	}

	@Override
	public int getTransformVarp() {
		return varpID;
	}

	@Override
	public void setTransforms(int[] transforms) {
		this.configs = new int[transforms.length];
		System.arraycopy(transforms, 0, this.configs, 0, transforms.length);
	}

	@Override
	public int[] getTransforms() {
		return configs;
	}
}