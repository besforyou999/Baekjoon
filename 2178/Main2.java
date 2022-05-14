import java.io.*;
import java.util.*;

public class Main {
    static int X[] = {0,0, -1, 1};
    static int Y[] = {-1,1, 0, 0};
    static int N, M;
    static int mat[][];
    static boolean visited[][];

    static BufferedWriter bw;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1 ; i <= N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                Character ch = line.charAt(j);
                mat[i][j+1] = ch - '0';
            }
        }

        visited[1][1] = true;
        BFS(new Pair(1,1));

        System.out.print(mat[N][M]);
    }

    public static void BFS(Pair p) throws IOException {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0 ; i < 4 ; i++) {
                int new_x = x + X[i];
                int new_y = y + Y[i];
                if (new_x >= 1 && new_x <= N && new_y >= 1 && new_y <= M) {
                    if (mat[new_x][new_y] != 0 && visited[new_x][new_y] == false ) {
                        mat[new_x][new_y] = mat[x][y] + 1;
                        queue.add(new Pair(new_x,new_y));
                        visited[new_x][new_y] = true;
                    }
                }
            }
        }
    }

}

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
        this.count = 1;
    }

}

