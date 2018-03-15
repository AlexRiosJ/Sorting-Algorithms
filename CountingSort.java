package sorts;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int array[] = { 4, 2, 4, 2, 3, 2 };
		countingSort(array, 4);
		System.out.println(Arrays.toString(array));
	}

	public static void countingSort(int[] array, int k) {
		int[] freq = new int[k];
		for (int i = 0; i < array.length; i++)
			freq[array[i] - 1]++;
		
		int temp = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < freq[i]; j++) {
				array[temp] = i + 1;
				temp ++;
			}
		}

	}

}
