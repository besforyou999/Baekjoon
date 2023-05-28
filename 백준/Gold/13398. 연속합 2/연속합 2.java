import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [][] dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N ; n++)
            arr[n] = Integer.parseInt(st.nextToken());

        dp[0][0] = dp[0][1] = arr[0];

        int ans = arr[0];

        for (int n = 1 ; n < N ; n++) {
            dp[n][0] = Math.max(dp[n - 1][0] + arr[n], arr[n]);

            dp[n][1] = Math.max(dp[n - 1][0], dp[n - 1][1] + arr[n]);

            ans = Math.max(ans, Math.max(dp[n][0], dp[n][1]));
        }

        System.out.println(ans);
    }
}