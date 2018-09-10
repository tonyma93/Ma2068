package lab1;
import java.util.ArrayList;
import java.util.Scanner;
public class Ma_Lab_1 {
	
	//Program written by Tony Ma on 1/26/2017
	
	static ArrayList<Integer> myList = new ArrayList<Integer>();
	
	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		boolean option = true;

		
		while(option){
			try{
			System.out.println("Please enter 3 numbers separated by a space or the word: Answer or Previous");
			String choice = keyboard.nextLine();
			String[] numbers = choice.split(" ");
			if(choice.equalsIgnoreCase("answer")){
				System.out.println("What is the pattern in the sequence?");
				String userAnswer = keyboard.nextLine();
				answer(userAnswer);
				option = false;
			}				
			else if(choice.equalsIgnoreCase("previous")){
				System.out.println("Previous choices" +myList);
			}
			else{
				convert(numbers);
			}
			}
			
			catch (Exception e){
				System.out.println("Invalid choice " +e);
			}
			}
		keyboard.close();
	}


	public static void answer(String s){
			if(s.contains("inc")){
				System.out.println("Correct");
			}
			else{
				System.out.println("Incorrect, the correct answer is: Increasing");
			}				
		}
	public static void convert(String[] num){
		int[] sequence = new int[num.length];
		if(num.length != 3){
			System.out.println("Invalid choice");
		}
		else{
		for(int i = 0; i < num.length; i++){
			sequence[i] = Integer.parseInt(num[i]);		
			myList.add(sequence[i]);
		}
		for(int i = 0; i < sequence.length-2; i++){
			if(sequence[i] < sequence[i+1] && sequence[i+1] < sequence[i+2]){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
	}
		}
	}
}
