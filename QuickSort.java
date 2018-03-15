package sorts;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		System.out.println("QUICK SORT");
		int[] array = randomArray(17);
		System.out.println("Original: " + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("Ordenado: " + Arrays.toString(array));
	}
	
	public static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int partitionIndex = partition(array, low, high);
			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}
	
	public static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = (low - 1);
		int temp = 0;
		
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i ++;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return (i + 1);
	}
	
	public static int[] randomArray(int n){
        int array[] = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = (int)(Math.random() * (1000 + 1));
        return array;
    }
	
}
