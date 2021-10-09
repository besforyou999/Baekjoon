import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N,M;
	static int mat[][];
	static boolean visited[][];	

	public static void main (String []args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		mat = new int[N][M];
		visited = new boolean[N][M];

		String inputstr = new String();

		for ( int i = 0; i < N ; i++ ) {
			inputstr = sc.next();
			for ( int j = 0 ; j < M ; j++ ) 
				mat[i][j] = inputstr.charAt(j) - '0';
		}

		BFS(0,0);
		
		System.out.print(mat[N-1][M-1]);

	}		

	public static void BFS(int x, int y) {

		int dx[] = { 0 , 1, -1, 0 };
		int dy[] = { 1 , 0, 0, -1 };

		Queue<int[]> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new int[] {x,y});

		while ( !queue.isEmpty() ) {
			int [] temp = queue.poll();
			int newX = temp[0];
			int newY = temp[1];
			for ( int i = 0 ; i < 4 ; i++ ) {
				int nextX = newX + dx[i];
				int nextY = newY + dy[i];
				if ( nextX >=0 && nextX < N	&& nextY >= 0 && nextY < M && mat[nextX][nextY] == 1 && visited[nextX][nextY] == false ) {
					mat[nextX][nextY] = mat[newX][newY] + 1;
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY});
				}
			}
		}
	}
}






