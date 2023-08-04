import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int [][] dp = new int[T + 1][W + 1];

        for (int i = 1 ; i <= T ; i++) {

            int tree = Integer.parseInt(br.readLine());

            for (int j = 0 ; j <= W ; j++) {

                if (j == 0) {
                    if (tree == 1)
                        dp[i][j] = dp[i-1][j] + 1;

                    continue;
                }

                if (j % 2 == 0) {
                    if (tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                }
                else {
                    if (tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i <= W ; i++) {
            ans = Math.max(ans, dp[T][i]);
        }

        System.out.println(ans);
    }
}