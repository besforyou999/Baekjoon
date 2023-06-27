import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [][] input, map;
    static StringTokenizer st;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        input = new int[N][N];
        map = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                input[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        groupIslands();

        int ans = 1_000_000_000;

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                if (input[r][c] == 1) {
                    boolean edge = false;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (isIn(nr, nc) && input[nr][nc] == 0) {
                            edge = true;
                            break;
                        }
                    }

                    if (edge) 
                        ans = Math.min(ans, findClosestLand(r, c, map[r][c]));
                }
            }
        }

        System.out.println(ans);
    }

    public static int findClosestLand(int r, int c, int startingLandNumber) {
        boolean [][] visit = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c, 0});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int [] coord = queue.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];

                if (isIn(nr, nc)) {
                    if (input[nr][nc] == 0 && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        queue.add(new int[] {nr, nc, coord[2] + 1});
                    } else if (input[nr][nc] == 1 && map[nr][nc] != startingLandNumber) {
                        return coord[2];
                    }
                }
            }
        }

        return 1_000_000_000;
    }

    public static void groupIslands() {
        boolean [][] visit = new boolean[N][N];

        int groupNum = 1;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (!visit[i][j] && input[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visit[i][j] = true;
                    map[i][j] = groupNum;

                    while (!queue.isEmpty()) {
                        int [] coord = queue.poll();
                        for (int d = 0 ; d < 4 ; d++) {
                            int nr = dr[d] + coord[0];
                            int nc = dc[d] + coord[1];
                            if (isIn(nr, nc) && !visit[nr][nc] && input[nr][nc] == 1) {
                                map[nr][nc] = groupNum;
                                queue.add(new int[]{nr, nc});
                                visit[nr][nc] = true;
                            }
                        }
                    }

                    groupNum += 1;
                }
            }
        }

    }

    public static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }
}