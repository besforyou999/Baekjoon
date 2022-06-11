/*
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {

    }
}
*/
import java.io.*;
import java.util.*;

public class Main {
    static int dx [] = { 0, 0, -1, 1}; // 상하좌우
    static int dy [] = {-1, 1, 0 , 0};
    static int N, M;
    static int mat[][];
    static boolean visited[][];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1 ; i <= N ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                mat[i][j+1] = str.charAt(j) - '0';
            }
        }

        BFS();
        System.out.print(mat[N][M]);
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1,1});

        while (queue.isEmpty() == false) {
            int coord [] = queue.poll();
            int y = coord[0];
            int x = coord[1];
            for (int i = 0 ; i < 4 ; i++) {
                int new_y = y + dy[i];
                int new_x = x + dx[i];
                if (new_y >= 1 && new_x >= 1 && new_y <= N && new_x <= M) {
                    if (mat[new_y][new_x] != 0 && visited[new_y][new_x] == false) {
                        visited[new_y][new_x] = true;
                        mat[new_y][new_x] = mat[y][x] + 1;
                        queue.add(new int[]{new_y, new_x});
                    }
                }
            }

        }

    }
}
