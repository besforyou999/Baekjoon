import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int [][] mat, dp;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        mat = new int[M + 1][N + 1];

        for (int m = 1 ; m < M + 1 ; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 1 ; n < N + 1 ; n++) {
                mat[m][n] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp = new int[M + 1][N + 1];
        
        for (int i = 1 ; i <= M ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));

    }

    static int dfs (int r, int c) {
        if (r == M && c == N) {
            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        
        dp[r][c] = 0;
        
        for (int i = 0 ; i < 4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc)) {
                if (mat[r][c] > mat[nr][nc]) {
                    dp[r][c] += dfs(nr, nc);
                }
            }
        }
        
        return dp[r][c];
    }

    static boolean isIn (int r, int c) {
        return (r >= 1 && r <= M && c >= 1 && c <= N);
    }
}