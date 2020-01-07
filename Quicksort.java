import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Random r = new Random();
		int[] arr = new int[10000];
		for(int i = 0; i< arr.length; i++)
			arr[i] = r.nextInt(100000);
		
		long beginTime = System.currentTimeMillis();
		quicksort(arr, 0, (arr.length-1));
		long endTime = System.currentTimeMillis();
		
		long ms = endTime - beginTime;
		float sec = (float) ms / 1000;
		float min = (float) sec / 60;
		if (min > 1) {
		    System.out.println("Quick수행시간: " + min + "(min)");
		    
		} else if (sec > 1) {
		    System.out.println("Quick수행시간: " + sec + "(sec)");
		    
		} else {
		    System.out.println("Quick수행시간: " + ms + "(ms)");
		}
	}
	
	public static void swap (int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void quicksort(int[] arr, int p, int r) {
		if(p < r) {
			int q = partition(arr, p, r);
			quicksort(arr, p, q - 1);
			quicksort(arr, q + 1, r);
		}
	}
	
	public static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		int i = (p - 1);
		for(int j = p; j < r; j++)
			if(arr[j] < pivot)
				swap(arr, ++i, j);
		swap(arr, i+1, r);
		return (i + 1);
	}
}
