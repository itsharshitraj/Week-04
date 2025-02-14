package bankingsystem;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 10000);
        bank.addAccount(1004, 2500);

        // Depositing money
        bank.deposit(1002, 1500);

        // Requesting withdrawals
        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1003);
        bank.requestWithdrawal(1004);

        // Processing withdrawals
        bank.processWithdrawals(2000);

        // Display accounts sorted by balance
        bank.displaySortedAccounts();
    }
}


