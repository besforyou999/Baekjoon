import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int box[][];
	static int M, N;
	static Queue<int[]> queue;

	public static void main(String []args) {
		queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();

		box = new int[N+1][M+1];

		for ( int y = 1 ; y <= N ; y++ ) {
			for ( int x = 1; x <= M ; x++ ) {
				int temp = sc.nextInt();
				box[y][x] = temp;
				if ( temp == 1 ) queue.add(new int[] { x, y } );
			}
		}
		System.out.print(BFS());
		return ;
	}

	public static int BFS() {

		int []dx = { 1 , -1 , 0, 0 };
		int []dy = { 0,  0, 1, -1 };

		while(!queue.isEmpty()) {
		
			int [] point = queue.poll();
			int x = point[0];
			int y = point[1];

			for ( int i = 0; i < 4 ; i++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if ( nextX >= 1 && nextX <= M && nextY >= 1 && nextY <= N ) {
					if ( box[nextY][nextX] == 0 ) { 
						box[nextY][nextX] = box[y][x] + 1;
						queue.add(new int[] { nextX, nextY });
					}
				}
			}
		}

		int count = 0;

		for ( int y = 1 ; y <= N ; y++ ) {
			for ( int x = 1; x <= M ; x++ ) {
				if ( box[y][x] == 0 ) 
					return -1;

				if ( count < box[y][x] ) count = box[y][x];
			}
		}
	
		return count - 1;
	}
}
