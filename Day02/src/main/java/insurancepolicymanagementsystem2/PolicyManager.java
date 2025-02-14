package insurancepolicymanagementsystem2;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicies = new LinkedHashMap<>();
    private NavigableMap<LocalDate, Policy> sortedByExpiry = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring in the next 30 days
    public List<Policy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        return new ArrayList<>(sortedByExpiry.subMap(today, true, next30Days, true).values());
    }

    // List policies by policyholder name
    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, Policy>> iterator = sortedByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, Policy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicies.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
    }

    // Print all policies
    public void displayAllPolicies() {
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}
