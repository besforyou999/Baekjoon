import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static final int MAX = 101;
	static int N, M;
	static int mat[][] = new int[MAX][MAX];
	static int path[][] = new int[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	static int [] dx = { -1, 1, 0, 0 };
	static int [] dy = { 0 , 0, -1, 0};

	public static void main ( String []args ) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		String str = new String();

		for ( int i = 0 ; i < N ; i++ ) {
			str = sc.next();
			for ( int j = 0; j < M ; j++ ) 
				mat[i][j] = str.charAt(j) - '0';
		}

		int [] dx = { 1, 0 , -1 , 0 };
		int [] dy = { 0 , 1 , 0 , -1 };

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]));
		visited[1][1] = true;

		while ( !queue.empty() ) {

			Pair temp = q.poll();
			int x = temp.x;
			int y = temp.y;

			visited[x][y] = true;

			for ( int i = 0 ; i < 4 ; i++ ) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if ( 0 <= newX && newX < M && 0 <= newY && newY < N && visited[newX][newY] == false && mat[newX][newY] == 1 ) {
					queue.add(new Pair(newX,newY));
					visited[newX][newY] = true;
					mat[newX][newY] = mat[x][y] + 1;
				}
			}
		}

		System.out.print(mat[N-1][M-1]);

		return ;
	}


}
