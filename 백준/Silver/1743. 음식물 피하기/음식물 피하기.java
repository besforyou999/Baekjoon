import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int [][] mat;
    static boolean [][] visit;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int k = 0 ; k < K ; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mat[r][c] = 1;
        }

        int max =-1;

        for (int r = 1 ; r <= N ; r++) {
            for (int c = 1 ;c <= M ; c++) {
                if (!visit[r][c] && mat[r][c] == 1) {
                    max = Math.max(max, bfs(r, c));
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});

        visit[r][c] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int [] ele = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nr = ele[0] + dr[i];
                int nc = ele[1] + dc[i];

                if (isIn(nr, nc) && mat[nr][nc] == 1 && !visit[nr][nc]) {
                    area += 1;
                    visit[nr][nc] = true;
                    queue.add(new int[] {nr ,nc});
                }
            }
        }

        return area;
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }



}