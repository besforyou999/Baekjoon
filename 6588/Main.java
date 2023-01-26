import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = 1000001;
	public static String end = "Goldbach's conjecture is wrong.";
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dp [] = new int[MAX + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2 ; i * i <= MAX ; i++) {
			if (dp[i] == 0) {
				for (int j = i * i ; j <= MAX ; j += i) {
					dp[j] = 1;
				}
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
	
			int lp = 3;
			int rp = n - 1;
			boolean found = false;
			
			for (int i = 2 ; i <= n / 2 ; i++) {
				if (dp[i] == 0 && dp[n - i] == 0) {
					System.out.println(n + " = " + i + " + " + (n - i));
					found = true;
					break;
				}
			}
			
			if(!found)
				System.out.println(end);
		}
		
	}
}