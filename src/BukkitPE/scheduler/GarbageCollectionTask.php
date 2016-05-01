<?php
namespace BukkitPE\scheduler;

class GarbageCollectionTask extends AsyncTask{

	public function onRun(){
		gc_enable();
		gc_collect_cycles();
	}
}
