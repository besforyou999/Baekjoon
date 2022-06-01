import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long dp[] = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        if (n <= 4) {
            System.out.print(dp[n]);
            return;
        }

        for (int i = 5 ; i <= n ; i++) dp[i] = dp[i-1] + dp[i-2];

        System.out.print(dp[n]);
    }
}

