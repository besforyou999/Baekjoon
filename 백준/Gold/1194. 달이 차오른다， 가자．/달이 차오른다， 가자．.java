import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char mat[][];
    static boolean [][][] visit;

    static int dr [] = {-1, 1, 0 , 0};
    static int dc [] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new char[N][M];
        visit = new boolean[64][N][M];

        int start_row = 0 , start_col = 0;

        for (int r = 0 ; r < N ; r++) {
            String line = br.readLine();
            for (int c = 0 ; c < M ; c++) {
                mat[r][c] = line.charAt(c);
                if (mat[r][c] == '0') {
                    start_row = r;
                    start_col = c;
                }
            }
        }

        System.out.println(bfs(start_row, start_col));
    }

    static int bfs(int start_row, int start_col) {

        Queue<Next> queue = new LinkedList<>();
        queue.add(new Next(start_row, start_col, 0, 0));

        visit[0][start_row][start_col] = true;

        while(!queue.isEmpty()) {
            Next next = queue.poll();
            int r = next.r;
            int c = next.c;
            int cnt = next.cnt;
            int key = next.key;

            if (mat[r][c] == '1')
                return cnt;

            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && !visit[key][nr][nc] && mat[nr][nc] != '#') {
                    char curVal = mat[nr][nc];
                    if (curVal == '0' || curVal == '.' || curVal == '1') {
                        visit[key][nr][nc] = true;
                        queue.add(new Next(nr, nc, cnt + 1, key));
                    } else if (curVal >= 'a' && curVal <= 'f') {
                        int newKey = 1 << (curVal - 'a') ;
                        newKey = newKey | key;
                        if (!visit[newKey][nr][nc]) {
                            visit[newKey][nr][nc] = true;
                            visit[key][nr][nc] = true;
                            queue.add(new Next(nr, nc, cnt + 1 , newKey));
                        }
                    } else if (curVal >= 'A' && curVal <= 'F') {
                        int door = 1 << (curVal - 'A');
                        if ( (door & key) > 0) {
                            visit[key][nr][nc] = true;
                            queue.add(new Next(nr, nc, cnt + 1, key));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }

    static class Next {
        int r, c, cnt, key;
        Next(int r, int c, int cnt, int key) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }
}