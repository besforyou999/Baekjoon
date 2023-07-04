import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int T;
    static StringTokenizer st;
    static int MAX = 142;
    static int [] dr = {-1, -1, 0, 1, 1, 0};
    static int [] dc = {-1, 0, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        HashMap<Integer, Coord> map = new HashMap<>();
        int number = 1;

        for (int i = 0 ; i < MAX ; i++) {
            for (int j = i ; j >= 0 ; j--) {
                map.put(number++, new Coord(i, j));
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Coord start = map.get(a);
            Coord target = map.get(b);

            int ans = 0;

            if (start.r == target.r && start.c != target.c) {
                ans = Math.abs(start.c - target.c);
            } else if (start.c == target.c && start.r != target.r) {
                ans = Math.abs(start.r - target.r);
            } else {
                ans = bfs(start, target);
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(Coord start, Coord target) {
        boolean [][] visit = new boolean[MAX][MAX];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start.r, start.c, 0});

        visit[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            int [] ele = queue.poll();

            if (ele[0] == target.r && ele[1] == target.c) return ele[2];

            for (int i = 0 ; i < 6 ; i++) {

                int nr = ele[0] + dr[i];
                int nc = ele[1] + dc[i];

                if (isIn(nr, nc) && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new int[] { nr, nc, ele[2] + 1});
                }
            }
        }

        return 0;
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < MAX && c >= 0 && c < MAX);
    }

    static class Coord {
        int r, c;
        Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}