import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class Main {

	static int mat[][];
	static boolean visited[][];
	static List<int> groupList;
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		int N;	
		N = sc.nextInt();

		mat = new int[N][N];
		visited = new boolean[N][N];
		groupList = new ArrayList<int>();

		String str = new String();

		for ( int i = 0 ; i < N ; i++ ) {
			str = sc.next();
			for ( int j = 0; j < N ; j++ ) {
			   mat[i][j] = str.charAt(j);
			}
		}

	}
	
	public static void BFS(int x, int y) {

		Queue<int[]> 
	


	}	
}
