import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static int dp[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1];
		ArrayList<Integer> arr = new ArrayList<>();
		
		int cnt = 0;
		for (int i = 2 ; i <= N ; i++) {
			if (dp[i] == 0) {
				dp[i] = 1;
				arr.add(i);
				for (int j = i * i ; j <= N ; j += i) {
					if (dp[j] == 0) {
						dp[j] = 1;
						arr.add(j);
					}
				}
			}
		}
		/*
		System.out.println("-------`-`-`-`-`-`-`-`-`-`-`-`--`-`");
		for (int a : arr) {
			System.out.println(a);
		}
		*/
		System.out.println(arr.get(K - 1));
		
	}
}