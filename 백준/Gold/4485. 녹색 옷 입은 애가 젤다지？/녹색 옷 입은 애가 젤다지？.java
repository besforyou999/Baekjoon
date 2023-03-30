import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int dr [] = {-1, 1, 0, 0};
    static int dc [] = {0, 0, -1, 1};
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problem = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int [][] mat = new int[N + 1][N + 1];
            for (int i = 1 ; i <= N ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= N ; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(problem++).append(":").append(" ").append(bfs(mat, N)).append("\n");
        }

        System.out.print(sb);
    }

    public static int bfs(int [][] mat, int N) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1});

        int [][] dp = new int[N + 1][N + 1];
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                dp[i][j] = 1000000000;
            }
        }

        dp[1][1] = mat[1][1];

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc, N)) {
                    if (dp[nr][nc] > dp[r][c] + mat[nr][nc]) {
                        dp[nr][nc] = dp[r][c] + mat[nr][nc];
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return dp[N][N];
    }

    public static boolean isIn(int r, int c, int N) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }
}