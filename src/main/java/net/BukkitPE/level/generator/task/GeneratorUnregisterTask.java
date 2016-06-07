package net.BukkitPE.level.generator.task;

import net.BukkitPE.level.Level;
import net.BukkitPE.scheduler.AsyncTask;

/**

 * BukkitPE Project
 */
public class GeneratorUnregisterTask extends AsyncTask {

    public int levelId;

    public GeneratorUnregisterTask(Level level) {
        this.levelId = level.getId();
    }

    @Override
    public void onRun() {
        GeneratorPool.remove(levelId);
    }
}
