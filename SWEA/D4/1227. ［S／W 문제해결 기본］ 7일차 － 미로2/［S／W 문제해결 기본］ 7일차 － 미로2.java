import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            int t = Integer.parseInt(br.readLine());

            int [][] mat = new int[101][101];
            boolean [][] visit = new boolean[101][101];

            int [] start = new int[2];
            int [] end = new int[2];

            for (int r = 1 ; r <= 100 ; r++) {
                String line = br.readLine();
                for (int c = 1 ; c <= 100 ; c++) {
                    mat[r][c] = line.charAt(c - 1) - '0';
                    if (mat[r][c] == 2) {
                        start[0] = r;
                        start[1] = c;
                    } else if (mat[r][c] == 3) {
                        end[0] = r;
                        end[1] = c;
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {start[0], start[1]});
            visit[start[0]][start[1]] = true;

            while(!queue.isEmpty()) {
                int [] coord = queue.poll();
                for (int i = 0 ; i < 4 ; i++) {
                    int nr = coord[0] + dr[i];
                    int nc = coord[1] + dc[i];
                    if (isIn(nr, nc) && !visit[nr][nc] && mat[nr][nc] != 1) {
                        visit[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }

            int result = 0;

            if (visit[end[0]][end[1]])
                result = 1;

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c) {
        return ( r >= 1 && r <= 100 && c >= 1 && c <= 100);
    }
}