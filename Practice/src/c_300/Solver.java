package c_300;

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
		Generator gen = new Generator(30000, 3000000, 20);
		gen.generate(FName);
		Scanner in = new Scanner(file);
		while(in.hasNextLine()) {
			String input[] = in.nextLine().split(",");
			int voter = Integer.parseInt(input[0].trim());
			int cand = Integer.parseInt(input[1].trim());
			if(voters.contains(voter)) {
				fraud_voters.add(voter);
				System.out.printf("Voter %07d commited Fraud!!!!%n", voter);
			} else {
				voters.add(voter);
				if(cand_votes.containsKey(cand)) {
					int votes = cand_votes.get(cand) + 1;
					cand_votes.put(cand, votes);
				} else {
					cand_votes.put(cand, 1);
				}
//				System.out.printf("Voter: %s, Candidate: %s %n", input[0], input[1]);	
			}
		}
		System.out.println("\nFinal Results");
		System.out.println("~~~~~~~~~~~~~~~~~");
		int best = 0;
		for(int i : cand_votes.keySet()) {
			if(cand_votes.get(i) > cand_votes.get(best)) {
				best = i;
			}
			System.out.printf("Candidate %02d: %04d %n", i, cand_votes.get(i));
		}
		System.out.printf("%nCandidate %02d Won! %n", best);
		
		System.out.printf("%nCount: %d%nFraud Voters%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n", fraud_voters.size());
		for(int f : fraud_voters) {
			System.out.printf("Voter #: %07d %n", f);
		}
		in.close();
	}
}
