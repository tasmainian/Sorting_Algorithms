package sort;

import java.io.*; 
import java.util.*;
import org.apache.commons.lang3.time.StopWatch;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author Tasmiha Hassan, hassat3, 400083305
 * @version Eclipse Luna 
 */
public class SortTest {
	public static StopWatch clock;
	public static String line1, line2, line3, line4, line5;
	public double time;

	@Test
	/**
	 * This test will check to see if any of the lines are null
	 * If so, it will return false
	 */
	public void readFromFileTest() {
		readFromFile();
		assertTrue(line1 != null 
				&& line2 != null 
				&& line3 != null
				&& line4 != null
				&& line5 != null);
	}
	
	/**
	 * @return Reads the 5 lines from the input file
	 * and outputs them as string arrays
	 */
	public static void readFromFile() {
		//reading 5 lines from the input file
		try {
			BufferedReader inputReader = new BufferedReader(new FileReader("./data/a1_in.txt"));
			line1 = inputReader.readLine();
			line2 = inputReader.readLine();
			line3 = inputReader.readLine();
			line4 = inputReader.readLine();
			line5 = inputReader.readLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't find file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param String array consisting of an array of JobID and processing times
	 * @return The processed arrays in the object type
	 */
	public static Job[] jobArray(String array){
		array = array.replaceAll("\\{|}", "");	//Replacing the {, } from the string
		String[] segment = array.split(","); 	//Split the string into an array 
		Job[] jobs = new Job[segment.length/2];
		for (int i = 0; i < segment.length/2; i++){
			//every even element is the JobID, every odd Element is the processing time
			Job newJob = new Job(segment[i*2], Integer.parseInt(segment[i*2+1])); 
			jobs[i] = newJob; //append to the end of the array
		}
		return jobs;
	}
	
	/**
	 * @param Arrays of object Job[]
	 * @return A boolean value
	 * True of the array has been ordered in increasing order
	 * False if it is not sorted properly
	 */
	public static boolean isSorted(Job[] x){
		//Test that each item is greater than the item before it. 
		for (int i = 1; i < x.length; i++){
			while(x[i-1].compareTo(x[i]) < 1){
				return true;
			}
		}
		return false;
	}
	

	@Test
	/**
	 * This test will check to see the function, sortInsert 
	 * is able to sort arrays 1 through 5 of the input file accurately
	 * It will also print out the timings it took for each sort
	 */	
	public void testSortInsert(){
		Job[] x1 = jobArray(line1); //Calls jobArray function to make each line of string, type Job
		clock = new StopWatch(); //Initializes the stop watch
		clock.reset(); //Resets the value each time 
		clock.start(); //Starts the timer
		Insertion.sortInsert(x1); //Calls insertion sort to sort the array
		clock.stop(); //Stops the timer
		assertTrue(isSorted(x1)); //Calls the boolean method to test if it was sorted in order
		time = clock.getNanoTime() * 1e-9; //For a more accurate and precise time measurement
		System.out.print("testSortInsert time[1-5]: " + time); //Prints the time value for the user to see
		//System.out.println(Arrays.toString(x1));
		
		//Process repeats for every array in the input file
		Job[] x2 = jobArray(line2);
		clock.reset();
		clock.start();
		Insertion.sortInsert(x2);
		clock.stop();
		assertTrue(isSorted(x2));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x2));
				
		Job[] x3 = jobArray(line3);
		clock.reset();
		clock.start();
		Insertion.sortInsert(x3);
		clock.stop();
		assertTrue(isSorted(x3));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x3));
		
		
		Job[] x4 = jobArray(line4);
		clock.reset();
		clock.start();
		Insertion.sortInsert(x4);
		clock.stop();
		assertTrue(isSorted(x4));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x4));
		
		Job[] x5 = jobArray(line5);
		clock.reset();
		clock.start();
		Insertion.sortInsert(x5);
		clock.stop();
		assertTrue(isSorted(x5));
		time = clock.getNanoTime() * 1e-9;		
		System.out.println(", " + time);
		//System.out.println(Arrays.toString(x5));		
	}
	
	

	@Test
	/**
	 * This test will check to see the function, sortComparable 
	 * is able to sort arrays 1 through 5 of the input file accurately
	 * It will also print out the timings it took for each sort
	 */	
	public void testInsertComparable(){
		Job[] x1 = jobArray(line1);
		clock = new StopWatch();
		clock.reset();
		clock.start();
		Insertion.sortComparable(x1, x1.length);
		clock.stop();
		assertTrue(isSorted(x1));
		time = clock.getNanoTime() * 1e-9;
		System.out.print("testsortComparable time[1-5]: " + time);
		//System.out.println(Arrays.toString(x1));
		
		Job[] x2 = jobArray(line2);
		clock.reset();
		clock.start();
		Insertion.sortComparable(x2, x2.length);
		clock.stop();
		assertTrue(isSorted(x2));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x2));
				
		Job[] x3 = jobArray(line3);
		clock.reset();
		clock.start();
		Insertion.sortComparable(x3, x3.length);
		clock.stop();
		assertTrue(isSorted(x3));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x3));
		
		
		Job[] x4 = jobArray(line4);
		clock.reset();
		clock.start();
		Insertion.sortComparable(x4, x4.length);
		clock.stop();
		assertTrue(isSorted(x4));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x4));
		
		Job[] x5 = jobArray(line5);
		clock.reset();
		clock.start();
		Insertion.sortComparable(x5, x5.length);
		clock.stop();
		assertTrue(isSorted(x5));
		time = clock.getNanoTime() * 1e-9;		
		System.out.println(", " + time);
		//System.out.println(Arrays.toString(x1));		
	}
	
	
	@Test
	/**
	 * This test will check to see the function, sortBinary
	 * is able to sort arrays 1 through 5 of the input file accurately
	 * It will also print out the timings it took for each sort
	 */	
	public void testInsertBinary(){
		Job[] x1 = jobArray(line1);
		clock = new StopWatch();
		clock.reset();
		clock.start();
		Insertion.sortBinary(x1, x1.length);
		clock.stop();
		assertTrue(isSorted(x1));
		time = clock.getNanoTime() * 1e-9;
		System.out.print("testSortBinary time[1-5]: " + time);
		//System.out.println(Arrays.toString(x1));
		
		Job[] x2 = jobArray(line2);
		clock.reset();
		clock.start();
		Insertion.sortBinary(x2, x2.length);
		clock.stop();
		assertTrue(isSorted(x2));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x2));
				
		Job[] x3 = jobArray(line3);
		clock.reset();
		clock.start();
		Insertion.sortBinary(x3, x3.length);
		clock.stop();
		assertTrue(isSorted(x3));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x3));
		
		
		Job[] x4 = jobArray(line4);
		clock.reset();
		clock.start();
		Insertion.sortBinary(x4, x4.length);
		clock.stop();
		assertTrue(isSorted(x4));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x4));
		
		Job[] x5 = jobArray(line5);
		clock.reset();
		clock.start();
		Insertion.sortBinary(x5, x5.length);
		clock.stop();
		assertTrue(isSorted(x5));
		time = clock.getNanoTime() * 1e-9;		
		System.out.println(", " + time);
		//System.out.println(Arrays.toString(x5));	
	}
	
	@Test
	/**
	 * This test will check to see the function, sortMerge
	 * is able to sort arrays 1 through 5 of the input file accurately
	 * It will also print out the timings it took for each sort
	 */	
	public void testMerge(){
		Job[] x1 = jobArray(line1);
		clock = new StopWatch();
		clock.reset();
		clock.start();
		Merge.sortMerge(x1, x1.length);
		clock.stop();
		assertTrue(isSorted(x1));
		time = clock.getNanoTime() * 1e-9;
		System.out.print("testSortMerge time[1-5]: " + time);
		//System.out.println(Arrays.toString(x1));
		
		Job[] x2 = jobArray(line2);
		clock.reset();
		clock.start();
		Merge.sortMerge(x2, x2.length);
		clock.stop();
		assertTrue(isSorted(x2));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x2));
				
		Job[] x3 = jobArray(line3);
		clock.reset();
		clock.start();
		Merge.sortMerge(x3, x3.length);
		clock.stop();
		assertTrue(isSorted(x3));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x3));
		
		
		Job[] x4 = jobArray(line4);
		clock.reset();
		clock.start();
		Merge.sortMerge(x4, x4.length);
		clock.stop();
		assertTrue(isSorted(x4));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x4));
		
		Job[] x5 = jobArray(line5);
		clock.reset();
		clock.start();
		Merge.sortMerge(x5, x5.length);
		clock.stop();
		assertTrue(isSorted(x5));
		time = clock.getNanoTime() * 1e-9;		
		System.out.println(", " + time);
		//System.out.println(Arrays.toString(x5));	
	}
	
	@Test
	/**
	 * This test will check to see the function, sortHeap 
	 * is able to sort arrays 1 through 5 of the input file accurately
	 * It will also print out the timings it took for each sort
	 */	
	public void testHeapSort(){
		clock = new StopWatch();

		Job[] x1 = jobArray(line1);
		clock.reset();
		clock.start();
		Heap.sortHeap(x1, x1.length);
		clock.stop();
		assertTrue(isSorted(x1));
		time = clock.getNanoTime() * 1e-9;
		System.out.print("testHeapSort time[1-5]: " + time);
		//System.out.println(Arrays.toString(x1));
		
		Job[] x2 = jobArray(line2);
		clock.reset();
		clock.start();
		Heap.sortHeap(x2, x2.length);
		clock.stop();
		assertTrue(isSorted(x2));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x2));
				
		Job[] x3 = jobArray(line3);
		clock.reset();
		clock.start();
		Heap.sortHeap(x3, x3.length);
		clock.stop();
		assertTrue(isSorted(x3));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x3));
		
		
		Job[] x4 = jobArray(line4);
		clock.reset();
		clock.start();
		Heap.sortHeap(x4, x4.length);
		clock.stop();
		assertTrue(isSorted(x4));
		time = clock.getNanoTime() * 1e-9;		
		System.out.print(", " + time);
		//System.out.println(Arrays.toString(x4));
		
		Job[] x5 = jobArray(line5);
		clock.reset();
		clock.start();
		Heap.sortHeap(x5, x5.length);
		clock.stop();
		assertTrue(isSorted(x5));
		time = clock.getNanoTime() * 1e-9;		
		System.out.println(", " + time);
		//System.out.println(Arrays.toString(x5));
		System.out.println();
		//System.out.println(x1.length + " " + x2.length + " " + x3.length +" "+ x4.length + " " + x5.length );
	}
}
