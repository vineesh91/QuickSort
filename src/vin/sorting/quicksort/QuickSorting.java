package vin.sorting.quicksort;

public class QuickSorting {
	private static Comparable[] array;
    
	public QuickSorting(Comparable[] arrayIn) {
    array = arrayIn;	
    }
	
	private static boolean less (Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exch (Comparable [] arr, int pos1, int pos2) {
		Comparable elem = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = elem;
	}
	
	private static int partition (Comparable[] arrayIn, int lo, int hi) {
		Comparable elem = arrayIn[lo];
		int index = lo + 1;
		int closed = lo;
		for (int i = lo + 1; i <= hi; i ++) {
			if (less(arrayIn[i], elem)) {
				exch (arrayIn, i, index);
				closed = index;
				index ++ ;
			}
		}
		exch (arrayIn, lo, closed);
		return closed;
	}
	
	private static void sort (Comparable[] arrIn, int lo, int hi) {
		int mid;
		if (hi <= lo) {
			return;
		}
		mid = partition (arrIn, lo, hi);
		sort (arrIn, lo, mid);
		sort (arrIn, mid + 1, hi);
		
	}
	
	public static void quicksort (Comparable[] arrayIn) {
		int hi = arrayIn.length - 1;
		int lo = 0;
		sort (arrayIn, lo, hi);
	}
	
	public static void main(String[] args) {
		Comparable[] myArray = {6,2,5,1,3,8,4,7};
		quicksort (myArray);
		System.out.println ("The output: ");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(" " + myArray[i]);
		}
	}
}
