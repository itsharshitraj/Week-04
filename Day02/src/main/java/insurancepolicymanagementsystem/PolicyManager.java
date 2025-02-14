package insurancepolicymanagementsystem;

import java.util.*;
import java.time.LocalDate;

class PolicyManager {
    private HashSet<Policy> policyHashSet;
    private LinkedHashSet<Policy> policyLinkedHashSet;
    private TreeSet<Policy> policyTreeSet;

    public PolicyManager() {
        policyHashSet = new HashSet<>();
        policyLinkedHashSet = new LinkedHashSet<>();
        policyTreeSet = new TreeSet<>();
    }

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }

    // Get policies expiring within next 30 days
    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        for (Policy policy : policyHashSet) {
            if (!policy.getExpiryDate().isAfter(thirtyDaysFromNow) &&
                    !policy.getExpiryDate().isBefore(today)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    // Get policies by coverage type
    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> matchingPolicies = new HashSet<>();
        for (Policy policy : policyHashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                matchingPolicies.add(policy);
            }
        }
        return matchingPolicies;
    }

    // Performance comparison methods
    public void performanceComparison() {
        // Test adding policies
        long startTime = System.nanoTime();
        policyHashSet.add(new Policy("TEST1", "Test User", LocalDate.now(), "Health", 1000));
        long hashSetAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        policyLinkedHashSet.add(new Policy("TEST1", "Test User", LocalDate.now(), "Health", 1000));
        long linkedHashSetAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        policyTreeSet.add(new Policy("TEST1", "Test User", LocalDate.now(), "Health", 1000));
        long treeSetAddTime = System.nanoTime() - startTime;

        System.out.println("Add Operation Times (ns):");
        System.out.println("HashSet: " + hashSetAddTime);
        System.out.println("LinkedHashSet: " + linkedHashSetAddTime);
        System.out.println("TreeSet: " + treeSetAddTime);
    }

    // Getters for different sets
    public Set<Policy> getPolicyHashSet() {
        return new HashSet<>(policyHashSet);
    }

    public Set<Policy> getPolicyLinkedHashSet() {
        return new LinkedHashSet<>(policyLinkedHashSet);
    }

    public Set<Policy> getPolicyTreeSet() {
        return new TreeSet<>(policyTreeSet);
    }
}
