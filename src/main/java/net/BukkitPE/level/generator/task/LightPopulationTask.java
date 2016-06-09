package net.BukkitPE.level.generator.task;

import net.BukkitPE.Server;
import net.BukkitPE.level.Level;
import net.BukkitPE.level.format.generic.BaseFullChunk;
import net.BukkitPE.scheduler.AsyncTask;

/**

 * BukkitPE Project
 */
public class LightPopulationTask extends AsyncTask {

    public int levelId;
    public BaseFullChunk chunk;

    public LightPopulationTask(Level level, BaseFullChunk chunk) {
        this.levelId = level.getId();
        this.chunk = chunk;
    }

    @Override
    public void onRun() {
        BaseFullChunk chunk = this.chunk.clone();
        if (chunk == null) {
            return;
        }

        chunk.recalculateHeightMap();
        chunk.populateSkyLight();
        chunk.setLightPopulated();

        this.chunk = chunk.clone();
    }

    @Override
    public void onCompletion(Server server) {
        Level level = server.getLevel(this.levelId);

        BaseFullChunk chunk = this.chunk.clone();
        if (level != null) {
            if (chunk == null) {
                return;
            }

            level.generateChunkCallback(chunk.getX(), chunk.getZ(), chunk);
        }
    }
}
