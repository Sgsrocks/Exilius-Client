package com.client.definitions;

import com.client.*;
import com.client.definitions.custom.ItemDefinition_Sub1;
import com.client.definitions.custom.ItemDefinition_Sub2;
import com.client.definitions.custom.ItemDefinition_Sub3;
import com.client.utilities.FileOperations;
import com.google.common.base.Preconditions;
import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSItemComposition;
import net.runelite.rs.api.RSIterableNodeHashTable;

import java.util.HashMap;

public final class ItemDefinition implements RSItemComposition {

    public static ReferenceCache sprites = new ReferenceCache(100);
    public static ReferenceCache models = new ReferenceCache(50);
    public static boolean isMembers = true;
    public static int totalItems;
    public static ItemDefinition[] cache;
    private static int cacheIndex;
    private static Buffer1 item_data;
    private static int[] streamIndices;
    public int value;
    public int[] originalModelColors;
    public int id;
    public int[] modifiedModelColors;
    public boolean members;
    public int certTemplateID;
    public int wearpos = -1;
    public int wearpos2 = -1;
    public int wearpos3 = -1;
    public int secondaryFemaleModel;
    public int primaryMaleModel;
    public String[] groundActions;
    public int spriteTranslateX;
    public String name;
    public int modelId;
    public int primaryMaleHeadPiece;
    public boolean stackable;
    public int certID;
    public int spriteScale;
    public int secondaryMaleModel;
    public String[] itemActions;
    public int spritePitch;
    public int[] stackIDs;
    public int spriteTranslateY;//
    public int primaryFemaleHeadPiece;
    public int spriteCameraRoll;
    public int primaryFemaleModel;
    public int[] stackAmounts;
    public int team;
    public int spriteCameraYaw;
    public String[] equipActions;
    public boolean searchable;
    public int weight = 0;
    public HashMap<Integer, Object> params;
    public int glowColor = -1;
    private short[] modifiedTextureColors;
    private short[] originalTextureColors;
    private int femaleTranslation = 0;
    private int tertiaryFemaleEquipmentModel;
    private int secondaryMaleHeadPiece;
    private int groundScaleX;
    private int secondaryFemaleHeadPiece;
    private int contrast;
    private int tertiaryMaleEquipmentModel;
    private int groundScaleZ;
    private int groundScaleY;
    private int ambient;
    private int maleTranslation = 0;
    private int shiftClickIndex = -2;
    private int category;
    public int unnotedId;
    public int notedId;
    public int placeholderId;
    public int placeholderTemplateId;
    public String description;

    private ItemDefinition() {
        id = -1;
    }

    public static void clear() {
        models = null;
        sprites = null;
        streamIndices = null;
        cache = null;
        item_data = null;
    }

    public static void init(FileArchive archive) {
        item_data = new Buffer1(archive.readFile("obj.dat"));
        Buffer1 stream = new Buffer1(archive.readFile("obj.idx"));

        totalItems = stream.readUShort();
        streamIndices = new int[totalItems + 20_000];
        int offset = 2;

        for (int _ctr = 0; _ctr < totalItems; _ctr++) {
            streamIndices[_ctr] = offset;
            offset += stream.readUShort();
        }

        cache = new ItemDefinition[10];

        for (int _ctr = 0; _ctr < 10; _ctr++) {
            cache[_ctr] = new ItemDefinition();
        }

        System.out.println("Loaded: " + totalItems + " items");
    }
    private static ItemDefinition newCustomItems(int itemId) {
        ItemDefinition itemDef = new ItemDefinition();
        itemDef.setDefaults();
        switch (itemId) {
            case 30000:
                return copy(itemDef, 30_000, 11738, "Resource box(small)", "Open");
            case 30001:
                return copy(itemDef, 30_001, 11738, "Resource box(medium)", "Open");
            case 30002:
                return copy(itemDef, 30_002, 11738, "Resource box(large)", "Open");
            case 22375:
                return copy(itemDef, 22375, 22374, "Mossy key");
            case 22689:
                return copy(itemDef, 22689, 0, "Null");
            case 22690:
                return copy(itemDef, 22690, 0, "Null");
            case 22692:
                return copy(itemDef, 22692, 0, "Null");
            case 22693:
                return copy(itemDef, 22693, 0, "Null");
            case 22695:
                return copy(itemDef, 22695, 0, "Null");
            case 22696:
                return copy(itemDef, 22696, 0, "Null");
            case 22698:
                return copy(itemDef, 22698, 0, "Null");
            case 22699:
                return copy(itemDef, 22699, 0, "Null");
            case 22701:
                return copy(itemDef, 22701, 0, "Null");
            case 22702:
                return copy(itemDef, 22702, 0, "Null");
            case 33056:
                itemDef.setDefaults();
                itemDef.id = 33056;
                itemDef.modelId = 65270;
                itemDef.name = "Completionist cape";
                itemDef.description = "A cape worn by those who've overachieved.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 65297;
                itemDef.primaryFemaleModel = 65316;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Teleports";
                itemDef.itemActions[3] = "Features";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 33057:
                itemDef.setDefaults();
                itemDef.id = 33057;
                itemDef.modelId = 65273;
                itemDef.name = "Completionist hood";
                itemDef.description = "A hood worn by those who've over achieved.";

                itemDef.spriteScale = 760;
                itemDef.spritePitch = 11;
                itemDef.spriteCameraRoll = 0;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 0;

                itemDef.primaryMaleModel = 65292;
                itemDef.primaryFemaleModel = 65310;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                return itemDef;
            case 8817:
                itemDef.setDefaults();
                itemDef.id = 8817;
                itemDef.modelId = 52300;
                itemDef.name = "scythe of Osiris";
                itemDef.description = "A scythe for the finest.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 52300;
                itemDef.primaryFemaleModel = 52300;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29499:
                itemDef.setDefaults();
                itemDef.id = 29499;
                itemDef.modelId = 52401;
                itemDef.name = "Lava Scythe";
                itemDef.description = "A scythe from lava.";
                itemDef.spriteScale = 2105;
                itemDef.spritePitch = 327;
                itemDef.spriteCameraRoll = 23;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 1;
                itemDef.spriteTranslateY = 17;

                itemDef.primaryMaleModel = 52400;
                itemDef.primaryFemaleModel = 52400;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29047:
                itemDef.setDefaults();
                itemDef.id = 29047;
                itemDef.modelId = 55742;
                itemDef.name = "Ice Scythe";
                itemDef.description = "A scythe from Ice.";
                itemDef.spriteScale = 2105;
                itemDef.spritePitch = 327;
                itemDef.spriteCameraRoll = 23;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 1;
                itemDef.spriteTranslateY = 17;

                itemDef.primaryMaleModel = 52906;
                itemDef.primaryFemaleModel = 52906;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;

            case 29180:
                itemDef.setDefaults();
                itemDef.id = 29180;
                itemDef.modelId = 50000;
                itemDef.name = "Osiris Chainmace";
                itemDef.description = "A Mace From Hell.";
                itemDef.spriteScale = 2105;
                itemDef.spritePitch = 23;
                itemDef.spriteCameraRoll = 327;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 1;
                itemDef.spriteTranslateY = 17;

                itemDef.primaryMaleModel = 50000;
                itemDef.primaryFemaleModel = 50000;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;

            case 8029:
                itemDef.setDefaults();
                itemDef.id = 8029;
                itemDef.modelId = 65266;
                itemDef.name = "Godly Twisted Bow";
                itemDef.description = "Godly T'Bow.";
                itemDef.spriteScale = 1814;
                itemDef.spritePitch = 23;
                itemDef.spriteCameraRoll = 720;
                itemDef.spriteCameraYaw = 1500;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 1;

                itemDef.primaryMaleModel = 65267;
                itemDef.primaryFemaleModel = 65267;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 8813:
                itemDef.setDefaults();
                itemDef.id = 8813;
                itemDef.modelId = 65132;
                itemDef.name = "Lava Torva Platebody";
                itemDef.description = "A body from lava.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2042;
                itemDef.spriteCameraRoll = 473;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -1;

                itemDef.primaryMaleModel = 65133;
                itemDef.secondaryMaleModel = 65129;
                itemDef.primaryFemaleModel = 65133;
                itemDef.secondaryFemaleModel = 65129;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 8812:
                itemDef.setDefaults();
                itemDef.id = 8812;
                itemDef.modelId = 65134;
                itemDef.name = "Lava Torva Platelegs";
                itemDef.description = "Platelegs made from lava.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2045;
                itemDef.spriteCameraRoll = 474;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = 8;

                itemDef.primaryMaleModel = 65135;
                itemDef.primaryFemaleModel = 65135;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 8814:
                itemDef.setDefaults();
                itemDef.id = 8814;
                itemDef.modelId = 65130;
                itemDef.name = "Lava Torva Full Helm";
                itemDef.description = "A Helm from lava.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 1867;
                itemDef.spriteCameraRoll = 85;
                itemDef.spriteCameraYaw = 1;
                //itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -2;
                itemDef.itemActions = new String[5];
                itemDef.primaryMaleModel = 65131;
                itemDef.primaryFemaleModel = 65131;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 19498:
                itemDef.setDefaults();
                itemDef.id = 19498;
                itemDef.modelId = 65145;
                itemDef.name = "Mike's Torva Platebody";
                itemDef.description = "Mike's plate.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2042;
                itemDef.spriteCameraRoll = 473;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -1;

                itemDef.primaryMaleModel = 65146;
                itemDef.secondaryMaleModel = 65147;
                itemDef.primaryFemaleModel = 65146;
                itemDef.secondaryFemaleModel = 65147;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29377:
                itemDef.setDefaults();
                itemDef.id = 29377;
                itemDef.modelId = 65248;
                itemDef.name = "Godly Torva Platebody";
                itemDef.description = "Godly plate.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2042;
                itemDef.spriteCameraRoll = 473;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -1;

                itemDef.primaryMaleModel = 65247;
                itemDef.secondaryMaleModel = 65246;
                itemDef.primaryFemaleModel = 65247;
                itemDef.secondaryFemaleModel = 65246;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 19495:
                itemDef.setDefaults();
                itemDef.id = 19495;
                itemDef.modelId = 65148;
                itemDef.name = "Mike's Torva Platelegs";
                itemDef.description = "Mike's Platelegs made from lava.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2045;
                itemDef.spriteCameraRoll = 474;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = 8;

                itemDef.primaryMaleModel = 65149;
                itemDef.primaryFemaleModel = 65149;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29376:
                itemDef.setDefaults();
                itemDef.id = 29376;
                itemDef.modelId = 65249;
                itemDef.name = "Godly Torva Platelegs";
                itemDef.description = "Godly Platelegs made from lava.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 2045;
                itemDef.spriteCameraRoll = 474;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = 8;

                itemDef.primaryMaleModel = 65251;
                itemDef.primaryFemaleModel = 65251;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29380:
                itemDef.setDefaults();
                itemDef.id = 29380;
                itemDef.modelId = 65350;
                itemDef.name = "Godly Masori Chaps";
                itemDef.description = "Godly Chaps made from the gods.";
                itemDef.spriteScale = 1033;
                itemDef.spritePitch = 102;
                itemDef.spriteCameraRoll = 41;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = -2;
                itemDef.spriteTranslateY = -3;

                itemDef.primaryMaleModel = 65351;
                itemDef.primaryFemaleModel = 65351;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29382:
                itemDef.setDefaults();
                itemDef.id = 29382;
                itemDef.modelId = 65352;
                itemDef.name = "Godly Masori Body";
                itemDef.description = "Godly Body made from the gods.";
                itemDef.spriteScale = 1240;
                itemDef.spritePitch = 102;
                itemDef.spriteCameraRoll = 453;
                itemDef.spriteCameraYaw = 0;
                //itemDef.spriteTranslateX = -2;
                itemDef.spriteTranslateY = 11;

                itemDef.primaryMaleModel = 65353;
                itemDef.primaryFemaleModel = 65353;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29381:
                itemDef.setDefaults();
                itemDef.id = 29381;
                itemDef.modelId = 65354;
                itemDef.name = "Godly Masori Mask";
                itemDef.description = "Godly Mask made from the gods.";
                //	itemDef.spriteScale = 1240;
                itemDef.spritePitch = 102;
                itemDef.spriteCameraRoll = 555;
                itemDef.spriteCameraYaw = 0;
                //itemDef.spriteTranslateX = -2;
                itemDef.spriteTranslateY = 4;

                itemDef.primaryMaleModel = 65355;
                itemDef.primaryFemaleModel = 65355;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 19483:
                itemDef.setDefaults();
                itemDef.id = 19483;
                itemDef.modelId = 65150;
                itemDef.name = "Mike's Torva Full Helm";
                itemDef.description = "Mike's Torva Full Helm.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 1867;
                itemDef.spriteCameraRoll = 85;
                itemDef.spriteCameraYaw = 1;
                //itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -2;
                itemDef.itemActions = new String[5];
                itemDef.primaryMaleModel = 65151;
                itemDef.primaryFemaleModel = 65151;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29378:
                itemDef.setDefaults();
                itemDef.id = 29378;
                itemDef.modelId = 65255;
                itemDef.name = "Godly Torva Full Helm";
                itemDef.description = "Godly Torva Full Helm.";
                itemDef.spriteScale = 1780;
                itemDef.spritePitch = 1867;
                itemDef.spriteCameraRoll = 85;
                itemDef.spriteCameraYaw = 1;
                //itemDef.spriteTranslateX = -1;
                itemDef.spriteTranslateY = -2;
                itemDef.itemActions = new String[5];
                itemDef.primaryMaleModel = 65254;
                itemDef.primaryFemaleModel = 65254;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 4371:
                itemDef.setDefaults();
                itemDef.id = 4371;
                itemDef.modelId = 56670;
                itemDef.name = "Admin Cape";
                itemDef.description = "A Cape for the finest.";
                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;
                itemDef.primaryMaleModel = 56670;
                itemDef.primaryFemaleModel = 56670;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Teleports";
                itemDef.itemActions[3] = "Features";
                itemDef.itemActions[4] = "Drop";
                return itemDef;
            case 29230:
                itemDef.setDefaults();
                itemDef.id = 29230;
                itemDef.modelId = 50500;
                itemDef.name = "burning skeleteon boots";
                itemDef.description = "spooky skeleton.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 50500;
                itemDef.primaryFemaleModel = 50500;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Drop";
                return itemDef;
            case 29231:
                itemDef.setDefaults();
                itemDef.id = 29231;
                itemDef.modelId = 50501;
                itemDef.name = "Burning skeleteon Gloves";
                itemDef.description = "spooky skeleton.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 50501;
                itemDef.primaryFemaleModel = 50501;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Drop";
                return itemDef;
            case 29232:
                itemDef.setDefaults();
                itemDef.id = 29232;
                itemDef.modelId = 50502;
                itemDef.name = "Burning skeleteon mask";
                itemDef.description = "spooky skeleton.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 50502;
                itemDef.primaryFemaleModel = 50502;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Drop";
                return itemDef;
            case 29233:
                itemDef.setDefaults();
                itemDef.id = 29233;
                itemDef.modelId = 50503;
                itemDef.name = "Burning skeleteon leggings";
                itemDef.description = "spooky skeleton.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 50503;
                itemDef.primaryFemaleModel = 50503;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Drop";
                return itemDef;
            case 29234:
                itemDef.setDefaults();
                itemDef.id = 29234;
                itemDef.modelId = 50505;
                itemDef.name = "Burning skeleteon Skirt";
                itemDef.description = "spooky skeleton.";

                itemDef.spriteScale = 1385;
                itemDef.spritePitch = 279;
                itemDef.spriteCameraRoll = 948;
                itemDef.spriteCameraYaw = 0;
                itemDef.spriteTranslateX = 0;
                itemDef.spriteTranslateY = 24;

                itemDef.primaryMaleModel = 50505;
                itemDef.secondaryMaleModel = 50504;
                itemDef.primaryFemaleModel = 50505;
                itemDef.secondaryFemaleModel = 50504;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = "Drop";
                return itemDef;
        }

        return null;
    }

    private static void customItems(int itemId) {
        ItemDefinition itemDef = lookup(itemId);
        switch (itemId) {
            case 21726:
            case 21728:
                itemDef.stackable = true;
                break;
            case 12863:
                itemDef.itemActions = new String[] { "Open", null, null, null, null};
                break;
            case 13092: //this makes crystal halberds wieldable, weird af.
            case 13093:
            case 13094:
            case 13095:
            case 13096:
            case 13097:
            case 13098:
            case 13099:
            case 13100:
            case 13101:
                itemDef.itemActions = new String[] { null, "Wield", null, null, null};
                break;
            case 23933:
                itemDef.name = "Vote crystal";
                break;
            case 9698:
                itemDef.name = "Unfired burning rune";
                itemDef.description = "I should burn this.";
                itemDef.createCustomSprite("Unfired_burning_rune.png");
                itemDef.stackable = true;
                break;
            case 9699:
                itemDef.name = "Burning rune";
                itemDef.description = "Hot to the touch.";
                itemDef.createCustomSprite("Burning_rune.png");
                itemDef.stackable = true;
                break;
            case 23778:
                itemDef.name = "Uncut toxic gem";
                itemDef.description = "I should use a chisel on this.";
                break;
            case 22374:
                itemDef.name = "Hespori key";
                itemDef.description = "Can be used on the Hespori chest.";
                break;
            case 3460:
                itemDef.name = "@bla@Nex @red@key";
                break;
            case 23783:
                itemDef.name = "Toxic gem";
                itemDef.description = "I should be careful with this.";
                break;
            case 9017:
                itemDef.name = "Hespori essence";
                itemDef.description = "Maybe I should burn this.";
                itemDef.itemActions = new String[] {  null, null, null, null, "Drop" };
                break;
            case 19473:
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 10556:
            case 10557:
            case 10558:
            case 10559:
                itemDef.itemActions = new String[] { null, "Wear", "Feature", null, "Drop" };
                break;
            case 21898:
                itemDef.itemActions = new String[] { null, "Wear", "Teleports", "Features", null };
                break;
            case 12873:
            case 12875:
            case 12877:
            case 12879:
            case 12881:
            case 12883:
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 23804:
                itemDef.name = "Imbue Dust";
                break;
            case 22517:
                itemDef.name = "Crystal Shard";
                break;
            case 23951:
                itemDef.name = "Crystalline Key";
                break;
            case 691:
                itemDef.name = "@gre@10,000 FoE Point Certificate";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 692:
                itemDef.name = "@red@25,000 FoE Point Certificate";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 693:
                itemDef.name = "@cya@50,000 FoE Point Certificate";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 696:
                itemDef.name = "@yel@250,000 FoE Point Certificate";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 23877:
                itemDef.name = "Crystal Shard";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = true;
                break;
            case 23943:
                itemDef.itemActions = new String[] { null, "Wear", "Uncharge", "Check", "Drop" };
                break;
            case 2996:
                itemDef.name = "@red@PKP Ticket";
                break;
            case 23776:
                itemDef.name = "@red@Hunllef's Key";
                break;
            case 13148:
                itemDef.name = "@red@Reset Lamp";
                break;
            case 6792:
                itemDef.name = "@red@Seren's Key";
                break;
            case 4185:
                itemDef.name = "@red@Porazdir's Key";
                break;
            case 21880:
                itemDef.name = "Wrath Rune";
                itemDef.value = 1930;
                break;
            case 12885:
            case 13277:
            case 19701:
            case 13245:
            case 12007:
            case 22106:
            case 12936:
            case 24495:
                itemDef.itemActions = new String[] { null, null, "Open", null, "Drop" };
                break;
            case 21262:
                itemDef.name = "Vote Genie Pet";
                itemDef.itemActions = new String[] { null, null, null, null, "Release" };
                break;
            case 21817:
                itemDef.itemActions = new String[] { null, "Wear", "Dismantle", null, null, };
                break;
            case 21347:
                itemDef.itemActions = new String[] { null, null, null, "Chisel-Options", null, };
                break;
            case 21259:
                itemDef.name = "@red@Name Change Scroll";
                itemDef.itemActions = new String[] { null, null, "Read", null, null, };
                break;
            case 22547:
            case 22552:
            case 22542:
                itemDef.itemActions = new String[] { null, null, null, null, null, };
                break;
            case 22555:
            case 22550:
            case 22545:
                itemDef.itemActions = new String[] { null, "Wield", "Check", "Uncharge", null, };
                break;
            case 732:
                itemDef.name = "@blu@Imbuedeifer";
                itemDef.value = 1930;
                break;
            case 21881:
                itemDef.name = "Wrath Rune";
                itemDef.value = 1930;
                break;
            case 13226:
                itemDef.name = "Herb Sack";
                itemDef.description = "Thats a nice looking sack.";
                break;
            case 3456:
                itemDef.name = "@whi@Common Raids Key";
                itemDef.description = "Can be used on the storage unit.";
                break;
            case 3464:
                itemDef.name = "@pur@Rare Raids Key";
                itemDef.description = "Can be used on the storage unit.";
                break;
            case 6829:
                itemDef.name = "@red@YT Video Giveaway Box";
                itemDef.description = "Spawns items to giveaway for your youtube video.";
                itemDef.itemActions = new String[] { "Giveaway", null, null, null, "Drop" };
                break;
            case 6831:
                itemDef.name = "@red@YT Video Giveaway Box (t2)";
                itemDef.description = "Spawns items to giveaway for your youtube video.";
                itemDef.itemActions = new String[] { "Giveaway", null, null, null, "Drop" };

                break;
            case 6832:
                itemDef.name = "@red@YT Stream Giveaway Box";
                itemDef.description = "Spawns items to giveaway for your youtube stream.";
                itemDef.itemActions = new String[] { "Giveaway", null, null, null, "Drop" };

                break;
            case 6833:
                itemDef.name = "@red@YT Stream Giveaway Box (t2)";
                itemDef.description = "Spawns items to giveaway for your youtube stream.";
                itemDef.itemActions = new String[] { "Giveaway", null, null, null, "Drop" };

                break;
            case 13190:
                itemDef.name = "@yel@100m OSRS GP";
                itemDef.itemActions = new String[] { "Redeem", null, null, null, "Drop" };
                itemDef.description = "Redeem for 100m OSRS GP!";
                break;
            case 6121:
                itemDef.name = "Break Vials Instruction";
                itemDef.description = "How does one break a vial, its impossible?";
                break;
            case 2528:
                itemDef.name = "@red@Experience Lamp";
                itemDef.description = "Should I rub it......";
                break;
            case 5509:
                itemDef.name = "Small Pouch";
                itemDef.createCustomSprite("Small_pouch.png");
                itemDef.itemActions = new String[] { "Fill", "Empty", "Check", null, null };
                break;
            case 5510:
                itemDef.name = "Medium Pouch";
                itemDef.createCustomSprite("Medium_pouch.png");
                itemDef.itemActions = new String[] { "Fill", "Empty", "Check", null, null };
                break;
            case 5512:
                itemDef.name = "Large Pouch";
                itemDef.createCustomSprite("Large_pouch.png");
                itemDef.itemActions = new String[] { "Fill", "Empty", "Check", null, null };
                break;
            case 10724: //full skeleton
            case 10725:
            case 10726:
            case 10727:
            case 10728:
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 5514:
                itemDef.name = "Giant Pouch";
                itemDef.createCustomSprite("Giant_pouch.png");
                break;
            case 22610: //vesta spear
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 22613: //vesta longsword
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 22504: //stat warhammer
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 4224:
            case 4225:
            case 4226:
            case 4227:
            case 4228:
            case 4229:
            case 4230:
            case 4231:
            case 4232:
            case 4233:
            case 4234:
            case 4235://crystal sheild
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 4212:
            case 4214:
            case 4215:
            case 4216:
            case 4217:
            case 4218:
            case 4219:
            case 4220:
            case 4221:
            case 4222:
            case 4223:
                itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
                break;
            case 2841:
                itemDef.name = "@red@Bonus Exp Scroll";
                itemDef.itemActions = new String[] { "@yel@Activate", null, null, null, "Drop" };
                itemDef.description = "You will get double experience using this scroll.";
                break;
            case 21791:
            case 21793:
            case 21795:
                itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
                break;
            case 19841:
                itemDef.name = "Master Casket";
                break;
            case 21034:
                itemDef.itemActions = new String[] { "Read", null, null, null, "Drop" };
                break;
            case 6830:
                itemDef.name = "@red@raids 2 mbox";
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 10025:
                itemDef.name = "@dre@raids 1 mbox";
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 21079:
                itemDef.itemActions = new String[] { "Read", null, null, null, "Drop" };
                break;
            case 22093:
                itemDef.name = "@gre@Vote Streak Key";
                itemDef.description = "Thanks for voting!";
                break;
            case 22885:
                itemDef.name = "@gre@Kronos seed";
                itemDef.description = "Provides whole server with bonus xp for 1 skill for 5 hours!";
                break;
            case 23824:
                itemDef.name = "Slaughter charge";
                itemDef.description = "Can be used on bracelet of slaughter to charge it.";
                break;
            case 22883:
                itemDef.name = "@gre@Iasor seed";
                itemDef.description = "Increased drop rate (+10%) for whole server for 5 hours!";
                break;
            case 22881:
                itemDef.name = "@gre@Attas seed";
                itemDef.description = "Provides the whole server with bonus xp for 5 hours!";
                break;
            case 20906:
                itemDef.name = "@gre@Golpar seed";
                itemDef.description = "Provides whole server with double c keys, resource boxes, coin bags, and clues!";
                break;
            case 6112:
                itemDef.name = "@gre@Kelda seed";
                itemDef.description = "Provides whole server with x2 Larren's keys for 1 hour!";
                break;
            case 20903:
                itemDef.name = "@gre@Noxifer seed";
                itemDef.description = "Provides whole server with x2 Slayer points for 1 hour!";
                break;
            case 20909:
                itemDef.name = "@gre@Buchu seed";
                itemDef.description = "Provides whole server with x2 Boss points for 1 hour!";
                break;
            case 22869:
                itemDef.name = "@gre@Celastrus seed";
                itemDef.description = "Provides whole server with x2 Brimstone keys for 1 hour!";
                break;
            case 4205:
                itemDef.name = "@gre@Consecration seed";
                itemDef.description = "Provides the whole server with +5 PC points for 1 hour.";
                itemDef.stackable = true;
                break;
            case 11864:
            case 11865:
            case 19639:
            case 19641:
            case 19643:
            case 19645:
            case 19647:
            case 19649:
            case 24444:
            case 24370:
            case 23075:
            case 23073:
            case 21888:
            case 21890:
            case 21264:
            case 21266:
                itemDef.equipActions[2] = "Log";
                itemDef.equipActions[1] = "Check";
                break;
            case 13136:
                itemDef.equipActions[2] = "Elidinis";
                itemDef.equipActions[1] = "Kalphite Hive";
                break;
            case 2550:
                itemDef.equipActions[2] = "Check";
                break;

            case 1712:
            case 1710:
            case 1708:
            case 1706:
            case 19707:
                itemDef.equipActions[1] = "Edgeville";
                itemDef.equipActions[2] = "Karamja";
                itemDef.equipActions[3] = "Draynor";
                itemDef.equipActions[4] = "Al-Kharid";
                break;
            case 21816:
                itemDef.itemActions = new String[] { null, "Wear", "Uncharge", null, "Drop" };
                itemDef.equipActions[1] = "Check";
                itemDef.equipActions[2] = "Toggle-absorption";
                break;
            case 2552:
            case 2554:
            case 2556:
            case 2558:
            case 2560:
            case 2562:
            case 2564:
            case 2566: // Ring of duelling
                itemDef.equipActions[2] = "Shantay Pass";
                itemDef.equipActions[1] = "Clan wars";
                break;
            case 11739:
                itemDef.name = "@gre@Vote Mystery Box";
                itemDef.description = "Probably contains cosmetics, or maybe not...";
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 6828:
                itemDef.name = "Super Mystery Box";
                itemDef.description = "Mystery box that contains goodies.";
                itemDef.itemActions = new String[] { "Open", null, "View-Loots", "Quick-Open", "Drop" };
                itemDef.createCustomSprite("Mystery_Box.png");
                itemDef.createSmallCustomSprite("Mystery_Box_Small.png");
                itemDef.stackable = false;
                break;
            case 30010:
                itemDef.setDefaults();
                itemDef.name = "Postie Pete";
                itemDef.description = "50% chance to pick up crystal keys that drop.";
                itemDef.createCustomSprite("Postie_Pete.png");
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                break;
            case 30011:
                itemDef.setDefaults();
                itemDef.name = "Imp";
                itemDef.description = "50% chance to pick up clue scrolls that drop.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Imp.png");
                break;
            case 30012:
                itemDef.setDefaults();
                itemDef.name = "Toucan";
                itemDef.description = "50% chance to pick up resource packs.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Toucan.png");
                break;
            case 30013:
                itemDef.setDefaults();
                itemDef.name = "Penguin King";
                itemDef.description = "50% chance to auto-pick up coin bags.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Penguin_King.png");
                break;
            case 30014:
                itemDef.setDefaults();
                itemDef.name = "K'klik";
                itemDef.description = "An extra 5% in drop rate boost.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("K'klik.png");
                break;
            case 30015:
                itemDef.setDefaults();
                itemDef.name = "Shadow warrior";
                itemDef.description = "50% chance for an additional +10% strength bonus in pvm.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_warrior.png");
                break;
            case 30016:
                itemDef.setDefaults();
                itemDef.name = "Shadow archer";
                itemDef.description = "50% chance for an additional +10% range str bonus in PvM.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_archer.png");
                break;
            case 30017:
                itemDef.setDefaults();
                itemDef.name = "Shadow wizard";
                itemDef.description = "50% chance for an additional +10% mage str bonus in PvM.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_wizard.png");
                break;
            case 30018:
                itemDef.setDefaults();
                itemDef.name = "Healer Death Spawn";
                itemDef.description = "5% chance hit restores HP.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Healer_Death_Spawn.png");
                break;
            case 30019:
                itemDef.setDefaults();
                itemDef.name = "Holy Death Spawn";
                itemDef.description = "5% chance 1/2 of your hit is restored into prayer.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Holy_Death_Spawn.png");
                break;
            case 30020:
                itemDef.setDefaults();
                itemDef.name = "Corrupt beast";
                itemDef.description = "50% chance for an additional +10% strength bonus for melee, mage, and range in pvm.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Corrupt_beast.png");
                break;
            case 30021:
                itemDef.setDefaults();
                itemDef.name = "Roc";
                itemDef.description = "An extra 10% in drop rate boost.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Roc.png");
                break;
            case 30022:
                itemDef.setDefaults();
                itemDef.name = "@red@Kratos";
                itemDef.description = "The most powerful pet, see ::foepets for full list of perks.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Yama.png");
                break;
            case 30023:
                itemDef.setDefaults();
                itemDef.name = "Rain cloud";
                itemDef.description = "Don't worry be happy.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("Rain_cloud.png");
                break;
            case 8866:
                itemDef.name = "Storage chest key (UIM)";
                itemDef.description = "Used to open the UIM storage chest 1 time.";
                itemDef.stackable = true;
                break;
            case 8868:
                itemDef.name = "Perm. storage chest key (UIM)";
                itemDef.description = "Permanently unlocks UIM storage chest.";
                break;
            case 771:
                itemDef.name = "@cya@Ancient branch";
                itemDef.description = "Burning items in the FoE with this branch provides a 1 time +10% FoE value increase.";
                break;
            case 6199:
                itemDef.name = "Mystery Box";
                itemDef.description = "Mystery box that contains goodies.";
                itemDef.itemActions = new String[] { "Open", null, null, "Quick-Open", "Drop" };
                break;
            case 12789:
                itemDef.name = "@red@Youtube Mystery Box";
                itemDef.description = "Mystery box that contains goodies.";
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 13346:
                itemDef.name = "Ultra Mystery Box";
                itemDef.itemActions = new String[] { "Open", null, null, "Quick-Open", "Drop" };
                break;
            case 8167:
                itemDef.name = "@or2@FoE Mystery Chest @red@(locked)";
                itemDef.itemActions = new String[] { "Unlock", null, null, "Quick-Open", "Drop" };
                break;
            case 13438:
                itemDef.name = "Slayer Mystery Chest";
                itemDef.itemActions = new String[] { "Open", null, null, null, "Drop" };
                break;
            case 2399:
                itemDef.name = "@or2@FoE Mystery Key";
                itemDef.description = "Used to unlock the FoE Mystery Chest.";
                break;
            case 10832:
                itemDef.name = "Small coin bag";
                itemDef.itemActions = new String[] { "Open", null, "Open-All", null, "Drop" };
                itemDef.description = "I can see some coins inside.";
                break;
            case 10833:
                itemDef.name = "Medium coin bag";
                itemDef.itemActions = new String[] { "Open", null, "Open-All", null, "Drop" };
                itemDef.description = "I can see some coins inside.";
                break;
            case 26500:
                itemDef.name = "Battle Pass";
                itemDef.itemActions = new String[] { "Redeem", null, null, null, null};
                itemDef.description = "Redeem this pass to unlock the premium rewards.";
                break;
            case 26502:
                itemDef.name = "Battle Pass";
                itemDef.itemActions = new String[] { "Redeem", null, null, null, null};
                itemDef.description = "Redeem this pass to unlock the premium rewards.";
                break;
            case 10834:
                itemDef.name = "Large coin bag";
                itemDef.itemActions = new String[] { "Open", null, "Open-All", null, "Drop" };
                itemDef.description = "I can see some coins inside.";
                break;
            case 22316:
                itemDef.name = "Sword of Exilius";
                itemDef.description = "The Sword of Exilius.";
                break;
            case 19942:
                itemDef.name = "Lil Mimic";
                itemDef.description = "It's a lil mimic.";
                break;
            case 30110:
                itemDef.setDefaults();
                itemDef.name = "Dark postie pete";
                itemDef.description = "Picks up all crystal keys and 25% chance to double.";
                itemDef.createCustomSprite("dark_Postie_Pete.png");
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                break;
            case 30111:
                itemDef.setDefaults();
                itemDef.name = "Dark imp";
                itemDef.description = "Picks up all clue scrolls and 25% chance to double.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Imp.png");
                break;
            case 30112:
                itemDef.setDefaults();
                itemDef.name = "Dark toucan";
                itemDef.description = "Picks up all resource boxes and 25% chance to double.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Toucan.png");
                break;
            case 30113:
                itemDef.setDefaults();
                itemDef.name = "Dark penguin King";
                itemDef.description = "Picks up all coin bags and 25% chance to double.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Penguin_King.png");
                break;
            case 30114:
                itemDef.setDefaults();
                itemDef.name = "Dark k'klik";
                itemDef.description = "An extra 10% in drop rate boost.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_K'klik.png");
                break;
            case 30115:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow warrior";
                itemDef.description = "Gives constant +10% strength bonus in pvm.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_warrior.png");
                break;
            case 30116:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow archer";
                itemDef.description = "Gives constant +10% range str bonus in PvM.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_archer.png");
                break;
            case 30117:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow wizard";
                itemDef.description = "Gives constant +10% mage str bonus in PvM.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_wizard.png");
                break;
            case 30118:
                itemDef.setDefaults();
                itemDef.name = "Dark healer death spawn";
                itemDef.description = "10% chance hit restores HP.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Healer_Death_Spawn.png");
                break;
            case 30119:
                itemDef.setDefaults();
                itemDef.name = "Dark holy death spawn";
                itemDef.description = "10% chance 1/2 of your hit is restored into prayer.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Holy_Death_Spawn.png");
                break;
            case 30120:
                itemDef.setDefaults();
                itemDef.name = "Dark corrupt beast";
                itemDef.description = "Extra 10% in drop rate and constant +10% strength bonus for all styles in pvm.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Corrupt_beast.png");
                break;
            case 30121:
                itemDef.setDefaults();
                itemDef.name = "Dark roc";
                itemDef.description = "An extra 20% in drop rate boost.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Roc.png");
                break;
            case 30122:
                itemDef.setDefaults();
                itemDef.name = "@red@Dark kratos";
                itemDef.description = "The most powerful pet, see ::foepets for full list of perks.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_yama.png");
                break;
            case 30123:
                itemDef.setDefaults();
                itemDef.name = "Dark seren";
                itemDef.description = "85% chance for Wildy Event Boss to hit a 0 and 25% chance to double key.";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_seren.png");

                break;
            case 23939:
                itemDef.name = "Seren";
                itemDef.description = "50% chance for wildy event bosses to hit a 0 on you.";
                itemDef.createCustomSprite("seren.png");
                break;
            case 21046:
                itemDef.name = "@cya@Chest rate bonus (+15%)";
                itemDef.description = "A single use +15% chance from chests, or to receive a rare raids key.";
                itemDef.stackable = true;
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                break;
            case 11666:
                itemDef.name = "Full Elite Void Token";
                itemDef.description = "Use this token to receive a full elite void set with all combat pieces.";
                itemDef.itemActions = new String[] { "Activate", null, null, null, "Drop" };
                break;
            case 1004:
                itemDef.name = "@gre@20m Coins";
                itemDef.description = "Lovely coins.";
                itemDef.stackable = false;
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 7629:
                itemDef.name = "@or3@2x Slayer point scroll";
                itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
                itemDef.stackable = true;
                break;
            case 24460:
                itemDef.name = "@or3@Faster clues (30 mins)";
                itemDef.description = "Clue rates are halved for npcs and skilling.";
                itemDef.itemActions = new String[] { "Boost", null, null, null, "Drop" };
                itemDef.stackable = true;
                break;
            case 7968:
                itemDef.name = "@or3@+25% Skilling pet rate (30 mins)";
                itemDef.itemActions = new String[] { "Boost", null, null, null, "Drop" };
                itemDef.stackable = true;
                break;
            case 8899:
                itemDef.name = "@gre@50m Coins";
                itemDef.description = "Lovely coins.";
                itemDef.stackable = false;
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 4035:
                itemDef.itemActions = new String[] { "Teleport", null, null, null, null };
                break;
            case 10835:
                itemDef.name = "Buldging coin bag";
                itemDef.itemActions = new String[] { "Open", null, "Open-All", null, "Drop" };
                itemDef.description = "I can see some coins inside.";
                break;
            case 15098:
                itemDef.name = "Dice (up to 100)";
                itemDef.description = "A 100-sided dice.";
                itemDef.modelId = 31223;
                itemDef.spriteScale = 1104;
                itemDef.spriteCameraRoll = 215;
                itemDef.spritePitch = 94;
                itemDef.spriteTranslateY = -5;
                itemDef.spriteTranslateX = -18;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Public-roll";
                itemDef.itemActions[2] = null;
                itemDef.name = "Dice (up to 100)";
                itemDef.ambient = 15;
                itemDef.contrast = 25;
                itemDef.createCustomSprite("Dice_Bag.png");
                break;
            case 11773:
            case 11771:
            case 11770:
            case 11772:
                itemDef.ambient += 45;
                break;
            case 12792:
                itemDef.name = "Graceful Recolor Box";
                itemDef.itemActions = new String[] { null, "Use", null, null, "Drop" };
                break;
            case 6769:
                itemDef.name = "@yel@$5 Scroll";
                itemDef.description = "Claim this scroll to be rewarded with 5 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 2403:
                itemDef.name = "@yel@$10 Scroll";
                itemDef.description = "Claim this scroll to be rewarded with 10 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 2396:
                itemDef.name = "@yel@$25 Scroll";
                itemDef.description = "Claim this scroll to be rewarded with 25 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 786:
                itemDef.name = "@yel@$50 Donator";
                itemDef.description = "Claim this scroll to be rewarded with 50 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 761:
                itemDef.name = "@yel@$100 Donator";
                itemDef.description = "Claim this scroll to be rewarded with 100 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 607:
                itemDef.name = "@red@$250 Scroll";
                itemDef.description = "Claim this scroll to be rewarded with 250 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 608:
                itemDef.name = "@gre@$500 Scroll";
                itemDef.description = "Claim this scroll to be rewarded with 500 donator points.";
                itemDef.itemActions = new String[] { "Claim", null, null, null, "Drop" };
                break;
            case 1464:
                itemDef.name = "Vote ticket";
                itemDef.description = "Exchange this for a Vote Point.";
                break;

            case 33049:
                itemDef.setDefaults();
                itemDef.name = "Agility master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 677, 801, 43540, 43543, 43546, 43549, 43550, 43552, 43554, 43558,
                        43560, 43575 };
                itemDef.modelId = 50030;
                itemDef.primaryMaleModel = 50031;
                itemDef.primaryFemaleModel = 50031;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33033:
                itemDef.setDefaults();
                itemDef.name = "Attack master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 7104, 9151, 911, 914, 917, 920, 921, 923, 925, 929, 931, 946 };
                itemDef.modelId = 50032;
                itemDef.primaryMaleModel = 50033;
                itemDef.primaryFemaleModel = 50033;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33055:
                itemDef.setDefaults();
                itemDef.name = "Construction master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 6061, 5945, 6327, 6330, 6333, 6336, 6337, 6339, 6341, 6345, 6347,
                        6362 };
                itemDef.modelId = 50034;
                itemDef.primaryMaleModel = 50035;
                itemDef.primaryFemaleModel = 50035;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33040:
                itemDef.setDefaults();
                itemDef.name = "Cooking master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 920, 920, 51856, 51859, 51862, 51865, 51866, 51868, 51870, 51874,
                        51876, 51891 };
                itemDef.modelId = 50036;
                itemDef.primaryMaleModel = 50037;
                itemDef.primaryFemaleModel = 50037;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33045:
                itemDef.setDefaults();
                itemDef.name = "Crafting master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 9142, 9152, 4511, 4514, 4517, 4520, 4521, 4523, 4525, 4529, 4531,
                        4546 };
                itemDef.modelId = 50038;
                itemDef.primaryMaleModel = 50039;
                itemDef.primaryFemaleModel = 50039;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33034:
                itemDef.setDefaults();
                itemDef.name = "Defence master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 10460, 10473, 41410, 41413, 41416, 41419, 41420, 41422, 41424,
                        41428, 41430, 41445 };
                itemDef.modelId = 50040;
                itemDef.primaryMaleModel = 50041;
                itemDef.primaryFemaleModel = 50041;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33052:
                itemDef.setDefaults();
                itemDef.name = "Farming master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 14775, 14792, 22026, 22029, 22032, 22035, 22036, 22038, 22040,
                        22044, 22046, 22061 };
                itemDef.modelId = 50042;
                itemDef.primaryMaleModel = 50043;
                itemDef.primaryFemaleModel = 50043;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33044:
                itemDef.setDefaults();
                itemDef.name = "Firemaking master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 8125, 9152, 4015, 4018, 4021, 4024, 4025, 4027, 4029, 4033, 4035,
                        4050 };
                itemDef.modelId = 50044;
                itemDef.primaryMaleModel = 50045;
                itemDef.primaryFemaleModel = 50045;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33043:
                itemDef.setDefaults();
                itemDef.name = "Fishing master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 9144, 9152, 38202, 38205, 38208, 38211, 38212, 38214, 38216,
                        38220, 38222, 38237 };
                itemDef.modelId = 50046;
                itemDef.primaryMaleModel = 50047;
                itemDef.primaryFemaleModel = 50047;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33042:
                itemDef.setDefaults();
                itemDef.name = "Fletching master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 6067, 9152, 33670, 33673, 33676, 33679, 33680, 33682, 33684,
                        33688, 33690, 33705 };
                itemDef.modelId = 50048;
                itemDef.primaryMaleModel = 50049;
                itemDef.primaryFemaleModel = 50049;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33048:
                itemDef.setDefaults();
                itemDef.name = "Herblore master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 9145, 9156, 22414, 22417, 22420, 22423, 22424, 22426, 22428,
                        22432, 22434, 22449 };
                itemDef.modelId = 50050;
                itemDef.primaryMaleModel = 50051;
                itemDef.primaryFemaleModel = 50051;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33036:
                itemDef.setDefaults();
                itemDef.name = "Hitpoints master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 818, 951, 8291, 8294, 8297, 8300, 8301, 8303, 8305, 8309, 8311,
                        8319 };
                itemDef.modelId = 50052;
                itemDef.primaryMaleModel = 50053;
                itemDef.primaryFemaleModel = 50053;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                //itemDef.femaleOffset = 4;
                break;
            case 33054:
                itemDef.setDefaults();
                itemDef.name = "Hunter master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 5262, 6020, 8472, 8475, 8478, 8481, 8482, 8484, 8486, 8490, 8492,
                        8507 };
                itemDef.modelId = 50054;
                itemDef.primaryMaleModel = 50055;
                itemDef.primaryFemaleModel = 50055;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33039:
                itemDef.setDefaults();
                itemDef.name = "Magic master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 43569, 43685, 6336, 6339, 6342, 6345, 6346, 6348, 6350, 6354,
                        6356, 6371 };
                itemDef.modelId = 50056;
                itemDef.primaryMaleModel = 50057;
                itemDef.primaryFemaleModel = 50057;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33047:
                itemDef.setDefaults();
                itemDef.name = "Mining master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 36296, 36279, 10386, 10389, 10392, 10395, 10396, 10398, 10400,
                        10404, 10406, 10421 };
                itemDef.modelId = 50058;
                itemDef.primaryMaleModel = 50059;
                itemDef.primaryFemaleModel = 50059;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33038:
                itemDef.setDefaults();
                itemDef.name = "Prayer master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 9163, 9168, 117, 120, 123, 126, 127, 127, 127, 127, 127, 127 };
                itemDef.modelId = 50060;
                itemDef.primaryMaleModel = 50061;
                itemDef.primaryFemaleModel = 50061;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33037:
                itemDef.setDefaults();
                itemDef.name = "Range master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 3755, 3998, 15122, 15125, 15128, 15131, 15132, 15134, 15136,
                        15140, 15142, 15157 };
                itemDef.modelId = 50062;
                itemDef.primaryMaleModel = 50063;
                itemDef.primaryFemaleModel = 50063;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33053:
                itemDef.setDefaults();
                itemDef.name = "Runecrafting master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 9152, 8128, 10318, 10321, 10324, 10327, 10328, 10330, 10332,
                        10336, 10338, 10353 };
                itemDef.modelId = 50064;
                itemDef.primaryMaleModel = 50065;
                itemDef.primaryFemaleModel = 50065;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33051:
                itemDef.setDefaults();
                itemDef.name = "Slayer master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811 };
                itemDef.originalModelColors = new int[] { 912, 920 };
                itemDef.modelId = 50066;
                itemDef.primaryMaleModel = 50067;
                itemDef.primaryFemaleModel = 50067;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33046:
                itemDef.setDefaults();
                itemDef.name = "Smithing master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 8115, 9148, 10386, 10389, 10392, 10395, 10396, 10398, 10400,
                        10404, 10406, 10421 };
                itemDef.modelId = 50068;
                itemDef.primaryMaleModel = 50069;
                itemDef.primaryFemaleModel = 50069;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33035:
                itemDef.setDefaults();
                itemDef.name = "Strength master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 935, 931, 27538, 27541, 27544, 27547, 27548, 27550, 27552, 27556,
                        27558, 27573 };
                itemDef.modelId = 50070;
                itemDef.primaryMaleModel = 50071;
                itemDef.primaryFemaleModel = 50071;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33050:
                itemDef.setDefaults();
                itemDef.name = "Thieving master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 11, 0, 58779, 58782, 58785, 58788, 58789, 57891, 58793, 58797,
                        58799, 58814 };
                itemDef.modelId = 50072;
                itemDef.primaryMaleModel = 50073;
                itemDef.primaryFemaleModel = 50073;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33041:
                itemDef.setDefaults();
                itemDef.name = "Woodcutting master cape";
                itemDef.description = "	A cape worn by those who've overachieved.";
                itemDef.modifiedModelColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
                itemDef.originalModelColors = new int[] { 25109, 24088, 6693, 6696, 6699, 6702, 6703, 6705, 6707, 6711,
                        6713, 6728 };
                itemDef.modelId = 50074;
                itemDef.primaryMaleModel = 50075;
                itemDef.primaryFemaleModel = 50075;
                itemDef.spriteScale = 2300;
                itemDef.spritePitch = 400;
                itemDef.spriteCameraRoll = 1020;
                itemDef.spriteTranslateX = 3;
                itemDef.spriteTranslateY = 30;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wear";
                itemDef.itemActions[2] = null;
                //itemDef.maleOffset = -2;
                break;
        }
    }

    public static ItemDefinition lookup(int itemId) {
             for (int count = 0; count < 10; count++) {
                 if ((cache[count]).id == itemId) {
                     return cache[count];
                 }
             }
        if (itemId == -1)
            itemId = 0;
        if (newCustomItems(itemId) != null) {
            return newCustomItems(itemId);
        }
        if (itemId > streamIndices.length)
            itemId = 0;

            cacheIndex = (cacheIndex + 1) % 10;
            ItemDefinition itemDef = cache[cacheIndex];
                  item_data.currentPosition = streamIndices[itemId];
             itemDef.id = itemId;
             itemDef.setDefaults();
             itemDef.decode(item_data);
        ItemDefinition_Sub1.itemDef(itemDef.id, itemDef);
        ItemDefinition_Sub2.itemDef(itemDef.id, itemDef);
        ItemDefinition_Sub3.itemDef(itemDef.id, itemDef);
        customItems(itemDef.id);
             if (itemDef.certTemplateID != -1) {
                   itemDef.toNote();
                 }
        if (itemDef.notedId != -1) {
            itemDef.method2789(lookup(itemDef.notedId), lookup(itemDef.unnotedId));
        }

        if (itemDef.placeholderTemplateId != -1) {
            itemDef.method2790(lookup(itemDef.placeholderTemplateId), lookup(itemDef.placeholderId));
        }
        int id = itemDef.id;
        itemDef.id = id; // Have to do this for some cases
        return itemDef;
           }
       public static ItemDefinition copy(ItemDefinition itemDef, int newId, int copyingItemId, String newName, String... actions) {
             ItemDefinition copyItemDef = lookup(copyingItemId);
             itemDef.id = newId;
             itemDef.name = newName;
             itemDef.modifiedModelColors = copyItemDef.modifiedModelColors;
             itemDef.originalModelColors = copyItemDef.originalModelColors;
             itemDef.modelId = copyItemDef.modelId;
                itemDef.primaryMaleModel = copyItemDef.primaryMaleModel;
             itemDef.primaryFemaleModel = copyItemDef.primaryFemaleModel;
             itemDef.spriteScale = copyItemDef.spriteScale;
             itemDef.spritePitch = copyItemDef.spritePitch;
             itemDef.spriteCameraRoll = copyItemDef.spriteCameraRoll;
             itemDef.spriteTranslateX = copyItemDef.spriteTranslateX;
             itemDef.spriteTranslateY = copyItemDef.spriteTranslateY;
             itemDef.itemActions = copyItemDef.itemActions;
             itemDef.itemActions = new String[5];
             if (actions != null) {
                  for (int index = 0; index < actions.length; index++) {
                        itemDef.itemActions[index] = actions[index];
                       }
                }
             return itemDef;
           }


    void method2790(ItemDefinition var1, ItemDefinition var2) {
        modelId = var1.modelId * 1;
        spriteScale = 1 * var1.spriteScale;
        spritePitch = var1.spritePitch * 1;
        spriteCameraRoll = var1.spriteCameraRoll * 1;
        spriteCameraYaw = var1.spriteCameraYaw * 1;
        spriteTranslateX = 1 * var1.spriteTranslateX;
        spriteTranslateY = var1.spriteTranslateY * 1;
        originalModelColors = var1.originalModelColors;
        modifiedModelColors = var1.modifiedModelColors;
        originalTextureColors = var1.originalTextureColors;
        modifiedTextureColors = var1.modifiedTextureColors;
        stackable = var1.stackable;
        name = var2.name;
        value = 0;
    }

    void method2789(ItemDefinition var1, ItemDefinition var2) {
        modelId = var1.modelId * 1;
        spriteScale = var1.spriteScale * 1;
        spritePitch = 1 * var1.spritePitch;
        spriteCameraRoll = 1 * var1.spriteCameraRoll;
        spriteCameraYaw = 1 * var1.spriteCameraYaw;
        spriteTranslateX = 1 * var1.spriteTranslateX;
        spriteTranslateY = var1.spriteTranslateY * 1;
        originalModelColors = var2.originalModelColors;
        modifiedModelColors = var2.modifiedModelColors;
        originalTextureColors = var2.originalTextureColors;
        modifiedTextureColors = var2.modifiedTextureColors;
        originalTextureColors = var2.originalTextureColors;
        modifiedTextureColors = var2.modifiedTextureColors;
        name = var2.name;
        members = var2.members;
        stackable = var2.stackable;
        primaryMaleModel = 1 * var2.primaryMaleModel;
        secondaryMaleModel = 1 * var2.secondaryMaleModel;
        tertiaryMaleEquipmentModel = 1 * var2.tertiaryMaleEquipmentModel;
        primaryFemaleModel = var2.primaryFemaleModel * 1;
        secondaryFemaleModel = var2.secondaryFemaleModel * 1;
        tertiaryFemaleEquipmentModel = 1 * var2.tertiaryFemaleEquipmentModel;
        primaryMaleHeadPiece = 1 * var2.primaryMaleHeadPiece;
        secondaryMaleHeadPiece = var2.secondaryMaleHeadPiece * 1;
        primaryFemaleHeadPiece = var2.primaryFemaleHeadPiece * 1;
        secondaryFemaleHeadPiece = var2.secondaryFemaleHeadPiece * 1;
        team = var2.team * 1;
        groundActions = var2.groundActions;
        itemActions = new String[5];
        equipActions = new String[5];
        if (null != var2.itemActions) {
            for (int var4 = 0; var4 < 4; ++var4) {
                itemActions[var4] = var2.itemActions[var4];
            }
        }

        itemActions[4] = "Discard";
        value = 0;
    }


    public static Sprite getSmallSprite(int itemId) {
        return getSmallSprite(itemId, 1);
    }

    public static Sprite getSmallSprite(int itemId, int stackSize) {

        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.stackIDs == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    stack_item_id = itemDef.stackIDs[j1];

            if (stack_item_id != -1)
                itemDef = lookup(stack_item_id);
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = getSprite(itemDef.certID, 10, -1, 0,true);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(18, 18);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(18, 18, enabledSprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 18, 18, 0);
        Rasterizer3D.useViewport();
        int k3 = itemDef.spriteScale;

        int l3 = Rasterizer3D.SINE[itemDef.spritePitch] * k3 >> 16;
        int i4 = Rasterizer3D.COSINE[itemDef.spritePitch] * k3 >> 16;
        Rasterizer3D.renderOnGpu = true;
        model.renderModel(itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX,
                l3 + model.modelBaseY / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);

        enabledSprite.outline(1);

        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);

        if (itemDef.certTemplateID != -1) {
            int old_w = sprite.maxWidth;
            int old_h = sprite.maxHeight;
            sprite.maxWidth = 18;
            sprite.maxHeight = 18;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = old_w;
            sprite.maxHeight = old_h;
        }

        sprites.put(enabledSprite, itemId);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            enabledSprite.maxWidth = 18;
        else
            enabledSprite.maxWidth = 18;
        enabledSprite.maxHeight = stackSize;
        return enabledSprite;
    }


    public byte[] customSpriteLocation;
    public byte[] customSmallSpriteLocation;

    public void createCustomSprite(String img) {
        customSpriteLocation = getCustomSprite(img);
    }

    public void createSmallCustomSprite(String img) {
        customSmallSpriteLocation = getCustomSprite(img);
    }


    private byte[] getCustomSprite(String img) {
        String location = (Sprite.location + Configuration.CUSTOM_ITEM_SPRITES_DIRECTORY + img).toLowerCase();
        byte[] spriteData = FileOperations.readFile(location);
        Preconditions.checkState(spriteData != null, "No sprite: " + location);
        return spriteData;
    }

    public static Sprite getSprite(int itemId, int stackSize, int outlineColor, int var3, boolean var5) { // show me the model method
        if (outlineColor == 0) {
            Sprite sprite = (Sprite) sprites.get(itemId);
            if (sprite != null && sprite.maxHeight != stackSize && sprite.maxHeight != -1) {

                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.stackIDs == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    stack_item_id = itemDef.stackIDs[j1];

            if (stack_item_id != -1) {
                itemDef = lookup(stack_item_id);
            }
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = getSprite(itemDef.certID, 10, -1, 0,true);
            if (sprite == null)
                return null;
        } else if (itemDef.notedId != -1) {
            sprite = getSprite(itemDef.unnotedId, stackSize, -1, var3, false);
            if (sprite == null)
                return null;
        } else if (itemDef.placeholderTemplateId != -1) {
            sprite = getSprite(itemDef.placeholderId, stackSize, -1, 0, false);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(32, 32);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 32, 32, 0);
        Rasterizer3D.useViewport();
        int k3 = itemDef.spriteScale;
        if (outlineColor == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (outlineColor > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer3D.SINE[itemDef.spritePitch] * k3 >> 16;
        int i4 = Rasterizer3D.COSINE[itemDef.spritePitch] * k3 >> 16;
        Rasterizer3D.renderOnGpu = true;
        model.renderModel(itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX,
                l3 + model.modelBaseY / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);

        enabledSprite.outline(1);
        if (outlineColor > 0) {
            enabledSprite.outline(16777215);
        }
        if (outlineColor == 0) {
            enabledSprite.shadow(3153952);
        }

        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);
        if (itemDef.notedId != -1) {
            int l5 = sprite.maxWidth;
            int j6 = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = l5;
            sprite.maxHeight = j6;
        }
        if (itemDef.certTemplateID != -1) {
            int old_w = sprite.maxWidth;
            int old_h = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = old_w;
            sprite.maxHeight = old_h;
        }
        if (outlineColor == 0)
            sprites.put(enabledSprite, itemId);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            enabledSprite.maxWidth = 33;
        else
            enabledSprite.maxWidth = 32;
        enabledSprite.maxHeight = stackSize;
        return enabledSprite;
    }

    public static Sprite getSprite(int itemId, int stackSize, int zoom, int outlineColor) {
        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.stackIDs == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    stack_item_id = itemDef.stackIDs[j1];

            if (stack_item_id != -1)
                itemDef = lookup(stack_item_id);
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = new Sprite(90, 90);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(90, 90, sprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 90, 90, 0);
        Rasterizer3D.useViewport();
        int l3 = Rasterizer3D.SINE[itemDef.spritePitch] * zoom >> 15;
        int i4 = Rasterizer3D.COSINE[itemDef.spritePitch] * zoom >> 15;
        Rasterizer3D.renderOnGpu = true;

        model.renderModel(itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX,
                l3 + model.modelBaseY / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);

        Rasterizer3D.renderOnGpu = false;
        sprite.outline(1);
        if (outlineColor > 0) {
            sprite.outline(16777215);
        }
        if (outlineColor == 0) {
            sprite.shadow(3153952);
        }
        Rasterizer2D.initDrawingArea(90, 90, sprite.myPixels);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            sprite.maxWidth = 33;
        else
            sprite.maxWidth = 32;
        sprite.maxHeight = stackSize;
        return sprite;
    }

    public boolean isDialogueModelCached(int gender) {
        int model_1 = primaryMaleHeadPiece;
        int model_2 = secondaryMaleHeadPiece;
        if (gender == 1) {
            model_1 = primaryFemaleHeadPiece;
            model_2 = secondaryFemaleHeadPiece;
        }
        if (model_1 == -1)
            return true;
        boolean cached = Model.isCached(model_1);
        if (model_2 != -1 && !Model.isCached(model_2))
            cached = false;
        return cached;
    }

    public Model getChatEquipModel(int gender) {
        int dialogueModel = primaryMaleHeadPiece;
        int dialogueHatModel = secondaryMaleHeadPiece;
        if (gender == 1) {
            dialogueModel = primaryFemaleHeadPiece;
            dialogueHatModel = secondaryFemaleHeadPiece;
        }
        if (dialogueModel == -1)
            return null;
        Model dialogueModel_ = Model.getModel(dialogueModel);
        if (dialogueHatModel != -1) {
            Model hatModel_ = Model.getModel(dialogueHatModel);
            Model[] models = {dialogueModel_, hatModel_};
            dialogueModel_ = new Model(2, models);
        }
        if (originalModelColors != null) {
            for (int i1 = 0; i1 < originalModelColors.length; i1++)
                dialogueModel_.recolor(originalModelColors[i1], modifiedModelColors[i1]);

        }
        if (modifiedTextureColors != null) {
            for (int i1 = 0; i1 < modifiedTextureColors.length; i1++)
                dialogueModel_.retexture(modifiedTextureColors[i1], originalTextureColors[i1]);
        }
        return dialogueModel_;
    }

    public boolean isEquippedModelCached(int gender) {
        int primaryModel = primaryMaleModel;
        int secondaryModel = secondaryMaleModel;
        int emblem = tertiaryMaleEquipmentModel;
        if (gender == 1) {
            primaryModel = primaryFemaleModel;
            secondaryModel = secondaryFemaleModel;
            emblem = tertiaryFemaleEquipmentModel;
        }
        if (primaryModel == -1)
            return true;
        boolean cached = Model.isCached(primaryModel);
        if (secondaryModel != -1 && !Model.isCached(secondaryModel))
            cached = false;
        if (emblem != -1 && !Model.isCached(emblem))
            cached = false;
        return cached;
    }

    public Model get_equipped_model(int gender) {
        int primaryModel = primaryMaleModel;
        int secondaryModel = secondaryMaleModel;
        int emblem = tertiaryMaleEquipmentModel;

        if (gender == 1) {
            primaryModel = primaryFemaleModel;
            secondaryModel = secondaryFemaleModel;
            emblem = tertiaryFemaleEquipmentModel;
        }

        if (primaryModel == -1)
            return null;
        Model primaryModel_ = Model.getModel(primaryModel);
        if (secondaryModel != -1)
            if (emblem != -1) {
                Model secondaryModel_ = Model.getModel(secondaryModel);
                Model emblemModel = Model.getModel(emblem);
                Model[] models = {primaryModel_, secondaryModel_, emblemModel};
                primaryModel_ = new Model(3, models);
            } else {
                Model model_2 = Model.getModel(secondaryModel);
                Model[] models = {primaryModel_, model_2};
                primaryModel_ = new Model(2, models);
            }
        if (gender == 0 && maleTranslation != 0)
            primaryModel_.offsetBy(0, maleTranslation, 0);
        if (gender == 1 && femaleTranslation != 0)
            primaryModel_.offsetBy(0, femaleTranslation, 0);

        if (originalModelColors != null) {
            for (int i1 = 0; i1 < originalModelColors.length; i1++)
                primaryModel_.recolor(originalModelColors[i1], modifiedModelColors[i1]);

        }
        if (modifiedTextureColors != null) {
            for (int i1 = 0; i1 < modifiedTextureColors.length; i1++)
                primaryModel_.retexture(modifiedTextureColors[i1], originalTextureColors[i1]);
        }
        return primaryModel_;
    }

    public void setDefaults() {
        // equipActions = new String[6];
        customSpriteLocation = null;
        customSmallSpriteLocation = null;
        equipActions = new String[] { "Remove", null, "Operate", null, null };
        modelId = 0;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        modifiedTextureColors = null;
        originalTextureColors = null;
        spriteScale = 2000;
        spritePitch = 0;
        spriteCameraRoll = 0;
        spriteCameraYaw = 0;
        spriteTranslateX = 0;
        spriteTranslateY = 0;
        stackable = false;
        value = 1;
        members = false;
        groundActions = null;
        itemActions = null;
        primaryMaleModel = -1;
        secondaryMaleModel = -1;
        maleTranslation = 0;
        primaryFemaleModel = -1;
        secondaryFemaleModel = -1;
        femaleTranslation = 0;
        tertiaryMaleEquipmentModel = -1;
        tertiaryFemaleEquipmentModel = -1;
        primaryMaleHeadPiece = -1;
        secondaryMaleHeadPiece = -1;
        primaryFemaleHeadPiece = -1;
        secondaryFemaleHeadPiece = -1;
        stackIDs = null;
        stackAmounts = null;
        certID = -1;
        certTemplateID = -1;
        groundScaleX = 128;
        groundScaleY = 128;
        groundScaleZ = 128;
        ambient = 0;
        contrast = 0;
        team = 0;

        notedId = -1;
        unnotedId = -1;
        placeholderId = -1;
        placeholderTemplateId = -1;

        searchable = false;
    }

    private void copy(ItemDefinition copy) {
        spriteCameraRoll = copy.spriteCameraRoll;
        spritePitch = copy.spritePitch;
        spriteCameraYaw = copy.spriteCameraYaw;
        groundScaleX = copy.groundScaleX;
        groundScaleY = copy.groundScaleY;
        groundScaleZ = copy.groundScaleZ;
        spriteScale = copy.spriteScale;
        spriteTranslateX = copy.spriteTranslateX;
        spriteTranslateY = copy.spriteTranslateY;
        modelId = copy.modelId;
        stackable = copy.stackable;

    }

    private void toNote() {
        ItemDefinition itemDef = lookup(certTemplateID);
        modelId = itemDef.modelId;
        spriteScale = itemDef.spriteScale;
        spritePitch = itemDef.spritePitch;
        spriteCameraRoll = itemDef.spriteCameraRoll;

        spriteCameraYaw = itemDef.spriteCameraYaw;
        spriteTranslateX = itemDef.spriteTranslateX;
        spriteTranslateY = itemDef.spriteTranslateY;

        ItemDefinition itemDef_1 = lookup(certID);
        name = itemDef_1.name;
        members = itemDef_1.members;
        value = itemDef_1.value;
        stackable = true;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    public int getContrast() {
        return contrast;
    }

    public int getAmbient() {
        return ambient;
    }
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getNote() {
        return 0;
    }

    @Override
    public int getLinkedNoteId() {
        return 0;
    }

    @Override
    public int getPlaceholderId() {
        return 0;
    }

    @Override
    public int getPlaceholderTemplateId() {
        return 0;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean isMembers() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public void setTradeable(boolean yes) {

    }

    @Override
    public int getIsStackable() {
        return 0;
    }

    @Override
    public int getMaleModel() {
        return 0;
    }

    @Override
    public String[] getInventoryActions() {
        return new String[0];
    }

    @Override
    public String[] getGroundActions() {
        return new String[0];
    }

    @Override
    public int getShiftClickActionIndex() {
        return 0;
    }

    @Override
    public void setShiftClickActionIndex(int shiftClickActionIndex) {

    }

    public Model getModel(int stack_size) {
        if (stackIDs != null && stack_size > 1) {
            int stack_item_id = -1;
            for (int k = 0; k < 10; k++)
                if (stack_size >= stackAmounts[k] && stackAmounts[k] != 0)
                    stack_item_id = stackIDs[k];

            if (stack_item_id != -1)
                return lookup(stack_item_id).getModel(1);
        }
        Model model = (Model) models.get(id);
        if (model != null)
            return model;
        model = Model.getModel(modelId);
        if (model == null)
            return null;
        if (groundScaleX != 128 || groundScaleY != 128 || groundScaleZ != 128)
            model.scale(groundScaleX, groundScaleZ, groundScaleY);
        if (originalModelColors != null) {
            for (int l = 0; l < originalModelColors.length; l++)
                model.recolor(originalModelColors[l], modifiedModelColors[l]);

        }
        if (modifiedTextureColors != null) {
            for (int i1 = 0; i1 < modifiedTextureColors.length; i1++)
                model.retexture(modifiedTextureColors[i1], originalTextureColors[i1]);
        }
        int lightInt = 64 + ambient;
        int lightMag = 768 + contrast;
        model.light(lightInt, lightMag, -50, -10, -50, true);
        model.singleTile = true;
        models.put(model, id);
        return model;
    }

    @Override
    public int getInventoryModel() {
        return 0;
    }

    @Override
    public short[] getColorToReplaceWith() {
        return new short[0];
    }

    @Override
    public short[] getTextureToReplaceWith() {
        return new short[0];
    }

    @Override
    public RSIterableNodeHashTable getParams() {
        return null;
    }

    @Override
    public void setParams(IterableHashTable params) {

    }

    @Override
    public void setParams(RSIterableNodeHashTable params) {

    }

    public Model getUnshadedModel(int stack_size) {
        if (stackIDs != null && stack_size > 1) {
            int stack_item_id = -1;
            for (int count = 0; count < 10; count++)
                if (stack_size >= stackAmounts[count] && stackAmounts[count] != 0)
                    stack_item_id = stackIDs[count];

            if (stack_item_id != -1)
                return lookup(stack_item_id).getUnshadedModel(1);
        }
        Model model = Model.getModel(modelId);
        if (model == null)
            return null;
        if (originalModelColors != null) {
            for (int colorPtr = 0; colorPtr < originalModelColors.length; colorPtr++)
                model.recolor(originalModelColors[colorPtr], modifiedModelColors[colorPtr]);

        }
        if (modifiedTextureColors != null) {
            for (int i1 = 0; i1 < modifiedTextureColors.length; i1++)
                model.retexture(modifiedTextureColors[i1], originalTextureColors[i1]);
        }
        return model;
    }

    private void decode(Buffer1 buffer) {
        while (true) {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0)
                return;
            if (opcode == 1)
                modelId = buffer.readUShort();
            else if (opcode == 2)
                name = buffer.readStrings();
            else if (opcode == 3)
                description = buffer.readStrings();
            else if (opcode == 4)
                spriteScale = buffer.readUShort();
            else if (opcode == 5)
                spritePitch = buffer.readUShort();
            else if (opcode == 6)
                spriteCameraRoll = buffer.readUShort();
            else if (opcode == 7) {
                spriteTranslateX = buffer.readUShort();
                if (spriteTranslateX > 32767)
                    spriteTranslateX -= 0x10000;
            } else if (opcode == 8) {
                spriteTranslateY = buffer.readUShort();
                if (spriteTranslateY > 32767)
                    spriteTranslateY -= 0x10000;
            } else if (opcode == 9)
                buffer.readStrings();
            else if (opcode == 11)
                stackable = true;
            else if (opcode == 12) {
                value = buffer.readInt();
            } else if (opcode == 13) {
                wearpos = buffer.readUnsignedByte();
            } else if (opcode == 14) {
                wearpos2 = buffer.readUnsignedByte();
            } else if (opcode == 16)
                members = true;
            else if (opcode == 23) {
                primaryMaleModel = buffer.readUShort();
                maleTranslation = buffer.readUnsignedByte();
            } else if (opcode == 24)
                secondaryMaleModel = buffer.readUShort();
            else if (opcode == 25) {
                primaryFemaleModel = buffer.readUShort();
                femaleTranslation = buffer.readUnsignedByte();
            } else if (opcode == 26)
                secondaryFemaleModel = buffer.readUShort();
            else if(opcode == 27)
                wearpos3 = buffer.readUnsignedByte();
            else if (opcode >= 30 && opcode < 35) {
                if (groundActions == null)
                    groundActions = new String[5];
                groundActions[opcode - 30] = buffer.readString();
                if (groundActions[opcode - 30].equalsIgnoreCase("hidden"))
                    groundActions[opcode - 30] = null;
            } else if (opcode >= 35 && opcode < 40) {
                if (itemActions == null)
                    itemActions = new String[5];
                itemActions[opcode - 35] = buffer.readString();
            } else if (opcode == 40) {
                int length = buffer.readUnsignedByte();
                originalModelColors = new int[length];
                modifiedModelColors = new int[length];
                for (int index = 0; index < length; index++) {
                    modifiedModelColors[index] = buffer.readUShort();
                    originalModelColors[index] = buffer.readUShort();
                }
            } else if (opcode == 41) {
                int length = buffer.readUnsignedByte();
                originalTextureColors = new short[length];
                modifiedTextureColors = new short[length];
                for (int index = 0; index < length; index++) {
                    originalTextureColors[index] = (short) buffer.readUShort();
                    modifiedTextureColors[index] = (short) buffer.readUShort();
                }
            } else if (opcode == 42) {
                shiftClickIndex = buffer.readUnsignedByte();
            } else if (opcode == 65) {
                searchable = true;
            } else if (opcode == 75) {
                weight = buffer.readShort();
            } else if (opcode == 78)
                tertiaryMaleEquipmentModel = buffer.readUShort();
            else if (opcode == 79)
                tertiaryFemaleEquipmentModel = buffer.readUShort();
            else if (opcode == 90)
                primaryMaleHeadPiece = buffer.readUShort();
            else if (opcode == 91)
                primaryFemaleHeadPiece = buffer.readUShort();
            else if (opcode == 92)
                secondaryMaleHeadPiece = buffer.readUShort();
            else if (opcode == 93)
                secondaryFemaleHeadPiece = buffer.readUShort();
            else if (opcode == 94)
                category = buffer.readUShort();
            else if (opcode == 95)
                spriteCameraYaw = buffer.readUShort();
            else if (opcode == 97)
                certID = buffer.readUShort();
            else if (opcode == 98)
                certTemplateID = buffer.readUShort();
            else if (opcode >= 100 && opcode < 110) {
                if (stackIDs == null) {
                    stackIDs = new int[10];
                    stackAmounts = new int[10];
                }
                stackIDs[opcode - 100] = buffer.readUShort();
                stackAmounts[opcode - 100] = buffer.readUShort();
            } else if (opcode == 110)
                groundScaleX = buffer.readUShort();
            else if (opcode == 111)
                groundScaleY = buffer.readUShort();
            else if (opcode == 112)
                groundScaleZ = buffer.readUShort();
            else if (opcode == 113)
                ambient = buffer.readSignedByte();
            else if (opcode == 114)
                contrast = buffer.readSignedByte() * 5;
            else if (opcode == 115)
                team = buffer.readUnsignedByte();
            else if (opcode == 139)
                unnotedId = buffer.readUShort();
            else if (opcode == 140)
                notedId = buffer.readUShort();
            else if (opcode == 148)
                placeholderId = buffer.readUShort();
            else if (opcode == 149) {
                placeholderTemplateId = buffer.readUShort();
            } else if (opcode == 249) {
                int length = buffer.readUnsignedByte();

                HashMap<Integer, Object> params = new HashMap<>(length);

                for (int i = 0; i < length; i++) {
                    boolean isString = buffer.readUnsignedByte() == 1;
                    int key = buffer.read24Int();
                    Object value;

                    if (isString) {
                        value = buffer.readString();
                    } else {
                        value = buffer.readInt();
                    }

                    params.put(key, value);
                }
                return;
            }
            else {
                System.err.printf("Error unrecognised {Items} opcode: %d%n%n", opcode);
            }
        }
    }

    @Override
    public int getHaPrice() {
        return 0;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void resetShiftClickActionIndex() {

    }

    @Override
    public int getIntValue(int paramID) {
        return 0;
    }

    @Override
    public void setValue(int paramID, int value) {

    }

    @Override
    public String getStringValue(int paramID) {
        return null;
    }

    @Override
    public void setValue(int paramID, String value) {

    }
}