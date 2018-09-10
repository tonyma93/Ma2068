package lab6;

import java.util.Random;

public class Sorting2<T extends Comparable<T>>{
	public static void main(String[] args){
		Random randNumGenerator = new Random();
		int n = 60;
		Object[] list = new Object[n];
		for (int i=0; i < list.length; i++)
		{
			list[i] = (randNumGenerator.nextInt(90)+1);
			System.out.print(list[i]+" ");
		}
		System.out.println("");
		quickSort(list);
		for(int i = 0; i<list.length;i++){
			System.out.print(list[i]+" ");
		}

	}
	public static<T extends Comparable<T>> void quickSort(Object[] list){
		quickSort(list, 0, list.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(Object[] list, int first, int last) {

		if (last > first) {
			if(last - first <= 64){
				insertionSort(list);
			}
			else{
				int pivotIndex = partition(list, first, last);
				quickSort(list, first, pivotIndex - 1);//subarray
				quickSort(list, pivotIndex + 1, last);
			}
			}
	}

	private static <T extends Comparable<T>> Object[] insertionSort(Object[] list) {
		int temp;
		for (int i = 1; i < list.length;i++){
			for(int j = i ; j > 0; j--){
				if(((Comparable<T>) list[j]).compareTo((T) list[j-1]) < 0){//checks end of array and goes <--
					temp = (int) list[j];
					list[j]= list[j-1];
					list[j-1]=temp;				
				}
			}
		}
		return list;

	}
	private static <T extends Comparable<T>>int partition(Object[] list, int first, int last) {
		T pivot = (T) list[(first)]; 
		int low = first ; 
		int high = last; 

		while (high > low) {//search from left
			while ( ((Comparable<T>) list[low]).compareTo(pivot) <= 0){
				low++;
			}
			while (((Comparable<T>) list[high]).compareTo(pivot) > 0){//searching from right
				high--;
			}
			if (high > low) {//swap
				int temp = (int) list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}


		//while (((Comparable<T>) list[high]).compareTo(pivot) >= 0){
			//high--;
		//}
		if (pivot.compareTo((T) list[high])> 0) {//swapping pivot, pivot is in right place now
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
}
	
