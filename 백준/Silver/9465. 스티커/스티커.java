import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int arr [][] = new int[2][100001];
        int dp [][] = new int[2][100001];

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());

            for (int i = 0 ; i < 2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= n ; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2 ; j <= n ; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }

            int ans = Math.max(dp[0][n], dp[1][n]);
            System.out.println(ans);
        }

    }
}