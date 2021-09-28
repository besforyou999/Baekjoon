import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int MAX = 1001;
	static int N, M , V; // N : vertex count, M : edge count, V : vertex to start search
	static int mat[][] = new int[MAX][MAX];
	static int visit[] = new int[MAX];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		for ( int i = 0 ; i < M ; i++ ) {
			int first, second;
			first = sc.nextInt();
			second = sc.nextInt();
			mat[first][second] = mat[second][first] = 1;
		}

		dfs(V);
		System.out.println();
		bfs(V);	

		return ;
	}

	public static void dfs ( int V ) {
		System.out.print(V + ' ');
		visit[V] = 1;
		for ( int i = 1; i <= N ; i++ ) {
			if (visit[V] == 1 || mat[V][i] == 0 )
				continue;
			dfs(i);
		}		
	}

	public static void bfs ( int V ) { 
		q.add(V);
		visit[V] = 0;
		
		while ( q.isEmpty() == false ) {
			V = q.poll();
			System.out.print(q.peek() + " ");

			for ( int i = 1 ; i <= N ; i++) {
				if ( visit[i] == 0 || mat[V][i] == 0 )
					continue;
				q.add(i);
				visit[i] = 0;
			}
		}
		q.clear();
	}		

}
