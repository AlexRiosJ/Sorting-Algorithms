package sorts;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		for(int i = 1000; i <= 4000; i++) {
			for(int j = 0; j < i/10; j++) 
				shellSort(randomArray(i));
			System.out.println(i + ", " + (movimientos/(i/10)) + ", " + i + ", " + (comparaciones/(i/10)));
			comparaciones = 0;
			movimientos   = 0;
		}
	}
	
	public static void main1(String[] args) {
		int[] array = randomArray(20);
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static int comparaciones = 0;
	static int movimientos   = 0;

	
	public static void shellSort(int[] array) {
		int delta = 1;
		int pivot = 0;
		int i = 0;
		
		while(delta <= array.length / 3) {
			delta = delta * 3 + 1;
		}
				
		while(delta > 0) {
			for(int p = delta; p < array.length; p++) {
				pivot = array[p];
				i = p - delta;
				while(i >= 0 && graterThan(array[i], pivot)) {
					array[i + delta] = array[i];
					i = i - delta;
					movimientos ++;
				}
				array[i + delta] = pivot;
			}
			delta = (delta - 1) / 3;
		}
	}
	
	public static boolean graterThan(int a, int b) {
		comparaciones ++;
		return a > b;
	}
	
	public static int[] randomArray(int n){
        int array[] = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = (int)(Math.random() * (n + 1));
        return array;
    }
}
