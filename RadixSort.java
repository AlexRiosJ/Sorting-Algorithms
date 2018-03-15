package sorts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		System.out.println("RADIX SORT");
		double[] array = randomArray(17);
		System.out.println("Original: " + Arrays.toString(array));
		radixSort(array);
		System.out.println("Ordenado: " + Arrays.toString(array));
	}
	
	public static void radixSort(double[] array){
		ArrayList<ArrayDeque<Double>> queuesArray = new ArrayList<>();
		
		// Crear las 4 colas
		for(int i = 0; i < 4; i++) {
			ArrayDeque<Double> queue = new ArrayDeque<Double>();
			queuesArray.add(queue);
		}
		
		int radix = 1000; // Tres dígitos después del punto.
		do {
			for(int i = 0; i < array.length; i++) 
				queuesArray.get((int) (array[i]*radix)%10).offer(array[i]);
			
			for(int i = 0; i < 10; i++)
				queuesArray.get(i).offer(1.0);
			
			int j = 0;
			for(int i = 0; i < 10; i++) {
				while(queuesArray.get(i).peek() != 1) {
					array[j] = queuesArray.get(i).poll();
					j++;
				}
				queuesArray.get(i).poll();
			}
			
			radix /= 10;
		} while (radix != 1);
	}
	
	public static double[] randomArray(int n){
		double array[] = new double[n];
        for(int i = 0; i < n; i++)
            array[i] = ((int)(Math.random() * (1000)))/1000.0;
        return array;
    }


}