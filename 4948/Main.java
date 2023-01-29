import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = 247000;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dp [] = new int[MAX];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2 ; i * i < MAX ; i++) {
			if (dp[i] == 0) {
				for (int j = i * i ; j < MAX ; j += i) {
					dp[j] = 1;
				}
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int M = 2 * n;
			int cnt = 0;
			for (int i = n + 1 ; i <= M ; i++) {
				if (dp[i] == 0) {
					cnt += 1;
				}
			}
			
			System.out.println(cnt);
		}
	}
}