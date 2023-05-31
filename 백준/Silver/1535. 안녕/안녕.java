import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] Li = new int[N + 1];
        int [] Pi = new int[N + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int n = 1 ; n <= N ; n++) {
            Li[n] = Integer.parseInt(st1.nextToken());
            Pi[n] = Integer.parseInt(st2.nextToken());
        }

        int [][] dp = new int[N + 1][100];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= 99 ; j++) {
                if (Li[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-Li[i]] + Pi[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][99]);
    }
}