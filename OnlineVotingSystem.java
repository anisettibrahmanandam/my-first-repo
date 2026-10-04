import java.util.*;

public class OnlineVotingSystem {
    static HashMap<String, String> students = new HashMap<>(); // username → password
    static HashMap<String, Integer> candidates = new HashMap<>(); // candidate → votes
    static HashSet<String> votedStudents = new HashSet<>(); // track who voted

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Candidate list initialization (updated names)
        candidates.put("Brahma", 0);
        candidates.put("Nagu", 0);
        candidates.put("Chaitanya", 0);

        while (true) {
            System.out.println("\n--- College Election Voting System ---");
            System.out.println("1. Register");
            System.out.println("2. Login & Vote");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: register(sc); break;
                case 2: loginAndVote(sc); break;
                case 3: displayResults(); break;
                case 4: 
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void register(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (students.containsKey(user)) {
            System.out.println("User already exists!");
        } else {
            students.put(user, pass);
            System.out.println("Registration successful!");
        }
    }

    static void loginAndVote(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (students.containsKey(user) && students.get(user).equals(pass)) {
            if (votedStudents.contains(user)) {
                System.out.println("You have already voted!");
                return;
            }

            System.out.println("Candidates:");
            for (String candidate : candidates.keySet()) {
                System.out.println("- " + candidate);
            }

            System.out.print("Enter candidate name to vote: ");
            String vote = sc.nextLine();

            if (candidates.containsKey(vote)) {
                candidates.put(vote, candidates.get(vote) + 1);
                votedStudents.add(user);
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("Invalid candidate!");
            }
        } else {
            System.out.println("Invalid login!");
        }
    }

    static void displayResults() {
        System.out.println("\n--- Election Results ---");
        String winner = null, runnerUp = null;
        int maxVotes = -1, secondMax = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " votes");

            int votes = entry.getValue();
            if (votes > maxVotes) {
                runnerUp = winner;
                secondMax = maxVotes;
                winner = entry.getKey();
                maxVotes = votes;
            } else if (votes > secondMax) {
                runnerUp = entry.getKey();
                secondMax = votes;
            }
        }

        System.out.println("Winner: " + (winner != null ? winner : "No votes yet"));
        System.out.println("Runner-up: " + (runnerUp != null ? runnerUp : "No runner-up yet"));
    }


		
	}

