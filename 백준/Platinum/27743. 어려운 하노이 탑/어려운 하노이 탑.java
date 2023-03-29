import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long t = (long) (Math.pow(10, 9) + 7);
		long ans = pow(2, n, t) - 1;
		ans = pow(ans, m, t);
		System.out.println(ans);
	}

	static long pow(long a, long b, long mod) {
		long ans = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				ans = (ans * a) % mod;
			}
			a = (a * a) % mod;
			b >>= 1;
		}
		return ans % mod;
	}

}
