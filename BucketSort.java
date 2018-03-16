package sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {

	public static void main(String[] args) {
		System.out.println("BUCKET SORT");
		double[] array = randomArray(17);
		System.out.println("Original: " + Arrays.toString(array));
		bucketSort(array, array.length);
		System.out.println("Ordenado: " + Arrays.toString(array));
	}
	
	public static void bucketSort(double[] array, int k){
		ArrayList<ArrayList<Double>> buckets = new ArrayList<>(k);
		
		for(int i = 0; i < k; i++)
			buckets.add(new ArrayList<Double>());

		for(int i = 0; i < array.length; i++) {
			int b = (int) (array[i]*array.length);
			buckets.get(b).add(array[i]);
		}
		
		int j = 0;
		for(int i = 0; i < k; i ++) {
			if(!buckets.get(i).isEmpty()) {
				insertionSort(buckets.get(i));
				while(!buckets.get(i).isEmpty()){
					array[j] = buckets.get(i).remove(0);
					j++;
				}
			}
		}		
	}
	
	public static void insertionSort(ArrayList<Double> array) {
		double pivot = 0;
		int i = 0;
		for(int p = 1; p < array.size(); p++) {
			pivot = array.get(p);
			i = p - 1;
			while(i >= 0 && array.get(i) > pivot) {
				array.set(i + 1, array.get(i));
				i --;
			}
			array.set(i + 1, pivot);
		}
	}
	
	public static double[] randomArray(int n){
		double array[] = new double[n];
        for(int i = 0; i < n; i++)
            array[i] = ((int)(Math.random() * (1000)))/1000.0;
        return array;
    }
	
}
 
