package firstae;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestSortingAlgorithms {
	public static void main(String[] args) throws FileNotFoundException {
		String[] strArr = {"int1000","int20k","int500k","intBig","dutch"};
		for (String filename: strArr) {
			File file = new File("C:\\" + filename + ".txt");
			Scanner scan = new Scanner(file);
			ArrayList<Integer> intList = new ArrayList<Integer>();
			while (scan.hasNextLine()) {
				intList.add(Integer.parseInt(scan.nextLine()));
			}
			scan.close();
			
			// convert array list to array
			int[] newArr = intList.stream().mapToInt(i -> i).toArray();
			
			QuickSort s = new QuickSort();
			
			System.out.println("-------------------------------------------------------");
			System.out.println("Time taken to sort " + filename + ".txt:");
			System.out.println("");
			
			/** part 1 (a) */
			long timeBeforeSort=System.nanoTime();
			int[] testArr = Arrays.copyOf(newArr, newArr.length);
			s.sort(testArr, 0, testArr.length-1);
			long timeAfterSort=System.nanoTime();
			long timeQuickSort = timeAfterSort - timeBeforeSort;
			
			System.out.println("Standard QuickSort: " + timeQuickSort + " ns");
			System.out.println("");
			
			/** part 1 (b) - cutOffVal1 = 30 (i.e. k=30) */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			int cutOffVal1 = 30;
			s.sortUsingInsertionSort(testArr, 0, testArr.length-1, cutOffVal1);
			timeAfterSort=System.nanoTime();
			long timeQuickSortUsingInsertionSort1 = timeAfterSort - timeBeforeSort;
			
			System.out.println("QuickSort Using InsertionSort (cutoff value (k) = " + cutOffVal1 + ") : " + timeQuickSortUsingInsertionSort1 + " ns");
			System.out.println("");
			
			/** part 1 (b) - cutOffVal1 = 5 (i.e. k=5) */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			int cutOffVal2 = 5;
			s.sortUsingInsertionSort(testArr, 0, testArr.length-1, cutOffVal2);
			timeAfterSort=System.nanoTime();
			long timeQuickSortUsingInsertionSort2 = timeAfterSort - timeBeforeSort;
			
			System.out.println("QuickSort Using InsertionSort (cutoff value (k) = " + cutOffVal2 + ") : " + timeQuickSortUsingInsertionSort2 + " ns");
			System.out.println("");
			
			/** part 1 (c) */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			s.sortUsingMedianOfThree(testArr, 0, testArr.length-1);
			timeAfterSort=System.nanoTime();
			long timeQuickSortUsingMedianOf3 = timeAfterSort - timeBeforeSort;
			
			System.out.println("QuickSort Using Median-Of-Three Partitioning Scheme: " + timeQuickSortUsingMedianOf3 + " ns");
			System.out.println("");
			
			/** part 3 - pathological input array sorted via quick sort medianOf3 */ // later comment this part out from here....
			testArr = Arrays.copyOf(newArr, newArr.length);
			int[] pathologicalArr = s.generateInputArray(testArr.length);
			
			timeBeforeSort=System.nanoTime();
			s.sortUsingMedianOfThree(pathologicalArr, 0, pathologicalArr.length-1);
			timeAfterSort=System.nanoTime();
			long timeQuickSortM3Pathological = timeAfterSort - timeBeforeSort;
			
			System.out.println("QuickSort Using Median-Of-Three Partitioning Scheme, "
					+ "with Pathological Input Array: " + timeQuickSortM3Pathological + " ns");
			
			System.out.println(""); // to here... in order to see run times of 4 variations of quick sort without pathological input array.
			
			/** part 1 (d) */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			s.threeWaySort(testArr, 0, testArr.length-1);
			timeAfterSort=System.nanoTime();
			long time3WayQuickSort = timeAfterSort - timeBeforeSort;
			
			System.out.println("3-Way-QuickSort: " + time3WayQuickSort + " ns");
			System.out.println("");
			
			/** insertion sort */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			InsertionSort.sort(testArr);
			timeAfterSort=System.nanoTime();
			long timeInsertionSort = timeAfterSort - timeBeforeSort;
			
			System.out.println("Insertion Sort: " + timeInsertionSort + " ns");
			System.out.println("");
			
			/** merge sort */
			timeBeforeSort=System.nanoTime();
			testArr = Arrays.copyOf(newArr, newArr.length);
			MergeSort.sort(testArr, 0, testArr.length-1);
			timeAfterSort=System.nanoTime();
			long timeMergeSort = timeAfterSort - timeBeforeSort; 
			
			System.out.println("Merge Sort: " + timeMergeSort + " ns");
			System.out.println("");
		}	
	}
}