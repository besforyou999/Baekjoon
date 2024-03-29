package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int mat[][];
	public static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		mat = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <= N ; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 1 ; r <= N ; r++) {
			for (int c = 1 ; c <= N ; c++) {
				dp[r][c] = mat[r][c] + dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}