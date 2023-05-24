import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] mat, air;
    static int []dr = {-1, 1, 0 , 0};
    static int []dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][M];
        air = new int[N][M];

        for (int n = 0 ; n < N ; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0 ; m < M ; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            // 공기와 닫는 칸 모두 기록
            recAir();

            // 완탐하면서 치즈칸 만나면? 지워지는지 판단.

            int cheese = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (mat[n][m] == 1) {
                        cheese += 1;

                        int cnt = 0;

                        if (n - 1 >= 0 && air[n - 1][m] == 1) {
                            cnt += 1;
                        }

                        if (n + 1 < N && air[n + 1][m] == 1) {
                            cnt += 1;
                        }

                        if (m - 1 >= 0 && air[n][m - 1] == 1) {
                            cnt += 1;
                        }

                        if (m + 1 < M && air[n][m + 1] == 1) {
                            cnt += 1;
                        }

                        if (cnt >= 2) {
                            mat[n][m] = 0;
                        }
                    }
                }
            }

            // 치즈칸을 한번도 안 만나면? -> 탈출
            if (cheese == 0) break;

            time += 1;
            clearAir();
        }

        System.out.println(time);
    }

    static void recAir() {

        for (int m = 0 ; m < M ; m++) {
            bfs(0, m);
            bfs(N - 1, m);
        }

        for (int n = 0 ; n < N ; n++) {
            bfs(n, 0);
            bfs(n, M - 1);
        }

    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});

        air[r][c] = 1;

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == 0 && air[nr][nc] == 0) {
                    air[nr][nc] = 1;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }


    static void clearAir() {
        for (int n = 0 ; n < N ; n++) Arrays.fill(air[n], 0);
    }
}