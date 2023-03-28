import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int wine[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wine = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1 ; i <= n ; i++)
            wine[i] = Integer.parseInt(br.readLine());

        dp[1] = wine[1];
        
        if (n == 1) {
            System.out.println(dp[n]);
            return;
        }
        
        dp[2] = dp[1] + wine[2];

        if (n <= 2) {
            System.out.println(dp[n]);
            return;
        }

        int ans = -1;

        for (int i = 3 ; i <= n ; i++) {
            int one = dp[i-2] + wine[i];
            int two = dp[i-3] + wine[i] + wine[i-1];
            int three = dp[i-1];
            dp[i] = Math.max(Math.max(one, two), three);
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}