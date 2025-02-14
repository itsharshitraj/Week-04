package insurancepolicymanagementsystem;

import java.time.LocalDate;

public class InsuranceManagementSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Create sample policies
        Policy policy1 = new Policy("P001", "John Doe", LocalDate.now().plusDays(15),
                "Health", 1500.0);
        Policy policy2 = new Policy("P002", "Jane Smith", LocalDate.now().plusDays(45),
                "Auto", 800.0);
        Policy policy3 = new Policy("P003", "Bob Johnson", LocalDate.now().plusDays(10),
                "Home", 2000.0);

        // Add policies
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);

        // Demonstrate functionality
        System.out.println("All Policies (HashSet):");
        manager.getPolicyHashSet().forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nAuto Insurance Policies:");
        manager.getPoliciesByCoverageType("Auto").forEach(System.out::println);

        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        manager.getPolicyTreeSet().forEach(System.out::println);

        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        manager.performanceComparison();
    }
}
