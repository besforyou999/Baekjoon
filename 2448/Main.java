import java.io.*;
import java.util.*;

class Main {
    public static int N;
    public static Character[][] map;
    public static StringBuilder sb = new StringBuilder();
    public static final Character Star = '*';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        N = Integer.parseInt(input);

        map = new Character[N][N * 2 - 1];
        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(map[i], ' ');
        }

        rec(0, N - 1, N);

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N * 2 - 1 ; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void rec(int row, int col, int n) {
        if (n == 3) {
            map[row][col] = Star;
            map[row + 1][col - 1] = map[row + 1][col + 1] = Star;
            map[row + 2][col - 2] = map[row + 2][col - 1] = map[row + 2][col] = map[row + 2][col + 1] = map[row + 2][col + 2] = Star;
        } else {
            int half = n/2;
            rec(row, col, half);
            rec(row + half, col + half, half);
            rec(row + half, col - half, half);
        }
    }
}
