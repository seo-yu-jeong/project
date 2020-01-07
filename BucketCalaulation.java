import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BucketCalaulation {
	public static int[] arr;
	public static int[] err;
	public static int nums;
	public static int bucketnums;
	public static int min = 90000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		nums = Integer.parseInt((st.nextToken()));
		bucketnums = Integer.parseInt(st.nextToken());
		arr = new int[nums];
		err = new int [bucketnums];
		for (int i = 0; i < nums; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.parallelSort(arr);
		int result = 0;
		for(int i = 0; i < bucketnums; i++)
			err[i] =  900000;
		result = calc(0, 0, bucketnums,err);
		System.out.println(result);
	}
	public static int calc(int start, int end, int k, int err[]) {
		if(k == 1) {
			start = end;
			//System.out.println("last start : " + start);
			end = nums;
			//System.out.println("last end : " + end);
			
			float sum = 0;
			float avg = 0;
			for(int j = start; j < end; j++)
				sum += arr[j];
			//System.out.println("last sum : " + sum);
			avg = Math.round(sum/(end-start));
			int sums= 0;
			for(int j = start; j < end; j++)
				sums += Math.pow(arr[j]-avg, 2);
			err[k-1] = sums;
			int result = 0;
			for(int j = 0; j < bucketnums; j++)
				result += err[j];
			//System.out.println("result : " + result);
			if(result < min)
				min = result;
			return min;
		}
		for(int s = 0; s < nums - bucketnums + 1; s++) {
			start = end;
			for(int i = 1; i < nums; i++) {
				//System.out.println(k + "번째 start : " + start);
				end = start + i;
				if(end >= nums)
					break;
				//System.out.println(k + "번째 end : " + end);
				float sum = 0;
				float avg = 0;
				for(int j = start; j < end; j++)
					sum += arr[j];
				//System.out.println(k + "번째 sum : " + sum);
				avg = Math.round(sum/(end-start));
				//System.out.println(k + "번째 avg : " + avg);
					int sums= 0;
				for(int j = start; j < end; j++) {
					//System.out.print(arr[j] + " ");
					sums += Math.pow(arr[j]-avg, 2);
				}
				err[k-1] = sums;				
				//System.out.println();
				//System.out.println(k + "번째 err : " + err[k-1]);
				calc(start, end, k-1, err);
			}
		}
		return min;
	}
}




