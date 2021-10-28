import java.util.Scanner;

public class Main {

	static int N,M;
	static int graph[][];
	static boolean visited[]

	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new int[N+1][N+1];
		visited = new boolean[N+1]

		int one, two;
		for ( int i = 0 ; i < M ; i++ ) {
			one = sc.nextInt();
			two = sc.nextInt();

			graph[one][two] = graph[two][one] = 1;
		}

		int count = 0;

		for ( int i = 1 ; i <= N ; i++ ) {
			if ( visited[i] == false ) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);	

		return ;
	}

	public static void dfs(int k) {
		if ( visited[k] == true )
			return;

		visited[k] = true;

		for ( int i = 1 ; i <= N ; i++ ) {
			if ( graph[k][i] == 1 ) {
				dfs(i);
			}
		}
	}
}
