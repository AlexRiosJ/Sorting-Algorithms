package sorts;

public class HeapSort {

	public static void main(String[] args) {
		for(int i = 1000; i <= 4000; i++) {
			for(int j = 0; j < i/10; j++) 
				heapSort(randomArray(i));
			System.out.println(i + ", " + (movimientos/(i/10)) + ", " + i + ", " + (comparaciones/(i/10)));
			comparaciones = 0;
			movimientos   = 0;
		}
	}
	
	static int comparaciones = 0;
	static int movimientos   = 0;
	
	public static void heapSort(int[] array) {
		buildMaxHeap(array);
		for(int heapSize = array.length; heapSize > 1; heapSize--) {
			swap(array, 0, heapSize - 1);
			maxHeapify(array, 0, heapSize - 2);
		}
	}
	
	public static void buildMaxHeap(int[] array) {
		for(int root = (array.length/2) - 1; root >= 0; root--) {
			maxHeapify(array, root, array.length - 1);
		}
	}

	public static void maxHeapify(int[] array, int root, int heapSize) {
		int left  = 2 * root + 1;
		int right = left + 1;
		int max = root;
		if(left <= heapSize && greaterThan(array[left], array[max]))
			max = left;
		if(right <= heapSize && greaterThan(array[right], array[max]))
			max = right;
		if(max != root) {
			swap(array, max, root);
			maxHeapify(array, max, heapSize);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		movimientos += 3;
	}
	
	public static boolean greaterThan(int a, int b) {
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
