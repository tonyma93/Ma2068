
public class Eratosthenes {
	static int n = 100;
	static boolean[] list = new boolean[n+1]; //this creates an array list for all the integers n
	public static void main(String[] args) {
		System.out.println("The following is a list of numbers n");
		for (int i = 2; i < n+1; i++)
		{
			list[i] = true;  // this makes every element in the list true, in this case, prime
			System.out.print(i+" "); // this prints out every element in the list.

		}
		System.out.println();
		System.out.println();
		System.out.println("After running the tester, the following numbers are prime in the list");
		test(list,2,n);// this method runs the tester to find the prime numbers
	}
	private static void test(boolean[] list, int k, int n) {
		while(k*k <= n){//k is the first element of the list, when k^2 is <= n (100) move to the next step
			if(list[k]==true){//this means if the element k is true (prime) move to next step
				for(int j = k+k; j <= n; j += k){ //makes multiples of k false. eg: if k = 2, 4,6,8...is false (not prime)
					list[j]=false;
				}
			}
			k++; // increments k, 2,3,4...until k^2 <= n, which will end the while loop.
		}		
		
		for(int i = 2; i <= n;i++){//this checks the list and prints out the values that remained true(prime) after the while loop.
			if(list[i] == true){
				
				System.out.print(i +" ");
			}
		}
	}
}
