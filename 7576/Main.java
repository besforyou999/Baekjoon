import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int N,M;
	static int box[][];
	static boolean visited[][];

	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); N = sc.nextInt();
	
		box = new int[N][M];
		visited = new boolean[N][M];	

		int counter = 0;
		int x,y;

		for ( int i = 0; i < N ; i++ ) {
			for ( int j = 0; j < M ; j++ )
				box[i][j] = sc.nextInt();
				if ( box[i][j] == 1 ) {
					x = i;
					y = j;
				   	counter += 1;
				}
		}

		if ( counter == N * M ) {
			System.out.print(0);
			return;
		}

		cout << BFS(x,y);

		return ;
	}

	public static int BFS(int x,int y)
	{	
		int day = 1;
		int count = 1;
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {x,y});

		visited[x][y] = true;	

		while ( !queue.isEmpty() )
		{
			int [] temp = queue.poll();
			int newX = temp[0];
			int newY = temp[1];

			for ( int i = 0; i < 4 ; i++ )
			{
				int nextX = newX + dx[i];
				int nextY = newY + dy[i];

				if ( nextX >= 0 && nextX < M && nextY >= 0 && nextY < N )
				{
					if ( box[nextX][nextY] != -1 && visited[nextX][nextY] == false )
					{
						queue.add(new int[] {nextX,nextY});
						visited[nextX][nextY] = true;
						count += 1;	
					}
				}
			}				
		
			day += 1;

		}
	}		
}
