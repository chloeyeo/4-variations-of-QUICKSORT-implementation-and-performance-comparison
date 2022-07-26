package firstae;

public class QuickSort {
	/*
	 * initial call is QUICKSORT(A,0,n-1) array A and two indexes p,r for A such
	 * that p <= r. Output is sorted array A[p..r].
	 */
	// part 1 (a)
	public void sort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			sort(A, p, q - 1);
			sort(A, q + 1, r);
		}
	}

	// part 1 (a)
	public int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (A[j] <= x) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// part 1 (b)
	boolean isSorted = false;
	public void sortUsingInsertionSort(int[] A, int p, int r, int k) {
		if ((r - p) > k && p < r && !(isSorted)) {
            int q = partition(A, p, r);
            sortUsingInsertionSort(A, p, (q - 1), k);
            sortUsingInsertionSort(A, (q + 1), r, k);
        } else if (!(isSorted)) {
        	InsertionSort.sort(A);
            isSorted = true;
        }
		/*while (p < r) {
			
			  Check if array size on which we will be working is less than k. k is the
			  cutoff value. if partition length <= cutoff (i.e. k), then we will insertion
			 * sort the array. (I.e. until partition length is > k, we'll use recursion to
			 * do quick sort, otherwise we'll stop quick sort and insertion sort the array
			 * instead.)
			 
			if (r - p < k) {
				InsertionSort.sort(A);
				break;
			} else {
				// q is the pivot
				int q = partition(A, p, r);

				// We'll do a recursion on small size sub array so we can check pivot - low
				// and pivot - high
				if (q - p < q - r) {
					sortUsingInsertionSort(A, p, q - 1, k);
					p = q + 1;
				} else {
					sortUsingInsertionSort(A, q + 1, r, k);
					r = q - 1;
				}
			}
		}*/
	}

	/** quick sort using median-of-three partitioning scheme */
	// p = left, r = right
	// part 1 (c)
	public void sortUsingMedianOfThree(int[] A, int p, int r) {
		if (p < r) {
			int q = medianOfThreePartition(A, p, r); //p=low, r=high
			sort(A, p, q - 1);
			sort(A, q + 1, r);
		}
	}

	// part 1 (c)
	public int medianOfThreePartition(int[] A, int low, int high) {
		int mid = (low+high)/2;
		if (A[mid] < A[low]) {
			swap(A,low,mid);
		}
		if (A[high] < A[low]) {
			swap(A,low,high);
		}
		if (A[mid] < A[high]) {
			swap(A,mid+1,high);
		}
		int pivot = A[high];
		int i = low-1;
		for (int j=low; j < high; j++) {
			if (A[j] <= pivot) { 
				i++;
				swap(A,i,j);
			}
		}
		swap(A,i+1,high);
		return i+1;
	}

	// part 1 (d)
	public void threeWaySort(int[] A, int low, int high) {
		/**
		 * Partitions array A into three parts: A[p...i] contains all elements smaller
		 * than pivot; A[i+1...j-1] contains all elements equal to pivot; A[j...r]
		 * contains all elements greater than pivot. low = index at start of array, high
		 * = index at end of array.
		 */
		/*if (low >= high) {
			return A;
		}*/
		
		if (low < high) {

			// choose the middle element as pivot.
			int mid = low + (high - low) / 2;
			int pivot = A[mid];
	
			// move the pivot to the front of the array.
			swap(A, low, mid);
	
			// lessThan = index of the next element in the array that is < pivot
			// largerThan = index of the next element in the array that is > pivot
			int lessThan = low;
			int largerThan = high;
			int i = low + 1;
	
			while (i <= largerThan) {
				// move elements smaller than pivot to the front of the array.
				if (A[i] < pivot) {
					swap(A, i++, lessThan++);
				} else if (A[i] > pivot) {
					swap(A, i, largerThan--);
				} else {
					i++;
				}
			}
	
			threeWaySort(A, low, lessThan - 1);
			threeWaySort(A, largerThan + 1, high);
		}
	}

	public int[] generateInputArray(int n) {
		/**
		 * Generate a pathological input array (i.e. worst case running time) for the
		 * quick sort algorithm that uses median of three partitioning scheme.
		 */
		// n is the length of the input array that is to be generated
		// if n is odd, set the last element to n-1, and proceed
	    // with n decremented by 1
		int[] array = new int[n];
	    if (n % 2 != 0) {
	        array[n-1] = n;
	        --n;
	    }
	    int m = n/2;
	    for (int i = 0; i < m; ++i) {
	        // first half of array (even indices)
	        if (i % 2 == 0) {
	        	array[i] = i + 1;
	        } else {
	        	// first half of array (odd indices)
	        	if (m % 2 != 0) {
	        		array[i] = m + i + 1;
	        	} else {
	        		array[i] = m + i + 0;
	        	}
	        	
	        }
	        // second half of array
	        array[m + i] = (i+1) * 2;
	    }
	    return array;
	}
}
