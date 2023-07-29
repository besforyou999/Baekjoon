import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] mat;
    static boolean [][] visit;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int n = 1 ; n <= N ; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1 ; m <= M ; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCnt = 0;
        int widestPic = 0;

        for (int n = 1 ; n <= N ; n++) {
            for (int m = 1 ; m <= M ; m++) {
                if (!visit[n][m] && mat[n][m] == 1) {
                    pictureCnt += 1;
                    widestPic = Math.max(widestPic, bfs(n, m));
                }
            }
        }

        System.out.println(pictureCnt);
        System.out.println(widestPic);
    }

    public static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            int [] coord = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];

                if (isIn(nr, nc)) {
                    if (!visit[nr][nc] && mat[nr][nc] == 1) {
                        visit[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                        cnt += 1;
                    }
                }
            }
        }

        return cnt;
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }


}