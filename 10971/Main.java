import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int mat[][];
	public static int arr[];
	public static boolean visit[];
	public static int MIN = 10000000;
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		arr = new int[N];
		visit = new boolean[N];
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N ; j++) 
				mat[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0 ; i < N ; i++) {
			Arrays.fill(visit, false);
			visit[i] = true;
			dfs(i, i, 0);
		}
		
		System.out.println(MIN);
	}
	
	public static void dfs(int start, int at, int cost) {
		if (allVisit()) {
			int last = mat[at][start];
			if (last == 0) return;
			MIN = Math.min(MIN, cost + last);
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if(!visit[i] && mat[at][i] != 0) {
				visit[i] = true;
				dfs(start, i, cost + mat[at][i]);
				visit[i] = false;
			}
		}
	}
	
	public static boolean allVisit( ) {
		for (int i = 0 ; i < N ; i++) {
			if (visit[i] == false) return false;
		}
		return true;
	}
	
	
	
}
