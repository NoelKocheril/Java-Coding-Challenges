package c_300;

import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {

	// Number of Entries Created
	private int numVoters;
	
	// Highest Possible Voter Number
	// Pigeon Hole Principle will determine if there are duplicates
	private int maxVoterNum;
	
	// Highest Candidate ID
	private int maxCandidate_ID;
	
	//Default Generator Settings	
	public Generator() {
		this.numVoters = 10000;
		this.maxVoterNum = 2000000;
		this.maxCandidate_ID = 10;
	}
	
	// Controllable Values
	public Generator(int numVoters, int maxVoterNum, int maxCandidate_ID) {
		this.numVoters = numVoters;
		this.maxVoterNum = maxVoterNum;
		this.maxCandidate_ID = maxCandidate_ID;
	}
	
	/**
	 * 
	 * @param fname - Path to the File
	 * @throws IOException If an I/O Error Occurs
	 */
	public void generate(String fname) throws IOException {
		// Checks if Path exists, if not creates one
		File file = new File(fname);
		if(!file.exists()) {
	    	file.createNewFile();
	    } 
		
		Random rdm = new Random();
	    int voter_id, cand_id;
	    String output = "";
	    
	    // Create numVoter Entries Format: VOTER_NUM, CAND_ID
	    for(int i = 0; i < numVoters; i++) {
	    	voter_id = rdm.nextInt(maxVoterNum)+1;
	    	cand_id = rdm.nextInt(maxCandidate_ID);
	    	//System.out.printf("Voter ID: %07d, Candidate ID: %02d \n", voter_id, cand_id);
	    	// Reduce Number of Writes to File
	    	output += String.format("%07d, %02d \n", voter_id, cand_id);
	    }
	    // Create Writer and Writes to File
	    BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
	    out.write(output);	
	    out.close();
	}

	public static void main (String[] args) throws IOException {
		Generator gen = new Generator();
		LocalDateTime _now = LocalDateTime.now();
		String out = String.format("%04d-%02d-%02dT%02d.%02d.%02d", _now.getYear(), _now.getMonth().getValue(), _now.getDayOfMonth(), _now.getHour(), _now.getMinute(), _now.getSecond());
		System.out.println(out);
		String fname = "c:/temp/"+out+".txt";
		System.out.println(fname);
		gen.generate(fname);
	}

}
