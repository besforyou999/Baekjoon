import java.util.Collections;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Main {

	static int mat[][];
	static boolean visited[][];
	static List<Integer> groupList;
	static int N;

	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		mat = new int[N][N];
		visited = new boolean[N][N];
		groupList = new ArrayList<Integer>();

		String str = new String();

		for ( int i = 0 ; i < N ; i++ ) {
			str = sc.next();
			for ( int j = 0; j < N ; j++ ) {
			   mat[i][j] = str.charAt(j) -'0';
			}
		}
	
		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0 ; j < N ; j++ ) {
				if ( mat[i][j] == 0 || visited[i][j] == true) {
					continue;
				}
				else if ( mat[i][j] == 1 && visited[i][j] == false ) {
					BFS(i,j);
				}	
			}
		}

		System.out.println(groupList.size());
		Collections.sort(groupList);

		for ( int i = 0; i < groupList.size() ; i++ ) {
			System.out.println(groupList.get(i));
		}
		

	}
	
	public static void BFS(int x, int y) {
		
		int counter = 1;

		int dx[] = { 1, -1, 0, 0};
		int dy[] = { 0, 0, 1, -1};

		Queue<int[]> queue = new LinkedList<>();

		queue.add( new int[] { x, y } );
		
		visited[x][y] = true;	
			
		while ( !queue.isEmpty() ) {

			int[] pos = queue.poll();
			int newX = pos[0];
			int newY = pos[1];

			for ( int i = 0; i < 4 ; i++ ) {

				int nextX = newX + dx[i];
				int nextY = newY + dy[i];

				if ( nextX >= 0 && nextX < N && nextY >= 0 && nextY < N ) {
					if ( visited[nextX][nextY] == false && mat[nextX][nextY] == 1) {
						counter += 1;
						visited[nextX][nextY] = true;
						queue.add(new int[] {nextX,nextY});
					}					
				}
			}	
		}					
		groupList.add(counter);
	}	
}
