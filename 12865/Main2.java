import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int weight[] = new int[N+1];
        int value[] = new int[N+1];
        int dp[][] = new int[N+1][K+1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= K ; j++) {
                if (j >= weight[i])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.print(dp[N][K]);
    }
}
