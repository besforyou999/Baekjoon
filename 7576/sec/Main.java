import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int N, M;
	static int box[][];
	static Queue<int[]> queue;

	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		box = new int[N+1][M+1];
		queue = new LinkedList<>();

		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0; j < M ; j++ ) {
				int temp = sc.nextInt();
				if ( temp == 1 ) {
					queue.add(new int[] { i , j } );
				}
				box[i][j] = temp;
			}
		}

		int ans = BFS();
		
		System.out.println(ans);
	}

	public static int BFS() {

		int []bx = { 1, -1, 0, 0 };
		int []by = { 0,  0, 1, -1};

		while ( !queue.isEmpty() ) {

			int [] point = queue.poll();
			int Y = point[0];
			int X = point[1];
			
			for ( int i = 0 ; i < 4 ; i++ ) {

				int newX = X + bx[i];
				int newY = Y + by[i];

				if ( newX >= 0 && newX < M && newY >= 0 && newY < N ) {
					if ( box[newY][newX] == 0 ) {
						box[newY][newX] = box[Y][X] + 1;
						queue.add(new int[] { newY , newX });
					}
				}
			}			
		}
				
		int result = 0;

		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0; j < M ; j++ ) {
				int temp = box[i][j];
				if ( temp == 0 )
					return -1;

				if ( temp > result)
					result = temp;
			}
		}	

		return result - 1;
	}
}
