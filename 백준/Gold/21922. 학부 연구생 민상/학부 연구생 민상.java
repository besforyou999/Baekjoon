import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int mat[][];
    static boolean visit[][][];

    static int dr[] = {0, 1, 0, -1};
    static int dc[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N][M];
        visit = new boolean[N][M][4];

        ArrayList<int[]> acCoords = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
                if (mat[n][m] == 9)
                    acCoords.add(new int[]{n, m});
            }
        }

        for (int[] coord : acCoords) {
            int r = coord[0];
            int c = coord[1];
            bfs(r, c);
        }

        int ans = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 4; i++) {
                    if (visit[r][c][i]) {
                        ans += 1;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);

    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(new int[]{r, c, i});
            visit[r][c][i] = true;
        }

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int R = coord[0];
            int C = coord[1];
            int dir = coord[2];

            int nr = R + dr[dir];
            int nc = C + dc[dir];

            if (!isIn(nr, nc)) continue;

            int nextDir = getNextDir(mat[nr][nc], dir);

            if (!visit[nr][nc][nextDir]) {
                visit[nr][nc][nextDir] = true;
                queue.add(new int[]{nr, nc, nextDir});
            }
        }
    }

    static int getNextDir(int item, int d) {
        if (item == 0) return d;
        else if (item == 1) {
            if (d == 0) return 2;
            else if (d == 2) return 0;
            else return d;
        } else if (item == 2) {
            if (d == 1) return 3;
            else if (d == 3) return 1;
            else return d;
        } else if (item == 3) {
            if (d == 0) return 3;
            else if (d == 1) return 2;
            else if (d == 2) return 1;
            else return 0;
        } else if (item == 4) {
            if (d == 0) return 1;
            else if (d == 1) return 0;
            else if (d == 2) return 3;
            else return 2;
        } else {
            if (d == 0) return 2;
            else if (d == 1) return 3;
            else if (d == 2) return 0;
            else return 1;
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }
}