package c_300;

import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {

	private int numVoters;
	private int startingVoterNum;
	private int maxCandidate_ID;
	
	
	public Generator() {
		this.numVoters = 1000;
		this.startingVoterNum = 1000000;
		this.maxCandidate_ID = 10;
	}
	
	public Generator(int numVoters, int startingVoterNum, int maxCandidate_ID) {
		this.numVoters = numVoters;
		this.startingVoterNum = startingVoterNum;
		this.maxCandidate_ID = maxCandidate_ID;
	}
	
	public void generate(File file) throws IOException {
	    if(!file.exists()) {
	    	file.createNewFile();
	    }
		
		BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
	    Random rdm = new Random();
	    
	    int voter_id, cand_id;
	    String output = "";
	    
	    System.out.println("");
	    for(int i = 0; i < 10; i++) {
	    	voter_id = rdm.nextInt(1000000) + startingVoterNum;
	    	cand_id = rdm.nextInt(maxCandidate_ID);
	    	System.out.printf("Voter ID: %d, Candidate ID: %d \n", voter_id, cand_id);
	    	output += String.format("%d, %d \n", voter_id, cand_id);
	    	out.write(output);	
	    }
	    out.close();
	}

	public static void main (String[] args) throws IOException {
		Generator gen = new Generator();
		String fname = "C:\\"+LocalDateTime.now()+".txt";
		File file = new File(fname);
		System.out.println(fname);
		gen.generate(file);
	}

}
