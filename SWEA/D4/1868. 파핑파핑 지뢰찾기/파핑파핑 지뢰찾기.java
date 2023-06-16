import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static char [][] mat;
    static boolean [][] visit;
    static int N;

    // 0, 45, 90, 135, 180, 225, 270, 315
    static int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());

            mat = new char[N + 1][N + 1];
            visit = new boolean[N + 1][N + 1];

            for (int r = 1 ; r <= N ; r++) {
                String [] tokens = br.readLine().split("");
                for (int c = 1 ; c <= N ; c++) {
                    mat[r][c] = tokens[c - 1].charAt(0);
                }
            }

            int cnt = 0;

            // 8 방향 주변 지뢰 없는 좌표만 먼저 클릭
            for (int r = 1 ; r <= N ; r++) {
                for (int c = 1 ; c <= N ; c++) {
                    boolean mine = false;
                    for (int i = 0 ; i < 8 ; i++) {
                        if (isIn(r + dr[i], c + dc[i]) && mat[r + dr[i]][c + dc[i]] == '*') {
                            mine = true;
                            break;
                        }
                    }

                    if (!mine && mat[r][c] == '.' && !visit[r][c]) {
                        bfs(r, c);
                        cnt += 1;
                    }
                }
            }

            // 나머지 클릭
            for (int r = 1 ; r <= N ; r++){
                for (int c = 1 ; c <= N ; c++) {
                    if (!visit[r][c] && mat[r][c] == '.') {
                        cnt += 1;
                        bfs(r, c);
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }

    public static void bfs (int r, int c) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int [] coord = queue.poll();
            r = coord[0];
            c = coord[1];

            int mine = 0;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == '*') {
                    mine += 1;
                }
            }

            if (mine == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (isIn(nr, nc) && !visit[nr][nc] && mat[nr][nc] == '.') {
                        visit[nr][nc] = true;
                        queue.add(new int [] {nr, nc});
                    }
                }
            }
        }
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }
}