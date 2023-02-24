import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char mat[][];
    static boolean visited[][];
    static int dx [] = {0, 0, -1, 1};
    static int dy [] = {-1, 1, 0 ,0};

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        mat = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                mat[i][j] = line.charAt(j);
            }
        }

        Integer red_group = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] == false) {
                    DFS(new int[]{i, j});
                    red_group += 1;
                }
            }
        }

        reset_visited();
        flip_color();

        Integer group = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] == true) continue;
                DFS(new int[] {i, j});
                group += 1;
            }
        }
        System.out.print(red_group + " " + group);
    }

    public static void reset_visited() {
        visited = new boolean[N][N];
    }

    public static void flip_color() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (mat[i][j] == 'R') mat[i][j] = 'G';
            }
        }
    }

    public static void DFS(int [] point) {
        int y = point[0];
        int x = point[1];

        visited[y][x] = true;

        for (int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || mat[ny][nx] != mat[y][x]) continue;
            DFS(new int[] {ny, nx});
        }
    }

}