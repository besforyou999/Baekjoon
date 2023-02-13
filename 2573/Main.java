import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int mat[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 1;
        int blob = 1;
        while (true) {
            int something_to_melt = melt();
            //print();
            if (something_to_melt == 0) break;
            blob = blobs();
            //System.out.println("blobs : " + blob);
            if (blob > 1) break;
            cnt += 1;
        }

        if (blob <= 1) {
            System.out.println(0);
        } else
            System.out.println(cnt);
    }

    static int melt() {
        int something_to_melt = 0;

        int delta[][] = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (mat[i][j] > 0) {
                    something_to_melt = 1;
                    int sea_water = 0;
                    for (int k = 0 ; k < 4 ; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (isIn(nr, nc) && mat[nr][nc] == 0)
                            sea_water += 1;
                    }
                    delta[i][j] = sea_water;
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] -= delta[i][j];
                if (mat[i][j] < 0) mat[i][j] = 0;
            }
        }

        return something_to_melt;
    }

    static int blobs() {
        int blobs = 0;
        boolean visit[][] = new boolean[N][M];
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (!visit[i][j] && mat[i][j] > 0) {
                    bfs(i, j, visit);
                    blobs += 1;
                }
            }
        }
        return blobs;
    }

    static void bfs(int r, int c, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;

        while(!queue.isEmpty()) {
            int []cod = queue.poll();
            int row = cod[0];
            int col = cod[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (isIn(nr, nc) && !visit[nr][nc] && mat[nr][nc] > 0) {
                    visit[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }
}
