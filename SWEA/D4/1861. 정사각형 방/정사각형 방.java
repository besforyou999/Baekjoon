import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int dr [] = {-1, 1, 0, 0};
    static int dc [] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testcase = 1 ; testcase <= T ; testcase++) {
            N = Integer.parseInt(br.readLine());
            int mat[][] = new int[N][N];

            for (int r = 0 ;r < N ; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0 ; c < N ; c++) {
                    mat[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int max = -1;
            int val = mat[0][0];


            for (int r = 0 ; r < N ; r++) {
                for (int c = 0 ; c < N ; c++) {
                    int result = bfs(mat, r, c);
                    if (result > max) {
                        max = result;
                        val = mat[r][c];
                    } else if (result == max) {
                        val = Math.min(val, mat[r][c]);
                    }
                }
            }

            sb.append("#").append(testcase).append(" ").append(val).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int [][] mat, int r, int c) {
        boolean [][] visit = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c, 1});
        visit[r][c] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int [] coord = queue.poll();
            r = coord[0];
            c = coord[1];
            int cnt = coord[2];
            ans = Math.max(ans, cnt);
            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && !visit[nr][nc]) {
                    if (mat[r][c] + 1 == mat[nr][nc]) {
                        visit[nr][nc] = true;
                        queue.add(new int[] {nr, nc, cnt + 1});
                    }
                }
            }
        }
        return ans;
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }

}