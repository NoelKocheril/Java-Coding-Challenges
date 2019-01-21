package c_300;

/**
 * This problem was asked by Uber.
   
   On election day, a voting machine writes data in the form (voter_id, candidate_id)
   to a text file. Write a program that reads this file as a stream and returns the 
   top 3 candidates at any given time. If you find a voter voting more than once, 
   report this as fraud.
 */

import java.util.*;
import java.io.File;
import java.io.IOException;

public class Solver {
	public static void main(String[] args) throws IOException {

		HashSet<Integer> voters = new HashSet<Integer>();
		HashSet<Integer> fraud_voters = new HashSet<Integer>();
		HashMap<Integer, Integer> cand_votes = new HashMap<Integer, Integer>();

		String FName = "C:/temp/voter_info.txt";
		File file = new File(FName);
		// Generate File Information 
		Generator gen = new Generator(30000, 3000000, 20);
		gen.generate(FName);
		Scanner in = new Scanner(file);
		
		// Go Through File
		while(in.hasNextLine()) {
			// Separate Each Line by , into 2 values (Voter_ID and Cand_ID)
			String input[] = in.nextLine().split(",");
			int voter = Integer.parseInt(input[0].trim());
			int cand = Integer.parseInt(input[1].trim());
			
			//Checks if Voter has already voted, if so voter has committed fraud
			if(voters.contains(voter)) {
				fraud_voters.add(voter);
				//System.out.printf("Voter %07d commited Fraud!!!!%n", voter);
			// Otherwise add to count
			} else {
				voters.add(voter);
				// Add to Associated Pool
				if(cand_votes.containsKey(cand)) {
					int votes = cand_votes.get(cand) + 1;
					cand_votes.put(cand, votes);
				// Create pool if doesn't exists
				} else {
					cand_votes.put(cand, 1);
				}
//				System.out.printf("Voter: %s, Candidate: %s %n", input[0], input[1]);	
			}
		}
		// Produce Final Results
		System.out.println("\nFinal Results");
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		// Gets First Cand_Votes Key
		int best = (int) cand_votes.keySet().toArray()[0];
		
		// Finds out which Candidate has the most votes and prints out winner
		for(int i : cand_votes.keySet()) {
			if(cand_votes.get(i) > cand_votes.get(best)) {
				best = i;
			}
			System.out.printf("Candidate %02d: %04d %n", i, cand_votes.get(i));
		}
		System.out.printf("%nCandidate %02d Won! %n", best);
		
		// Lists each Voter who Committed Fraud
		System.out.printf("%nCount: %d%nFraud Voters%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n", fraud_voters.size());
		for(int f : fraud_voters) {
			System.out.printf("Voter #: %07d %n", f);
		}
		in.close();
	}
}
