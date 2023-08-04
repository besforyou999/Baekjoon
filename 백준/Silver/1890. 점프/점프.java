import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [][] mat;
    static long [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mat = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for (int r = 1 ; r < N + 1 ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1 ; c < N + 1 ; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for (int r = 1 ; r < N + 1 ; r++) {
            for (int c = 1 ; c < N + 1 ; c++) {
                // 위 탐색
                int len = 1;
                for (int row = r - 1 ; row >= 1 ; row--) {
                    if (mat[row][c] == len) {
                        dp[r][c] += dp[row][c];
                    }
                    len++;
                }

                // 왼쪽 탐색
                len = 1;
                for (int col = c - 1 ; col >= 1 ; col--) {
                    if (mat[r][col] == len) {
                        dp[r][c] += dp[r][col];
                    }
                    len++;
                }
            }
        }

        System.out.println(dp[N][N]);
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }
}