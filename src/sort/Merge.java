package sort;
/**
 * @author Tasmiha Hassan, hassat3, 400083305
 * @version Eclipse Luna 
 */
public class Merge {
	//Reference to page 273 of Algorithms textbook
	
	private static Comparable[] aux;
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		aux = new Comparable[n];
		sort(x, 0, n-1);
	}
	
	//Uses recursion to sort the two parts of the array, the part before and after the partition element
	private static void sort(Comparable[] x, int lo, int hi){
		if (hi <=lo) 
			return;
		int mid = lo + (hi - lo)/2;
		sort(x, lo, mid);
		sort(x, mid+1, hi);
		merge(x, lo, mid, hi);
	}
	
	//Combines the two separate sorted arrays together with the mid value between them
	public static void merge(Comparable[] x, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++)
			aux[k] = x[k];
		
		for (int k = lo; k <=hi; k++){
			if (i > mid)
				x[k] = aux[j++]; 
			else if (j > hi)
				x[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				x[k] = aux[j++];
			else 
				x[k] = aux[i++];
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
}
