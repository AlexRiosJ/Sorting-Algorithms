
package sorts;

public class BubbleSort {

	public static void main(String[] args) {
		for(int i = 100; i <= 1000; i++) {
			for(int j = 0; j < i/10; j++) 
				bubbleSort(randomArray(i));
			System.out.println((comparaciones/(i/10))); //+ ", " + i + ", " + (comparaciones/(i/10))
			comparaciones = 0;
			movimientos   = 0;
		}
	}

	static int comparaciones = 0;
	static int movimientos   = 0;
	
	public static void bubbleSort(int[] array) {
		boolean swap = false;
		for(int i = 1; i <= array.length; i++) {
			swap = false;
			for(int j = 0; j < array.length - i; j++) { // Sabemos que el mayor quedará hasta el final.
				if(graterThan(array[j], array[j + 1])) {
					swap(array, j, j + 1);
					swap = true;
				}
			}
			if(!swap) break;
		}
	}
	
	
	public static boolean graterThan(int a, int b) {
		comparaciones ++;
		return a > b;
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		movimientos += 3;
	}
	
//	private static int[] bestCaseArray(int n) {
//		int array[] = new int[n];
//        for(int i = 0; i < n; i++)
//            array[i] = i;
//        return array;
//	}
//	
//	private static int[] worstCaseArray(int n) {
//		int array[] = new int[n];
//        for(int i = 0; i < n; i++)
//            array[i] = n - i;
//        return array;
//	}
	
	public static int[] randomArray(int n){
        int array[] = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = (int)(Math.random() * (n + 1));
        return array;
    }

}
