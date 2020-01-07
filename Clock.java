import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Clock {
	public static int[] click = new int[10];//��switch�� ���� Ƚ��
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

		//clock�� �޾ƿͼ� ������ clock�迭
		int[] pressedclock = new int[16];
		for(int i = 0; i < clock.length; i++)
			pressedclock[i] = clock[i];

		//count��ŭ ����ġ ������
		for(int i = 0; i < click.length; i++) { //click �迭�� ���̸�ŭ
			for(int j = 0; j < click[i]; j++) {//click �迭�� ������ ����ŭ
				for(int k = 0; k < syncswitch[i].length; k++) { //switch�� ����� clock ����
					pressclock = syncswitch[i][k];
					pressedclock[pressclock] += 3;
					if(pressedclock[pressclock] > 12)
						pressedclock[pressclock] -= 12;
				}
			}
		} 

		//���� �ð� 12������ �����ϱ�
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


