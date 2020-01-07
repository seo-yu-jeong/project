
public class MaxContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int max_sum_DC(int []A, int l, int r) {
		if(l == r) return A[l];
		int m = (l + r) / 2;
		int max = 0;
		
		int lv = max_sum_DC(A, l, m);
		int rv = max_sum_DC(A, m+1, r);
		
		max = lv > rv? lv:rv;
		
		int cv = 0;
		int local_max = A[m + 1];
		int local_sum = 0;
		for(int i = m+1; i <=r; i++) {
			local_sum += A[i];
			if( local_max < local_sum) local_max = local_sum;
		}
		cv += local_max;
		local_max = A[m];
		local_sum = 0;
		for(int i = m; i >= l; i--) {
			local_sum += A[i];
			if(local_max < local_sum) local_max = local_sum;
		}
		cv += local_max;
		max = max > cv ? max : cv;
		return max;
	}
}
