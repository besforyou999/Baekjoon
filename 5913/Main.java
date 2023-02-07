import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main3 {
	public static int K, apple_cnt = 25, ans = 0;
	public static int mat[][] = new int[6][6];
	public static boolean visit[][] = new boolean[6][6];
	
	public static int []dx = {-1, 1, 0, 0};
	public static int []dy = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		apple_cnt -= K;
		for (int r = 1 ; r <= 5 ; r++) 
			for (int c = 1 ; c <= 5 ; c++) 
				mat[r][c] = 1;
		
		for (int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mat[r][c] = 0;
			
		}
		
		visit[1][1] = true;
		rec(1, 1, 1);
		System.out.println(ans);
	}
	
	public static void rec(int r1, int c1, int cnt) {
		if (apple_cnt == cnt) {
			if (r1 == 5 && c1 == 5) {
				ans += 1;
			}
			return;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			int nr1 = r1 + dy[i];
			int nc1 = c1 + dx[i];
			if (isIn(nr1, nc1) && !visit[nr1][nc1] ) {
				if (mat[nr1][nc1] == 1 ) {
					visit[nr1][nc1] =  true;
					rec(nr1, nc1, cnt + 1);
					visit[nr1][nc1] = false;
				}
			}
		}
	}
	
	
	public static boolean isIn(int r, int c) {
		return (r >= 1 && r <= 5 && c >= 1 && c <= 5);
	}
}