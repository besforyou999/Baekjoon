import java.io.*;
import java.util.*;

public class Main {
    static int X[] = {0, 0, -1, 1};
    static int Y[] = {-1, 1, 0, 0};
    static int N ,M ,K;
    static int mat[][];
    static boolean visited[][];
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while ( T > 0 ) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mat = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0 ; i < K ; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                mat[first][second] = 1;
            }
            int count = 0;
            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < M ; j++) {
                    if (mat[i][j] == 1 && visited[i][j] == false) {
                        BFS(new Pair(i,j));
                        count += 1;
                    }
                }
            }
            System.out.println(count);
            T -= 1;
        }
    }

    public static void BFS (Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);

        while (queue.isEmpty() == false) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0 ; i < 4 ; i++) {
                int new_x = x + X[i];
                int new_y = y + Y[i];
                if (new_x < 0 || new_x >= N || new_y < 0 || new_y >= M) continue;
                if (mat[new_x][new_y] == 1 && visited[new_x][new_y] == false) {
                    queue.add(new Pair(new_x, new_y));
                    visited[new_x][new_y] = true;
                }
            }
        }
    }
}



class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

