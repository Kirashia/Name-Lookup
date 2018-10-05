package main;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter id: ");
		// Scanner/input
		Scanner in = new Scanner(System.in);
		String id = in.nextLine();
		in.close();
		
		String name = findSinglePerson(id);
		System.out.println("Name: "+name+ "(finding anagrams now...)");
		
		String anagrams = findAnagrams(name);
		
		System.out.println("Anagrams:\n"+anagrams);
	}
	
	public static String findSinglePerson(String id) {		
		// construct URL
		String urlStr = "https://www.ecs.soton.ac.uk/people/"+id;
		// In the case it doesn't exist
		try {
			URL url = new URL(urlStr);
			InputStream is = url.openStream();		// Opens the webpage and reads data from it
			InputStreamReader isr = new InputStreamReader(is); // Intermediate
			BufferedReader br = new BufferedReader(isr);	// Reads the input stream
			
			// Loop to run through all lines of the page
			String line; // each line defined on new iteration
			while((line = br.readLine()) != null) {
				
				// Decides if in the line
				if(line.contains("property=\"name\"")) {
					
					for(String s : line.split("<")) {
						if(s.contains("property=\"name\"")) {
							int nameI = s.indexOf(">") + 1;
							return s.substring(nameI);
						}
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return "No name found under that ID";
	}

	public static String findAnagrams(String word) {
		// construct URL
		String urlStr = "https://new.wordsmith.org/anagram/anagram.cgi?anagram="+word.replace(" ", "+");
		String names = "";
		// In the case it doesn't exist
		try {
			URL url = new URL(urlStr);
			InputStream is = url.openStream();		// Opens the webpage and reads data from it
			InputStreamReader isr = new InputStreamReader(is); // Intermediate
			BufferedReader br = new BufferedReader(isr);	// Reads the input stream
			
			// Loop to run through all lines of the page
			String line; // each line defined on new iteration
			boolean stop = true;
			while((line = br.readLine()) != null) {
				
				if(line.contains("<script>"))
					stop = true;
				
				// Decides if in the line
				if(!stop) {
					names += line+"\n";
				}

				if(line.contains("Displaying all:")) {
					stop = false;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return names.replace("<br>", "").replace("</b>", "");
	}
	
	// Currently doesn't work since it requires login
	public static String findRelatedPeople(String id) {
		String urlStr = "https://secure.ecs.soton.ac.uk/people/"+id+"/related_people";
		
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		String line;
		String rx = "<a href=\"https://secure.ecs.soton.ac.uk/people/";
		
		try {
			URL url = new URL(urlStr);
			is = url.openStream();		// Opens the webpage and reads data from it
			isr = new InputStreamReader(is); // Intermediate
			br = new BufferedReader(isr);
			
			while((line = br.readLine()) != null) {
				if(line.contains(""))
					System.out.println("---"+line);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}
}
