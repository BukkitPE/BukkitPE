<?php
namespace BukkitPE\permission;


interface PermissionRemovedExecutor{

	/**
	 * @param PermissionAttachment $attachment
	 *
	 * @return void
	 */
	public function attachmentRemoved(PermissionAttachment $attachment);
}