package lab5;


import java.io.*;

public class ReadingFromFileExample {
	
	// adapted from 
	// https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
	public static void main(String [] args) {

		String fileName = "pg2240.txt";
		String line = null;
		BufferedReader bufferedReader;

		try {

			bufferedReader= new BufferedReader(new FileReader(fileName));

			while(bufferedReader.ready()) {
				//line = bufferedReader.readLine();

				System.out.println(line);
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", "");
					System.out.println(word);
				}
			}

			bufferedReader.close();         
		}
		catch(FileNotFoundException e) { 
			System.err.println("File not found");                
		}
		// catch any other exception
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

