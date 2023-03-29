import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int dp [][] = new int[N + 1][10];

        for (int i = 0 ; i < 10 ; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2 ; i <= N ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                for (int k = j ; k <= 9 ; ++k) {
                    dp[i][k] += dp[i-1][j];
                    dp[i][k] %= DIV;
                }
            }
        }

        int ans = 0;

        for (int j = 0 ; j < 10 ; j++) {
            ans += dp[N][j];
        }

        System.out.println(ans % DIV);
    }
}