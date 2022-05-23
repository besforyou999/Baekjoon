import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 40;
        int dp[][] = new int[N+1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3 ; i <= N ; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }

    }
}
