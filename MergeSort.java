package firstae;

public class MergeSort {
	public static void merge(int[] A, int p, int q, int r) {
		/* sizes of the two sub arrays to be merged. */
		int n = q - p + 1;
		int m = r - q;

		/* create temporary arrays. */
		int L[] = new int[n];
		int R[] = new int[m];

		/* copy data to temporary arrays. */
		for (int i = 0; i < n; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < m; j++) {
			R[j] = A[q + 1 + j];
		}

		/* merge the temporary arrays. */
		// Initial indexes of the first and second sub arrays.
		int i = 0, j = 0;

		// Initial index of the merged array.
		int k = p;
		while (i < n && j < m) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}

		/* copy the remaining elements of sub array L if any. */
		while (i < n) {
			A[k] = L[i];
			i++;
			k++;
		}
		
		/* copy the remaining elements of sub array R if any. */
		while (j < m) {
			A[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void sort(int[] A, int p, int r) {
		if (p < r) {
			// find the middle point = q
			int q = (p+r)/2;
			
			// sort the first and second halves of the array A.
			sort(A, p, q);
			sort(A, q+1, r);
			
			// merge the sorted sub arrays.
			merge(A, p, q, r);
		}
	}
}
