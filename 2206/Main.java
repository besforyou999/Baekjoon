import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int mat[][];
    public static int visit[][][];
    public static int dy [] = { 0, 0, -1, 1};
    public static int dx [] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][M + 1];
        visit = new int[N + 1][M + 1][2];

        for (int i = 1 ; i <= N ; i++) {
            String line = br.readLine();
            for (int j = 1 ; j <= M ; j++) {
                mat[i][j] = line.charAt(j - 1) - '0';
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1, 0});
        visit[1][1][0] = 1;

        while (!queue.isEmpty()) {
            int next[] = queue.poll();
            int r = next[0];
            int c = next[1];
            int w = next[2];

            if (r == N && c == M) {
                return visit[r][c][w];
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];
                if (isIn(nr, nc)) {
                    if (visit[nr][nc][w] == 0 && mat[nr][nc] == 0) {
                        visit[nr][nc][w] = visit[r][c][w] + 1;
                        queue.add(new int[] {nr, nc, w});
                    } else if (w == 0 && mat[nr][nc] == 1) {
                        visit[nr][nc][w + 1] = visit[r][c][w] + 1;
                        queue.add(new int[] {nr, nc, w + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }
}

