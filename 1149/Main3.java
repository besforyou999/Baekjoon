import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int dp[][];
    static int rgb[][];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[3][n+1];
        rgb = new int[3][n+1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3 ; j++)
                rgb[j][i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0 ; j < 3 ; j++) dp[j][1] = rgb[j][1];

        for (int i = 2 ; i <= n ; i++) {
            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + rgb[0][i];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + rgb[1][i];
            dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + rgb[2][i];
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0 ; j < 3 ; j++)
            if (dp[j][n] < ans) ans = dp[j][n];

        System.out.print(ans);
    }
}
