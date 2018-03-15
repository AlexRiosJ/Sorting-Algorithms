package sorts;

public class InsertionSort {

	public static void main(String[] args) {
		for(int i = 100; i <= 1000; i++) {
			for(int j = 0; j < i/10; j++) 
				insertionSort(randomArray(i));
			System.out.println(i + ", " + (movimientos/(i/10)) + ", " + i + ", " + (comparaciones/(i/10)));
			comparaciones = 0;
			movimientos   = 0;
		}
	}
	
	static int comparaciones = 0;
	static int movimientos   = 0;
	
	public static void insertionSort(int[] array) {
		int pivot = 0;
		int i = 0;
		for(int p = 1; p < array.length; p++) {
			pivot = array[p];
			i = p - 1;
			while(i >= 0 && graterThan(array[i], pivot)) {
				array[i + 1] = array[i];
				i = i - 1;
				movimientos ++;
			}
			array[i + 1] = pivot;
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
