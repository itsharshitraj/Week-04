package votingsystem;

import java.util.*;

public class VotingManager {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();

    // Cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate)); // Maintain order
    }

    // Display results sorted by candidate names
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteMap);
        System.out.println("\nVoting Results (Sorted Alphabetically):");
        for (var entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display votes in the order they were cast
    public void displayVoteOrder() {
        System.out.println("\nVoting Order (First to Last Vote Cast):");
        for (var entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display the winner
    public void displayWinner() {
        String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nWinner: " + winner + " with " + voteMap.get(winner) + " votes!");
    }
}

