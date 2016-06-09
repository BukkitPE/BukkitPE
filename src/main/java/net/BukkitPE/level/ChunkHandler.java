package net.BukkitPE.level;

import net.BukkitPE.Server;
import net.BukkitPE.level.format.generic.BaseFullChunk;

public abstract class ChunkHandler {
	
	public abstract void onRun(BaseFullChunk chunk, Server server);

}