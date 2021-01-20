import java.io.*;
import java.util.*;

public class BabyNames{
	@SuppressWarnings("unchecked")
	private static Map<String, Integer>[] boys = new HashMap[10];
	@SuppressWarnings("unchecked")
	private static Map<String, Integer>[] girls = new HashMap[10];
	   public  static void main(String[] args) throws IOException {
	        Scanner input = new Scanner(System.in);
	    	String answer;
	    	readNames();    // method to read the info from the files and add to our Map array
                       // Get user input and continue until done
		do {
			System.out.print("Enter a year (2008-2017): ");
			int year = input.nextInt();input.nextLine();
			System.out.print("Boy or girl? ");
			String sex = input.nextLine().toLowerCase();
			System.out.print("Enter a name: ");
			String name = input.nextLine();
			String newName = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
			
			switch (sex) {
			case "boy":
				if (boys[year-2008].containsKey(newName))
				{
					int rank1 = boys[year-2008].get(newName);
					System.out.println("\nBoy name " + newName + " is ranked #" + rank1 + " in " + year);
				} else {
					System.out.println("\nBoy name " + name + " is not ranked in " + year);
				}
				break;
			case "girl":
				if (girls[year-2008].containsKey(newName))
				{
					int rank2 = girls[year-2008].get(newName);
					System.out.println("\nGirl name " + newName + " is ranked #" + rank2 + " in " + year);
				} else {
					System.out.println("\nGirl name " + name + " is not ranked in " + year);
				}
				break;
			}
			
			System.out.print("\nDo you want check another name (yes or no)?");
			answer = input.nextLine().toLowerCase();
		} while (answer.equals("yes"));
						
	       } // end main

		
		//read information from each file and add to appropriate Map array
		public static void readNames() throws IOException 
		{
			File infile;
			for(int i=0;i<10;++i) 
			{
				boys[i] = new HashMap<>();
				girls[i] = new HashMap<>();
				
			}
			
			int y = 2008;
			for(int i=0;i<=9;++i) {
				  // construct the file name
				String filename = "dataFiles/babynameranking" + y++ + ".txt"; 
				infile = new File(filename);
				
				Scanner in = new Scanner(infile);
				while(in.hasNext()) {
					String line = in.nextLine();
					
					int j = 0;
					while (line.charAt(j) != '	')
					{
						j++;
					}
					String rank = line.substring(0,j);
					j++;
					
					int k = j;
					while (line.charAt(j) != '	')
					{
						j++;
					}
					String boyName = line.substring(k, j);
					j++;
					
					while (line.charAt(j) != '	')
					{
						j++;
					}
					j++;
					
					int l = j;
					while (line.charAt(j) != '	')
					{
						j++;
					}
					String girlName = line.substring(l, j);
					
					boys[i].put(boyName, java.lang.Integer.parseInt(rank));
					girls[i].put(girlName, java.lang.Integer.parseInt(rank));
					
				} // end while
				in.close();
				
			} // end for loop
		} // end readNames()
} // end Lab08
