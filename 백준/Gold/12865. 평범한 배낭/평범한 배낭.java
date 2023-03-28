import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int W[], V[], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            W[i] = a;
            V[i] = b;
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= K ; j++) {
                if (j >= W[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}