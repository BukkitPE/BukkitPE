package net.BukkitPE.level.generator.task;

import net.BukkitPE.level.format.generic.BaseFullChunk;
import net.BukkitPE.scheduler.AsyncTask;

public abstract class RequestChunkTask extends AsyncTask {
	public abstract BaseFullChunk getChunk();
}