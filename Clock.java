import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Clock {
	public static int[] click = new int[10];//각switch별 누른 횟수
	public static int[] clock = new int[16];
	public static int mincount = 30;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] syncswitch = new int[10][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < syncswitch.length; i++) {
			int switchindex = Integer.parseInt(st.nextToken());
			int arraysize = Integer.parseInt(st.nextToken());
			syncswitch[switchindex] = new int[arraysize];
			for(int j = 0; j < arraysize; j++)
				syncswitch[switchindex][j] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
		}
		for(int i = 0; i < clock.length; i++)
			clock[i] = Integer.parseInt(st.nextToken());

		synchronizingClocks(syncswitch, 0);
		System.out.print(mincount);
	}

	public static void pressswitch(int[][] syncswitch) {
		int pressclock;

		//clock을 받아와서 변경할 clock배열
		int[] pressedclock = new int[16];
		for(int i = 0; i < clock.length; i++)
			pressedclock[i] = clock[i];

		//count만큼 스위치 누르기
		for(int i = 0; i < click.length; i++) { //click 배열의 길이만큼
			for(int j = 0; j < click[i]; j++) {//click 배열이 지정한 값만큼
				for(int k = 0; k < syncswitch[i].length; k++) { //switch에 연결된 clock 누름
					pressclock = syncswitch[i][k];
					pressedclock[pressclock] += 3;
					if(pressedclock[pressclock] > 12)
						pressedclock[pressclock] -= 12;
				}
			}
		} 

		//누른 시계 12시인지 점검하기
		for (int i = 0; i < pressedclock.length; i++) 
			if(pressedclock[i] != 12) {
				return;
			}
		int count = 0;
		for(int j = 0; j < click.length; j++) 
			count += click[j];
		if(mincount > count)
			mincount = count;
	}

	public static void synchronizingClocks(int[][] syncswitch, int index) {
		if(index == 10) {
			pressswitch(syncswitch);
			return;
		}
		/*if(count == 0) {
			for(int j = 0; j < click.length; j++) 
				count += click[j];
		}*/
		for(int i = 0; i < 4; i++) {
			click[index] = i;
			synchronizingClocks(syncswitch, index + 1);
		}
	}
}


