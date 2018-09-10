package lab1;

import java.util.Scanner;

public class quizpractice {

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		try{
			System.out.println("NextDouble");
			double dub = Scanner.nextDouble();
			System.out.println(dub*2);
		}
		catch(Exception e){
			System.out.println(e+"invalid");
		}
	}

}
