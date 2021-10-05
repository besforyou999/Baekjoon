import java.util.Scanner;
import java.util.queue;
import java.util.LinkedList;

public class Main {

	static final int MAX = 101;
	static int N, M;
	static int mat[][] = new int[MAX][MAX];
	static int path[][] = new int[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	
	public static void BFS (int y, int x) {
		
		path[y][x] = 1;
		visited[y][x] = true;

		queue.add(new Pair(y,x));

		while ( !queue.empty() ) {

			Pair temp = queue.poll();
			y = temp.y;
			x = temp.x;

			for ( int i = 0 ; i < 4 ; i++ ) {

				int ny = y + dy[i];
				int nx = x + dx[i];

				if ( ny < 0 || nx < 0 || ny >= N || nx >= M	) 
					continue;
				if ( mat[ny][nx] == 1 && visited[ny][nx] == false ) {
					visited[ny][nx] = true;
					queue.add(new Pair(ny,nx));
					path[ny][nx] = path[y][x] + 1;
				}
			}
		}
	}

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

		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(1, 1));
		visited[1][1] = true;


		



		System.out.print(mat[N-1][M-1]);

		return ;
	}
}

public class Pair {

	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


