import java.io.*;
import java.util.*;

public class Main {
    static int mat[][];
    static int dist[][];
    static int N;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            mat = new int[N][N];
            dist = new int[N][N];
            init_dist();
            for (int i = 0 ; i < N ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < N ; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS();
            String problem = "Problem " + count.toString() + ": ";
            count += 1;
            bw.write(problem + dist[N-1][N-1] + "\n");
            bw.flush();
        }
        bw.flush();
        bw.close();
        return;
    }

    public static void init_dist() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void BFS() {

        dist[0][0] = mat[0][0];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int arr[] = queue.poll();
            int y = arr[0];
            int x = arr[1];

            for (int i = 0 ; i < 4 ; i++) {
                int new_y = y + dy[i];
                int new_x = x + dx[i];
                if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
                    if (dist[new_y][new_x] > dist[y][x] + mat[new_y][new_x]) {
                        dist[new_y][new_x] = dist[y][x] + mat[new_y][new_x];
                        queue.add(new int[] {new_y, new_x});
                    }
                }
            }
        }
    }
}
