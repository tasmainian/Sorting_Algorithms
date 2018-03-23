package sort;
/**
 * @author Tasmiha Hassan, hassat3, 400083305
 * @version Eclipse Luna 
 */
public class Insertion {
	
	/**
	 * exchange function without Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param i, j - the indices that contain that values to swap
	 */
	public static void exchange(Job[] x, int i, int j){
		Job a = x[i];
		x[i] = x[j];
		x[j] = a;
	}
	
	/**
	 * compares the JobNames to order them lexicographically
	 * @param a, b - the names of two Jobs with the same processing time
	 * @return a boolean value to determine if the values should be swapped or not
	 */
	public static boolean lexi(String a, String b){
		int n, g;
		
		//finds the smaller array as the limit for the for loop
		if (a.length()<=b.length()){
			n = a.length();
			g = 1;
		}
		else{
			n = b.length();
			g = -1;
		}
		
		//compares each char value to find which word comes first
        for (int i = 0; i < n; i++) {
            char A = a.charAt(i);
            char B = b.charAt(i);

            if (A < B) {
                return true;
            } else if (B > A) {
                return false;
            }
        }

        //if one word ends and the letters are the same, picks the smaller word
        if (g == 1) {
            return true;
        } else {
            return false;
        }
	}
	
	/**
	 * regular insertion sort
	 * @param x - the input array containing jobs that need to be sorted.
	 */
	//REFERENCE From PAGE 251 OF Algorithms textbook
	public static void sortInsert ( Job[] x ) {
		int n = x.length;
		for (int i = 1; i < n; i++){
			for (int j = i; j > 0; j--){
				//uses nested for loop to compare processing times
				if (x[j].getProcessingTime() < x[j-1].getProcessingTime()){
					exchange(x, j, j-1); //exchanges if out of order
				}
				
				//if same processingTime, compares alphabetically
				else if (x[j].getProcessingTime() == x[j-1].getProcessingTime()){
		            if (lexi(x[j].getJobName(), x[j-1].getJobName())){
		            	exchange(x, j, j-1);
		            }
				}
			}
		}
		
		
	}
	
	//PAGE 251 OF Algorithms textbook
	
	/**
	 * less function with Comparable
	 * @param v, w - two elements of the array that need to be compared
	 * @return a boolean value
	 */
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0; //checks to see if x[j] is less that x[j-1]
		//if so, it is out of order, and will return true
	}
	
	/**
	 * exchange function with Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param i, j - the indices that contain that values to swap
	 */
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; 
		a[i] = a[j]; 
		a[j] = t;
	}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for (int i = 1; i < n; i++){
			for (int j = i; j > 0 && less(x[j], x[j-1]); j--){
				exch(x, j, j-1);
			}
		}
	}
	
	/**
	 * optimized insertion sort
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	//REFERENCE from Algorithms, 4th Edition Online Code Examples
	public static void sortBinary ( Comparable[] x, int n ) {
        for (int i = 1; i < n; i++) {

            // Binary search to determine index j at which to insert a[i]
            Comparable v = x[i];
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2; 
                if (less(v, x[mid])) hi = mid;
                else                 lo = mid + 1;
            }

            // Insertion sort, exchanging half at a time
            for (int j = i; j > lo; --j)
                x[j] = x[j-1];
            x[lo] = v;
        }
	}
	
	
}
