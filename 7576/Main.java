import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int N,M;
	static int box[][];
	static Queue<int[]> queue;

	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); N = sc.nextInt();
	
		box = new int[N][M];
		queue = new LinkedList<>();

		int x = 0, y = 0;

		for ( int i = 0; i < N ; i++ ) {
			for ( int j = 0; j < M ; j++ ) {
				int temp = sc.nextInt();
				box[i][j] = temp;
				if ( temp == 1 ) {
					queue.add(new int[] {i,j});
				}
			}
		}

		System.out.print(BFS());

		return ;
	}

	public static int BFS() {
		
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		while ( !queue.isEmpty() ) {
			int [] temp = queue.poll();
			int newY = temp[0];
			int newX = temp[1];

			for ( int i = 0; i < 4 ; i++ ) {
				int nextX = newX + dx[i];
				int nextY = newY + dy[i];

				if ( nextX >= 0 && nextX < M && nextY >= 0 && nextY < N ) {
					if ( box[nextY][nextX] == 0 ) {
						box[nextY][nextX] = box[newY][newX] + 1;
						queue.add(new int[] { nextY, nextX });
					}
				}
			}				
		}

		int result = 0;		

		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0 ; j < M ; j++ ) {
				if ( box[i][j] == 0 ) 
					return -1;

				if ( result < box[i][j] ) result = box[i][j];
			}
		}

		return result - 1;
	}		
}
