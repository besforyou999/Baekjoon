import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(N - 1);
            return;
        }

        int dp [] = new int[N + 1];
        for (int i = 2 ; i <= N ; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);

            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }

        System.out.println(dp[N]);
    }
}