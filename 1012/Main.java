import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int M, N, K;
	static int [][]worm;
	static boolean [][] visited;

	static int [] dr = { -1, 1, 0, 0 };
	static int [] dc = { 0, 0, -1, 1 };

	public static void main(String []args) {

		int T;
		T = sc.nextInt();

		while( T-- > 0 ) {
			System.out.print(solve());
		}		

		return ;
	}

	public static int solve() {
		
		M = sc.nextInt();
	    N = sc.nextInt(); 
		K = sc.nextInt();
		worm = new int[N][M];
		visited = new boolean[N][M];
		
		int x, y;
		
		for ( int i = 0; i < K ; i++ ) {
			x = sc.nextInt(); y = sc.nextInt();
			worm[y][x] = 1;
		}
			
		return counter();				
	}

	public static int counter() {
		int count = 0;
		for ( int y = 0 ; y < N ; y++ ) {
			for ( int x = 0 ; x < M ; x++ ) {
				if ( worm[y][x] == 1 && visited[y][x] == false) {
					if(dfs(x,y)) count++;
				}			
			}
		}

		return count;		
	}

	public static boolean dfs(int x, int y) {

		if ( visited[y][x]) return false;

		visited[y][x] = true;

		for ( int i = 0 ; i < 4 ; i++ ) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if ( nr >= 0 && nc >= 0 && nr < M && nc < N ) {
				if ( worm[nc][nr] == 1 && !visited[nc][nr] ) {
					dfs( nr, nc);
				}
			}
		}
		return true;
	}


}
