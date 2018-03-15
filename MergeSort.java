package sorts;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println("MERGE SORT");
		int[] array = randomArray(17);
		System.out.println("Original: " + Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println("Ordenado: " + Arrays.toString(array));
	}

	public static void merge(int[] array, int start, int endL, int endR) {
		int[] temp = new int[(endR - start) + 1];
		int i = start;
		int j = endL + 1;
		for (int k = 0; k < temp.length; k++) {
			if (j > endR) {
				temp[k] = array[i];
				i++;
			} else if(i > endL){
				temp[k] = array[j];
				j++;
			} else if (i <= endL && j <= endR) {
				if(array[i] <= array[j]) {
					temp[k] = array[i];
					i ++;
				} else {
					temp[k] = array[j];
					j ++;
				}
			}
		}
		System.arraycopy(temp, 0, array, start, temp.length);
	}

	public static void mergeSort(int[] array, int l, int r) {
		if(l < r) {
			int half = (l + r) / 2;
			mergeSort(array, l, half);
			mergeSort(array, half + 1, r);
			merge(array, l, half, r);
		}
	}
	
	public static int[] randomArray(int n){
        int array[] = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = (int)(Math.random() * (1000 + 1));
        return array;
    }

}
