package firstae;

public class InsertionSort {
	public static void sort(int[] array) {
    	int n = array.length;
    	for (int j=1; j < n; j++) {
    		int key = array[j];
    		int i = j-1;
    		while ((i>=0) && (array[i] > key)) {
    			array[i+1] = array[i];
    			i--;
    		}
    		array[i+1] = key;
    	}
    }
}
