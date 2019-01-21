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
	private int maxVoterNum;
	private int maxCandidate_ID;
	
	
	public Generator() {
		this.numVoters = 10000;
		this.maxVoterNum = 2000000;
		this.maxCandidate_ID = 10;
	}
	
	public Generator(int numVoters, int maxVoterNum, int maxCandidate_ID) {
		this.numVoters = numVoters;
		this.maxVoterNum = maxVoterNum;
		this.maxCandidate_ID = maxCandidate_ID;
	}
	
	public void generate(String fname) throws IOException {
		File file = new File(fname);
		if(!file.exists()) {
	    	file.createNewFile();
	    } 
		
		BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
	    Random rdm = new Random();
	    
	    int voter_id, cand_id;
	    String output = "";
	    
	    for(int i = 0; i < numVoters; i++) {
	    	voter_id = rdm.nextInt(maxVoterNum)+1;
	    	cand_id = rdm.nextInt(maxCandidate_ID);
	    	//System.out.printf("Voter ID: %07d, Candidate ID: %02d \n", voter_id, cand_id);
	    	output += String.format("%07d, %02d \n", voter_id, cand_id);
	    }
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
