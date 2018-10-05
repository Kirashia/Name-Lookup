package main;

import java.io.*;
import java.net.*;

public class Tests {

	public static void main(String[] args) throws IOException {
		 
		String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		String query = "java tutorial";
		String charset = "UTF-8";
	 
		URL url = new URL(address + URLEncoder.encode(query, charset));
	 
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String str;
	 
		while ((str = in.readLine()) != null) {
			System.out.println(str);
		}
	 
		in.close();
	}
	
}
