import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int N, M;
	static int mat[][];
	static boolean visited[];

	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();	
		mat = new int[N+1][N+1];
		visited = new boolean[N+1];
	
		for ( int i = 1 ; i <= M ; i++ )
		{
			int first , second;
			first = sc.nextInt();
			second = sc.nextInt();

			mat[first][second] = 1;
			mat[second][first] = 1;
		}
	
		System.out.print(BFS(1));	
		return ;
	}

	public static int BFS(int x) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		while ( !queue.isEmpty() ) {
			int Num = queue.poll();
			visited[Num] = true;
			for ( int i = 1; i <= N ; i++ ) {
				if ( mat[Num][i] == 1 && visited[i] == false ) {
					queue.add(i);
					visited[i] = true;
					count += 1;
				}
			}
		}
		return count;
	}
}
