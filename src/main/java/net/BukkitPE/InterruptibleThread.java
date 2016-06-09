package net.BukkitPE;

/**
 * 描述一个可以被中断的线程的接口。<br>
 * An interface to describe a thread that can be interrupted.
 * <p>
 * <p>在BukkitPE服务器停止时，BukkitPE会找到所有实现了{@code InterruptibleThread}的线程，并逐一中断。<br>
 * When a BukkitPE server is stopping, BukkitPE finds all threads implements {@code InterruptibleThread},
 * and interrupt them one by one.</p>
 *
 * @author  @ BukkitPE Project

 * @see net.BukkitPE.scheduler.AsyncWorker
 * @see net.BukkitPE.command.CommandReader
 * @since BukkitPE 1.0 | BukkitPE API 1.0.0
 */
public interface InterruptibleThread {
}
