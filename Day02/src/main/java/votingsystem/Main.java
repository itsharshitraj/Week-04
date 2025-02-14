package votingsystem;

public class Main {
    public static void main(String[] args) {
        VotingManager votingManager = new VotingManager();

        // Casting votes
        votingManager.castVote("Alice");
        votingManager.castVote("Bob");
        votingManager.castVote("Alice");
        votingManager.castVote("Charlie");
        votingManager.castVote("Bob");
        votingManager.castVote("Alice");

        // Display results
        votingManager.displayVoteOrder();
        votingManager.displaySortedResults();
        votingManager.displayWinner();
    }
}


