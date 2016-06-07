package net.BukkitPE.inventory;

import java.util.Set;

/**

 * BukkitPE Project
 */
public interface TransactionGroup {

    long getCreationTime();

    Set<Transaction> getTransactions();

    Set<Inventory> getInventories();

    void addTransaction(Transaction transaction);

    boolean canExecute();

    boolean execute();

    boolean hasExecuted();
}
