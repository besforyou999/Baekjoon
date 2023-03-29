import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int dp[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n + 1];
		cal();
		System.out.println(dp[m] % 10007);
	}
	
	public static void cal() {
		dp[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			int keep[] = new int [n + 1];
			keep[0] = 1;
			for (int j = 1; j < i + 1; j++) {
				keep[j] = dp[j] % 10007 + dp[j - 1] % 10007;
			}
			dp = keep;
		}
	}
}
