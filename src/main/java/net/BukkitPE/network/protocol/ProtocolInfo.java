package net.BukkitPE.network.protocol;

/**
 * & iNevet
 * BukkitPE Project
 */
public interface ProtocolInfo {

    /**
     * Actual Minecraft: PE protocol version
     */
    byte CURRENT_PROTOCOL = 107;
    public final static String MINECRAFT_VERSION = "1.0.9";
    public final static String MINECRAFT_VERSION_NETWORK = "1.0.9";

    byte LOGIN_PACKET = (byte) 0x01;
    byte PLAY_STATUS_PACKET = (byte) 0x02;
    byte SERVER_TO_CLIENT_HANDSHAKE_PACKET = (byte) 0x03;
    byte CLIENT_TO_SERVER_HANDSHAKE_PACKET = (byte) 0x04;
    byte DISCONNECT_PACKET = (byte) 0x05;
    byte BATCH_PACKET = (byte) 0x06;
    byte RESOURCE_PACKS_INFO_PACKET = (byte) 0x07;
    byte RESOURCE_PACK_STACK_PACKET = (byte) 0x08; //ResourcePacksStackPacket
    byte RESOURCE_PACK_CLIENT_RESPONSE_PACKET = (byte) 0x09;
    byte TEXT_PACKET = (byte) 0x0a;
    byte SET_TIME_PACKET = (byte) 0x0b;
    byte START_GAME_PACKET = (byte) 0x0c;
    byte ADD_PLAYER_PACKET = (byte) 0x0d;
    byte ADD_ENTITY_PACKET = (byte) 0x0e;
    byte REMOVE_ENTITY_PACKET = (byte) 0x0f;
    byte ADD_ITEM_ENTITY_PACKET = (byte) 0x10;
    byte ADD_HANGING_ENTITY_PACKET = (byte) 0x11;
    byte TAKE_ITEM_ENTITY_PACKET = (byte) 0x12;
    byte MOVE_ENTITY_PACKET = (byte) 0x13;
    byte MOVE_PLAYER_PACKET = (byte) 0x14;
    byte RIDER_JUMP_PACKET = (byte) 0x15;
    byte REMOVE_BLOCK_PACKET = (byte) 0x16;
    byte UPDATE_BLOCK_PACKET = (byte) 0x17;
    byte ADD_PAINTING_PACKET = (byte) 0x18;
    byte EXPLODE_PACKET = (byte) 0x19;
    byte LEVEL_SOUND_EVENT_PACKET = (byte) 0x1a;
    byte LEVEL_EVENT_PACKET = (byte) 0x1b;
    byte BLOCK_EVENT_PACKET = (byte) 0x1c;
    byte ENTITY_EVENT_PACKET = (byte) 0x1d;
    byte MOB_EFFECT_PACKET = (byte) 0x1e;
    byte UPDATE_ATTRIBUTES_PACKET = (byte) 0x1f;
    byte MOB_EQUIPMENT_PACKET = (byte) 0x20;
    byte MOB_ARMOR_EQUIPMENT_PACKET = (byte) 0x21;
    byte INTERACT_PACKET = (byte) 0x22;
    byte BLOCK_PICK_REQUEST_PACKET = (byte) 0x23;
    byte USE_ITEM_PACKET = (byte) 0x24;
    byte PLAYER_ACTION_PACKET = (byte) 0x25;
    byte PLAYER_FALL_PACKET = (byte) 0x26;
    byte HURT_ARMOR_PACKET = (byte) 0x27;
    byte SET_ENTITY_DATA_PACKET = (byte) 0x28;
    byte SET_ENTITY_MOTION_PACKET = (byte) 0x29;
    byte SET_ENTITY_LINK_PACKET = (byte) 0x2a;
    byte SET_HEALTH_PACKET = (byte) 0x2b;
    byte SET_SPAWN_POSITION_PACKET = (byte) 0x2c;
    byte ANIMATE_PACKET = (byte) 0x2d;
    byte RESPAWN_PACKET = (byte) 0x2e;
    byte DROP_ITEM_PACKET = (byte) 0x2f;
    byte INVENTORY_ACTION_PACKET = (byte) 0x30;
    byte CONTAINER_OPEN_PACKET = (byte) 0x31;
    byte CONTAINER_CLOSE_PACKET = (byte) 0x32;
    byte CONTAINER_SET_SLOT_PACKET = (byte) 0x33;
    byte CONTAINER_SET_DATA_PACKET = (byte) 0x34;
    byte CONTAINER_SET_CONTENT_PACKET = (byte) 0x35;
    byte CRAFTING_DATA_PACKET = (byte) 0x36;
    byte CRAFTING_EVENT_PACKET = (byte) 0x37;
    byte ADVENTURE_SETTINGS_PACKET = (byte) 0x38;
    byte BLOCK_ENTITY_DATA_PACKET = (byte) 0x39;
    byte PLAYER_INPUT_PACKET = (byte) 0x3a;
    byte FULL_CHUNK_DATA_PACKET = (byte) 0x3b;
    byte SET_COMMANDS_ENABLED_PACKET = (byte) 0x3c;
    byte SET_DIFFICULTY_PACKET = (byte) 0x3d;
    byte CHANGE_DIMENSION_PACKET = (byte) 0x3e;
    byte SET_PLAYER_GAME_TYPE_PACKET = (byte) 0x3f;
    byte PLAYER_LIST_PACKET = (byte) 0x40;
    byte EVENT_PACKET = (byte) 0x41; //TelemetryEventPacket
    byte SPAWN_EXPERIENCE_ORB_PACKET = (byte) 0x42;
    byte CLIENTBOUND_MAP_ITEM_DATA_PACKET = (byte) 0x43; //MapItemDataPacket
    byte MAP_INFO_REQUEST_PACKET = (byte) 0x44;
    byte REQUEST_CHUNK_RADIUS_PACKET = (byte) 0x45;
    byte CHUNK_RADIUS_UPDATED_PACKET = (byte) 0x46;
    byte ITEM_FRAME_DROP_ITEM_PACKET = (byte) 0x47;
    byte REPLACE_ITEM_IN_SLOT_PACKET = (byte) 0x48; //ReplaceSelectedItemPacket
    byte GAME_RULES_CHANGED_PACKET = (byte) 0x49;
    byte CAMERA_PACKET = (byte) 0x4a;
    byte ADD_ITEM_PACKET = (byte) 0x4b;
    byte BOSS_EVENT_PACKET = (byte) 0x4c;
    byte SHOW_CREDITS_PACKET = (byte) 0x4d;
    byte AVAILABLE_COMMANDS_PACKET = (byte) 0x4e;
    byte COMMAND_STEP_PACKET = (byte) 0x4f;
    byte COMMAND_BLOCK_UPDATE_PACKET = (byte) 0x50;
    byte UPDATE_TRADE_PACKET = (byte) 0x51;
    byte RESOURCE_PACK_DATA_INFO_PACKET = (byte) 0x52;
    byte RESOURCE_PACK_CHUNK_DATA_PACKET = (byte) 0x53;
    byte RESOURCE_PACK_CHUNK_REQUEST_PACKET = (byte) 0x54;
    byte TRANSFER_PACKET = (byte) 0x55;
    byte PLAY_SOUND_PACKET = (byte) 0x56;
    byte STOP_SOUND_PACKET = (byte) 0x57;
    byte SET_TITLE_PACKET = (byte) 0x58;
}
