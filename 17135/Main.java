import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int N, M, D, enemy_number, answer = -1;
    static int source[][];
    static ArrayList<ArrayList<Integer>> archer_pos;
    static int [] dx = {0, -1, 0}, dy = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        source = new int[N][M];
        archer_pos = new ArrayList<>();

        // Read input
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) enemy_number += 1;
                source[i][j] = val;
            }
        }

        // build archer pos with combination
        int castles [] = new int[M];
        boolean visited[] = new boolean[M];
        for (int i = 0 ; i < M ; i++)
            castles[i] = i;

        comb(castles, visited, 0, 3);

        // run simulations with archer positions
        for (ArrayList<Integer> arr : archer_pos) {
            int kills = one_simulation(arr);
            answer = Math.max(kills, answer);
        }

        System.out.print(answer);
    }

    static int one_simulation(ArrayList<Integer> pos) {
        int kills = 0;

        int [][] map = copyMap();
        boolean [][] died;

        for (int i = 0 ; i < N ; i++) {
            died = new boolean[N][M];
            for (int x : pos) {
                if (map[N - 1][x] == 1) {
                    died[N - 1][x] = true;
                } else {
                    bfs(new Point(N - 1, x), died, map);
                }
            }

            int count = kill(died, map);
            kills += count;
            move(map);
        }

        return kills;
    }

    static void bfs(Point start, boolean[][] died, int[][] map) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(start);
        visited[start.x][start.y] = true;

        for (int cnt = 1 ; cnt < D ; cnt++) {
            int len = queue.size();

            for (int j = 0 ; j < len ; j++) {
                int px = queue.peek().x;
                int py = queue.poll().y;

                for (int i = 0 ; i < 3 ; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if (!isIn(nx, ny) || visited[nx][ny]) continue;

                    if (map[nx][ny] == 1) {
                        died[nx][ny] = true;
                        return;
                    }

                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static int [][] copyMap() {
        int [][] map = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = source[i][j];
            }
        }
        return map;
    }

    static int kill(boolean[][]died, int[][] playMap) {
        int cnt = 0;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0 ; j < M ; j++) {
                if(died[i][j]) {
                    cnt++;
                    playMap[i][j] = 0;
                }
            }
        }
        return cnt;
    }

    static void comb(int castles[], boolean visited[], int depth, int r) {
        if (r == 0) {
            add_to_array(castles, visited);
            return;
        }
        if (depth == castles.length) return;
        else {
            visited[depth] = true;
            comb(castles, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb(castles, visited, depth + 1 , r);
        }
    }

    static void add_to_array(int castles[], boolean visited[]) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0 ; i < castles.length ; i++) {
            if (visited[i] == true)
                pos.add(i);
        }
        archer_pos.add(pos);
    }

    static void move(int [][] playMap) {
        for (int i = N - 1 ;  i >= 0 ; i--) {
            for (int j = 0 ; j < M ; j++) {
                if (playMap[i][j] == 1) {
                    playMap[i][j] = 0;
                    if (i + 1 < N)
                        playMap[i + 1][j] = 1;
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M) return true;
        return false;
    }
}

