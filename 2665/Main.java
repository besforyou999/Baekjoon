import java.io.*;
import java.util.*;

// 0 : 검은방, 1 : 흰방
class Main {
    public static int n;
    public static int matrix[][];
    public static int record[][];
    public static int dx [] = {0, 0, -1, 1};
    public static int dy [] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        record = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < n ; j++) {
                matrix[i][j] = line.charAt(j) - '0';
                record[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(0, 0);
        System.out.println(record[n-1][n-1]);

    }

    public static void dfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        record[r][c] = 0;

        while (!queue.isEmpty()) {
            int pos[] = queue.poll();
            int row = pos[0];
            int col = pos[1];

            for (int i = 0 ; i < 4 ; i++) {
                int next_r = row + dy[i];
                int next_c = col + dx[i];
                if (next_r < 0 || next_c < 0 || next_c >= n || next_r >= n) continue;
                if (record[next_r][next_c] > record[row][col]) {
                    if (matrix[next_r][next_c] == 1) record[next_r][next_c] = record[row][col];
                    else    record[next_r][next_c] = record[row][col] + 1;
                    queue.add(new int[] {next_r, next_c});
                }
            }
        }
    }

}

