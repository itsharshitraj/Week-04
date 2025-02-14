package bankingsystem;

import java.util.*;

public class Bank {
    private Map<Long, Double> accounts = new HashMap<>();
    private Queue<Long> withdrawalQueue = new LinkedList<>();

    // Add an account
    public void addAccount(long accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Deposit money
    public void deposit(long accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
        System.out.println("Deposited $" + amount + " to Account " + accountNumber);
    }

    // Request a withdrawal
    public void requestWithdrawal(long accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist!");
            return;
        }
        withdrawalQueue.add(accountNumber);
        System.out.println("Withdrawal request added for Account " + accountNumber);
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            long accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawn $" + amount + " from Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        TreeMap<Double, List<Long>> sortedAccounts = new TreeMap<>();

        for (var entry : accounts.entrySet()) {
            sortedAccounts.putIfAbsent(entry.getValue(), new ArrayList<>());
            sortedAccounts.get(entry.getValue()).add(entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (var entry : sortedAccounts.entrySet()) {
            for (Long accountNumber : entry.getValue()) {
                System.out.println("Account " + accountNumber + " - $" + entry.getKey());
            }
        }
    }
}


