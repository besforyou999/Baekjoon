import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int T, N, M;
    static StringTokenizer st;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    static char [][] map;
    static final String FAIL = "GAME OVER";

    static Coord god, suyeon;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {

            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N + 1][M + 1];

            for (int r = 1 ; r < N + 1 ; r++) {
                String line = br.readLine();
                for (int c = 1 ; c < M + 1 ; c++) {
                    map[r][c] = line.charAt(c - 1);
                    if (map[r][c] == 'S') {
                        suyeon = new Coord(r, c);
                    } else if (map[r][c] == 'D') {
                        god = new Coord(r, c);
                    }
                }
            }

            int result = simulation();

            if (result == -1) {
                sb.append(FAIL).append("\n");
            } else {
                sb.append(result - 1).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int simulation() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {suyeon.r, suyeon.c, 1});

        // O(N * M)
        for (int r = 1 ; r < N + 1 ; r++) {
            for (int c = 1 ; c < M + 1 ; c++) {
                if (map[r][c] == '*') {
                    queue.add(new int[] {r, c, -1});
                }
            }
        }

        return bfs(queue);
    }

    static int bfs(Queue<int[]> queue) {
        int [][] visit = new int[N + 1][M + 1];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {

                int[] ele = queue.poll();

                if (ele[2] != -1 && ele[0] == god.r && ele[1] == god.c) // 수연이가 신을 만난 경우
                    return ele[2];

                if (ele[2] == -1) { // 넣은 요소가 악마인 경우

                    for (int i = 0; i < 4; i++) {

                        int nr = ele[0] + dr[i];
                        int nc = ele[1] + dc[i];

                        if (isIn(nr, nc) && visit[nr][nc] != -1) {
                            if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                                visit[nr][nc] = -1;
                                queue.add(new int[]{nr, nc, -1});
                            }
                        }
                    }
                } else { // 넣은 요소가 수연인 경우

                    if (visit[ele[0]][ele[1]] == -1) continue;
                    
                    for (int i = 0; i < 4; i++) {

                        int nr = ele[0] + dr[i];
                        int nc = ele[1] + dc[i];

                        if (isIn(nr, nc) && visit[nr][nc] == 0) {
                            if (map[nr][nc] == '.' || map[nr][nc] == 'D') {
                                visit[nr][nc] = ele[2] + 1;
                                queue.add(new int[]{nr, nc, ele[2] + 1});
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }


    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }

    static class Coord {
        int r, c;
        Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}