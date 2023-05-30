import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int DIV = 1_000_000_009;

        long [][] dp = new long[100_001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4 ; i <= 100_000 ; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % DIV;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % DIV;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % DIV;
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int q = Integer.parseInt(br.readLine());
            long ans = (dp[q][1] + dp[q][2] + dp[q][3]) % DIV;
            System.out.println(ans);
        }

    }
}