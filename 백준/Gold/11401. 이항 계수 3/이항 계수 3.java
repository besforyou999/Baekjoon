import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int r = Integer.parseInt(line[1]);

		long[] fac = new long[n + 1];
		fac[1] = 1;
		for (int i = 2; i <= n; i++) {
			fac[i] = (fac[i - 1] * i) % MOD;
		}

		long bottom = (fac[r] * fac[n - r]) % MOD;
		bottom = pow(bottom, MOD - 2);
		
		if (r == 0 || n == r) {
			System.out.println(1);
			return;
		}
		System.out.println((fac[n] * bottom) % MOD);
	}

	private static long pow(long a, int b) {
		if (b == 0)
			return 1;

		else if (b == 1)
			return a;

		if (b % 2 == 0) {
			long tmp = pow(a, b / 2);
			return (tmp * tmp) % MOD;
		}

		long tmp = pow(a, b - 1) % MOD;
		return (tmp * a) % MOD;
	}
}