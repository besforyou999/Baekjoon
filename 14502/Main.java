import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int mat[][];
    static ArrayList<Pair> zero_pos;
    static ArrayList<Pair[]> wall_pos;
    static int board[][];
    static boolean visited[][];
    static int dy [] = {-1, 1 , 0 , 0};
    static int dx [] = {0, 0, -1, 1};

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][M];
        board = new int[N][M];
        visited = new boolean[N][M];
        zero_pos = new ArrayList<>();
        wall_pos = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int number = Integer.parseInt(st.nextToken());
                mat[i][j] = number;
                if (number == 0) zero_pos.add(new Pair(i,j));
            }
        }

        build_wall_pos();

        int max = -1;

        for (int i = 0 ; i < wall_pos.size() ; i++) {
            Pair [] walls = wall_pos.get(i);
            int temp = getSafeSpaceSize(walls);
            max = Math.max(max, temp);
            reset();
        }
        System.out.print(max);
    }

    public static void reset() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                visited[i][j] = false;
            }
        }
    }


    public static int getSafeSpaceSize(Pair [] walls) {
        copyMatToBoard();
        for (Pair p : walls) {
            int y = p.y;
            int x = p.x;
            board[y][x] = 1;
        }

        spread_virus();
        return count_safe_space();
    }

    public static int count_safe_space() {
        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (board[i][j] == 0) ans += 1;
            }
        }
        return ans;
    }

    public static void spread_virus() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (board[i][j] == 2 && visited[i][j] == false) {
                    BFS(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
    }

    public static void BFS(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0 ; i < 4 ; i++) {
                int new_y = y + dy[i];
                int new_x = x + dx[i];
                if (new_y < 0 || new_x < 0 || new_y >= N || new_x >= M) continue;
                if (visited[new_y][new_x] == true || board[new_y][new_x] == 1) continue;
                if (visited[new_y][new_x] == false && board[new_y][new_x] == 0) {
                    queue.add(new Pair(new_y, new_x));
                    visited[new_y][new_x] = true;
                    board[new_y][new_x] = 2;
                }
            }
        }
    }

    public static void copyMatToBoard() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                board[i][j] = mat[i][j];
            }
        }
    }

    public static void build_wall_pos() {
        int len = zero_pos.size();
        for (int i = 0 ; i < len - 2; i++) {
            for (int j = i + 1 ; j < len - 1 ; j++) {
                for (int l = j + 1 ; l < len ; l++) {
                    Pair one = zero_pos.get(i);
                    Pair two = zero_pos.get(j);
                    Pair three = zero_pos.get(l);
                    Pair [] arr = {one, two, three};
                    wall_pos.add(arr);
                }
            }
        }
    }
}

class Pair {
    int y, x;
    Pair (int y, int x) {
        this.y = y;
        this.x = x;
    }
}
