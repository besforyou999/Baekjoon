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
        int edge = (N - 1) * 4 + 1;
        map = new Character[edge][edge];

        for (int i = 0 ; i < edge ; i++) {
            Arrays.fill(map[i], ' ');
        }

        rec(edge / 2, edge /2 , 0);

        for (int i = 0 ; i < edge ; i++) {
            for (int j = 0 ; j < edge ; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void rec(int row, int col, int depth) {
        if (depth == N) {
            return;
        }

        int edge = (depth) * 4 + 1;

        for (int i = row ; i < row + edge ; i++) {
            for (int j = col ; j < col + edge ; j++) {
                if (i == row) {
                    map[i][j] = Star;
                }

                if (j == col) {
                    map[i][j] = Star;
                }

                if (i == row + edge - 1) {
                    map[i][j] = Star;
                }
                if (j == col + edge - 1) {
                    map[i][j] = Star;
                }
            }
        }
        rec(row - 2, col - 2, depth + 1);
    }
}

