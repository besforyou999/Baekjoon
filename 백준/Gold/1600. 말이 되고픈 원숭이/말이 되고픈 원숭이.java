import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H, ans;
    static int mat[][];

    static int dr [] = {-1, 1, 0, 0};

    static int dc [] = {0, 0, -1, 1};

    static int horse_r [] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int horse_c [] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        mat = new int[H][W];

        for (int r = 0 ; r < H ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < W ; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;

        bfs();

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void bfs() {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, K});

        boolean [][][] visit = new boolean[H][W][K + 1];
        visit[0][0][K] = true;

        while(!queue.isEmpty()) {

            int cod [] = queue.poll();

            int r = cod[0];
            int c = cod[1];
            int cnt = cod[2];
            int horse = cod[3];

            if (r == H - 1 && c == W - 1) {
                ans = Math.min(ans, cnt);
                break;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == 0 && !visit[nr][nc][horse]) {
                    visit[nr][nc][horse] = true;
                    queue.add(new int[] {nr, nc, cnt + 1, horse});
                }
            }

            if (horse > 0) {
                for (int i = 0 ; i < 8 ; i++) {
                    int nr = r + horse_r[i];
                    int nc = c + horse_c[i];
                    if (isIn(nr, nc) && mat[nr][nc] == 0 && !visit[nr][nc][horse - 1]) {
                        visit[nr][nc][horse - 1] = true;
                        queue.add(new int[]{nr, nc, cnt + 1, horse - 1});
                    }
                }
            }
        }

    }

    static boolean isIn(int r, int c) {
        return (0 <= r && r < H && 0 <= c && c < W);
    }
}