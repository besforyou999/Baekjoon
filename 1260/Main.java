import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	static boolean visited[];
	static int mat[][];	

	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();
	
		visited = new boolean[N+1];
		mat = new int[N+1][N+1];

		int p,q;

		for ( int i = 0 ; i < M ; i++ ) {
			p = sc.nextInt();
			q = sc.nextInt();
			mat[p][q] = mat[q][p] = 1;				
		}
		
		DFS(V);
		reset();
		BFS(V);
	}

	public static void reset() {
		for ( int i = 0 ; i <= N ; i++ ) {
			visited[i] = false;
		}
		System.out.println();
	}

	public static void DFS( int V ) {
	
		visited[V] = true;
		System.out.print(V + " ");	

		for ( int i = 1 ; i <= N ; i++ ) {
			if ( mat[V][i] == 1 && visited[i] == false) {
				DFS(i);	
			}
		}
	}

	public static void BFS( int V ) {
		
		Queue<Integer> queue = new LinkedList<>();
	
		queue.add(V);
	
		while ( !queue.isEmpty() ) {

			int node = queue.poll();
			visited[node] = true;
			System.out.print(node + " ");

			for ( int i = 1 ; i <= N ; i++ ) {
				if ( mat[node][i] == 1 && visited[i] == false ) {
					queue.add(i);
					visited[i] = true;
				}
			}

		}
	}
} 
