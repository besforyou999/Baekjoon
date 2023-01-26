import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = 10000;
	public static int dp[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new int[MAX + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2 ; i * i <= MAX ; i++) {
			if (dp[i] == 0) {
				for (int j = i * i ; j <= MAX ; j += i) {
					dp[j] = 1;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < T ; i++) {
			int n = Integer.parseInt(br.readLine());
			gold(n);
		}
		
	}
	
	public static void gold(int n) {
		int diff = 10000000;
		int a = 0, b = n;
		for (int i = 2 ; i <= n / 2 ; i++) {
			if (dp[i] == 0 && dp[n - i] == 0) {
				if (Math.abs(n - i - i) < diff) {
					diff = Math.abs(n - i - i);
					a = i;
					b = n - i;
				}
			}
		}
		System.out.println(a + " " + b);
	}
}