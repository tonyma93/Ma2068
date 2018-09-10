package lab4;

public class Towers_Of_Hanoi {

	public static void main(String[] args) {
		int n = 3;
		showMoves(n,'A','C','B');
		// TODO Auto-generated method stub

	}
	
	public static void showMoves(int n, char start, char dest, char temp){
		if(n==1){
			System.out.println( " Move disk 1 from peg " + start + " to peg "+ dest + "\n");
		}
		else {
		showMoves(n-1,start,temp,dest) ;
		System.out.println(" Move disk " + n + " from peg "+ start + " to peg "+ dest + "\n"); 
		showMoves(n-1, temp,dest,start); 
		}
		
	}
}
