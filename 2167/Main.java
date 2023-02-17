import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int [][] mat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N + 1][M + 1];
        int [][]dp = new int[N + 1][M + 1];

        for (int i = 1 ; i < N + 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1 ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1 ; i < N + 1 ; i++) {
            for (int j = 1 ; j < M + 1 ; j++) {
                dp[i][j] = mat[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0 ; k < K ; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ans = dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i-1][j-1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}