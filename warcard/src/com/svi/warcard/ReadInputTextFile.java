package com.svi.warcard;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadInputTextFile {
	private String[] tokensCards;
	private boolean flgProcess;
	
	public void readInputTextFile() {
		ArrayList<String> tokenList = new ArrayList<>();
		
//		// ***temp approach for feeding input. due to java.io.FileNotFoundException:(Access is denied)
//		String line = "D-A,D-K,D-Q,D-J,D-10,D-9,D-8,D-7,D-6,D-5,D-4,D-3,D-2,H-A,H-K,H-Q,H-J,H-10,H-9,H-8,H-7,H-6,H-5,H-4,H-3,H-2,S-A,S-K,S-Q,S-J,S-10,S-9,S-8,S-7,S-6,S-5,S-4,S-3,S-2,C-A,C-K,C-Q,C-J,C-10,C-9,C-8,C-7,C-6,C-5,C-4,C-3,C-2";
//		ArrayList<String> tokenList = new ArrayList<>();
//		StringTokenizer tokenizer = new StringTokenizer(line, ",");
//		while (tokenizer.hasMoreTokens()) {
//			String token = tokenizer.nextToken();
//			// System.out.println(token); // Process or store the token as needed
//			tokenList.add(token);
//		}
//		tokensCards = tokenList.toArray(new String[0]); // transfer data from tokenlist into tokensCards
//		flgProcess = true;
		
		//end of temp approach
		
		
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Eclipse Project File Path: " + projectPath);
		
		String filePath = "input/input.txt"; 
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
	        while ((line = br.readLine()) != null) {
	        	StringTokenizer tokenizer = new StringTokenizer(line, ",");
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					tokenList.add(token);
				}

			tokensCards = tokenList.toArray(new String[0]); //transfer data from tokenlist into tokenArray
//	        System.out.println("\nDeck before the shuffle ");
//	        for (String card : tokensCards) {
//	        	System.out.println(card);
//	      	}
	          flgProcess = true;   
	        }
		 }catch (IOException e) {
	            e.printStackTrace();
	            flgProcess = false;  //if input text file is null, need to set flgProcess to false
		 }
		 
//		System.out.println("ReadInputTextFile: tokensCards");
//		String result = String.join(", ", tokensCards);
//        System.out.println(result);
		
	}
		
//    	//string tokenizer for input text file 
////		String inputPath = "C:\\BA Training\\War Card\\input.txt";
//		String inputPath = "C:\\Users\\Public\\WardCard\\"; //directory in home
//		
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
//            String line;
//            ArrayList<String> tokenList = new ArrayList<>();            
//            while ((line = reader.readLine()) != null) {
//                StringTokenizer tokenizer = new StringTokenizer(line, ",");
//                while (tokenizer.hasMoreTokens()) {
//                    String token = tokenizer.nextToken();
//                    // Process or store the token as needed
//                    //System.out.println(token);
//                    tokenList.add(token);
//                }
//            }
//		
//            tokensCards = tokenList.toArray(new String[0]);  //transfer data from tokenlist into tokenArray
//        
//            System.out.println("\nDeck before the shuffle ");
//            for (String card : tokensCards) {
//            	System.out.println(card);
//        		}
//            flgProcess = true;        
//        } catch (IOException e) {
//            e.printStackTrace();
//            flgProcess = false;  //if input text file is null, need to set flgProcess to false
//            }		
//	}
	
	public String[] getTokensCards() {
		return tokensCards;
	}	
	
	public boolean getFlgProcess() {
		return flgProcess;
	}
}
