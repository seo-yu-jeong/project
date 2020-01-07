import java.util.Scanner;

public class Student20151002 {
	static long memo[] = new long [1000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long result;
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		result = handshaking(num);
		memo[0] = 0;
		System.out.print(result);
		scan.close();
	}
	public static long handshaking(int n) {
		long result = 0;
		if(n % 2 == 1) return memo[n] = 0;
		//if(n == 0) return memo[n] = 1;
		//if(n == 2) return memo[n] = 1;
		if(n>0) {
			memo[0] = 1;
		for(int i = 0; i < n; i += 2) {
			if(memo[i] == 0 )
				memo[i] = handshaking(i);
			if (memo[n-2-i] == 0)
				memo[n-2-i] = handshaking(n-2-i);
			result += memo[i] * memo[n-2-i];
		}
		if(n == 0)
			return 0;
			/*if (memo[i] > 0 && memo[n-2-i] > 0) {
				result += memo[i] * memo[n-2-i];
				System.out.print("배열값:"+result);
			}
			else {
				memo[i] = handshaking(i);
				memo[n-2-i] = handshaking(n-2-i);
				result += memo[i] * memo[n-2-i];
				System.out.print("재귀값:"+result);
			}*/
		}
		return result;
	}
}
