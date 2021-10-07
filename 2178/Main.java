import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int [][] mat;
	static int n , m;
	static boolean [][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		mat = new int[n][m];

		String inputStr = new String();

		for ( int i = 0 ; i < n ; i++ ) {
			inputStr = sc.next();
			for ( int j = 0 ; j < m ; j++ ) {
				mat[i][j] = inputStr.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(mat[n-1][m-1]);
	}

	public static void bfs(int x,int y) {

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {x,y});

		while ( !queue.isEmpty() ) {
			int temp[] = queue.poll();
			int newX = temp[0];
			int newY = temp[1];

			for ( int i = 0; i < 4 ; i++ ) {
				int nextX = newX + dx[i];
				int nextY = newY + dy[i];

				if ( nextX < 0 || nextX >= n || nextY < 0 || nextY >= m )
					continue;
				if ( visited[nextX][nextY] || mat[nextX][nextY] == 0 )
					continue;

				queue.add(new int[] {nextX, nextY});
				mat[nextX][nextY] = mat[newX][newY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}
}
