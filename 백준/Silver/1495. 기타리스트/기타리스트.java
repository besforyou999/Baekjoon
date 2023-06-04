import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int []V = new int[N + 1];
        for (int n = 1 ; n <= N ; n++) {
            V[n] = Integer.parseInt(st.nextToken());
        }

        int [][] dp = new int[N + 1][M + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][S] = 1;

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j <= M ; j++) {
                if (dp[i - 1][j] != -1) {
                    int val = V[i];
                    if (j + val < M + 1) {
                        dp[i][j + val] = 1;
                    }
                    if (j - val >= 0) {
                        dp[i][j - val] = 1;
                    }
                }
            }
        }



        int ans = -1;

        for (int j = 0 ; j <= M ; j++) {
            if (dp[N][j] != -1) {
                ans = j;
            }
        }

        System.out.println(ans);
    }
}