package insurancepolicymanagementsystem2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();

        // Adding sample policies
        policyManager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        policyManager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0));
        policyManager.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(20), "Home", 700.0));
        policyManager.addPolicy(new Policy("P004", "Charlie", LocalDate.now().minusDays(5), "Health", 800.0));

        System.out.println("\nAll Policies:");
        policyManager.displayAllPolicies();

        System.out.println("\nPolicies Expiring in Next 30 Days:");
        System.out.println(policyManager.getExpiringPolicies());

        System.out.println("\nPolicies for Alice:");
        System.out.println(policyManager.getPoliciesByHolder("Alice"));

        System.out.println("\nRemoving Expired Policies...");
        policyManager.removeExpiredPolicies();
        policyManager.displayAllPolicies();
    }
}

