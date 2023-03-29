import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m;
	static int dp[][];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int [n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}
		recur(0,0);
		System.out.println(dp[0][0]);
	}

	public static int recur(int times, int got) {
		if (times == n) {
			if (got == m) {
				return 1;
			}
			return 0;
		}
		if (dp[times][got] != -1) {
			return dp[times][got];
		}
		dp[times][got] = recur(times + 1, got) + recur(times + 1, got + 1);
		return dp[times][got];
	}
}