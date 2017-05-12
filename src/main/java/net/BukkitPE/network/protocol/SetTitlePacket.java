package net.BukkitPE.network.protocol;

class SetTitlePacket extends DataPacket{
	public static final byte NETWORK_ID = ProtocolInfo::SET_TITLE_PACKET;

	public int TYPE_CLEAR_TITLE = 0;
    public int TYPE_RESET_TITLE = 1;
    public int TYPE_SET_TITLE = 2;
    public int TYPE_SET_SUBTITLE = 3;
    public int TYPE_SET_ACTIONBAR_MESSAGE = 4;
    public int TYPE_SET_ANIMATION_TIMES = 5;

    public int type;
    public String text;
    public int fadeInTime;
    public int stayTime;
    public int fadeOutTime;

    public void decode(){
        this.type = this.getVarInt();
        this.text = this.getString();
        this.fadeInTime = this.getVarInt();
        this.stayTime = this.getVarInt();
        this.fadeOutTime = this.getVarInt();
    }

    public void encode(){
        this.reset();
        this.putVarInt(this.type);
        this.putString(this.text);
        this.putVarInt(this.fadeInTime);
        this.putVarInt(this.stayTime);
        this.putVarInt(this.fadeOutTime);
    }

    public int pid(){
        return NETWORK_ID;
    }
}