import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= i ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + map[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j - 1] + map[i][j];
                } else {
                    dp[i][j] = map[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int max = -1;

        for (int j = 1 ; j <= N ; j++) {
            if (dp[N][j] > max) max = dp[N][j];
        }
        System.out.println(max);
    }
}