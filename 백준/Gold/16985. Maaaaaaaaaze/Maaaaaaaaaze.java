import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int plain_maze[][][];
    static int maze[][][];

    static int dr[] = {0, 0, -1, 1, 0, 0};
    static int dc[] = {-1, 1, 0, 0, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};

    static int MIN = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        plain_maze = new int[5][5][5];
        maze = new int[5][5][5];

        for (int maze = 0 ; maze < 5 ; maze++) {
            for (int r = 0 ; r < 5 ; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0 ; c < 5 ; c++) {
                    plain_maze[maze][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        platePerm(0, new boolean[5], new int[5]);

        if (MIN == 1_000_000_000) {
            MIN = -1;
        }

        System.out.println(MIN);
    }
    static void platePerm(int depth, boolean [] used, int [] arr) {
        if (depth == 5) {
            spinRec(0, arr, new int[5]);
            return;
        }

        for (int i = 0 ; i < 5 ; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                platePerm(depth + 1 , used, arr);
                used[i] = false;
            }
        }
    }

    static void spinRec(int depth, int plateOrder[], int [] spin) {
        if (depth == 5) {
            simulation(plateOrder, spin);
            return;
        }

        for (int i = 0; i < 4 ; i++) {
            spin[depth] = i;
            spinRec(depth + 1, plateOrder, spin);
        }

    }


    static void simulation(int plate[], int spin[]) {
        // plate 순서 따라 maze에 복사
        for (int i = 0 ; i < 5 ; i++) {
            int board[][] = maze[i];
            int plateNum = plate[i];
            for (int r = 0 ; r < 5 ; r++) {
                for (int c = 0 ; c < 5 ; c++) {
                    board[r][c] = plain_maze[plateNum][r][c];
                }
            }
        }

        for (int i = 0 ; i < 5 ; i++) {
            for (int s = 0 ; s < spin[i] ; s++) {
                spinBoard(maze[i]);
            }
        }

        if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return;

        int result = bfs();
        if (result != -1) {
            MIN = Math.min(MIN, result);
        }

    }

    static void spinBoard(int [][] board) {
        int n = 5;

        for (int i = 0 ; i < n / 2 ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int tmp = board[i][j];
                board[i][j] = board[n - i - 1][j];
                board[n - i - 1][j] = tmp;
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                int tmp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = tmp;
            }
        }
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 0});

        boolean visit[][][] = new boolean[5][5][5];
        visit[0][0][0] = true;

        while(!queue.isEmpty()) {
            int coords[] = queue.poll();
            int x = coords[0];
            int y = coords[1];
            int z = coords[2];
            int cnt = coords[3];

            if (x == 4 && y == 4 && z == 4) {
                return cnt;
            }

            for (int i = 0 ; i < 6 ; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                int nz = z + dz[i];

                if (isIn(nx, ny, nz) && !visit[nx][ny][nz] && maze[nx][ny][nz] == 1) {
                    visit[nx][ny][nz] = true;
                    queue.add(new int[] {nx, ny, nz, cnt + 1});
                }
            }
        }

        return -1;
    }

    static boolean isIn(int x, int y, int z) {
        return (x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5);
    }





}