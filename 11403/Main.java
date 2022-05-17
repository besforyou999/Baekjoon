import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int mat[][];
    static int ans[][];
    static boolean visited[];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        ans = new int[N][N];
        visited = new boolean[N];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                ans[i][j] = BFS(new int[] {i,j});
                reset_visited();
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        bw.close();
    }

    public static void reset_visited() { visited = new boolean[N]; }

    public static int BFS(int [] point) {
        int start = point[0];
        int target = point[1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0 ; i < N ; i++) {
                if (mat[node][i] == 1 && visited[i] == false) {
                    if (i == target) return 1;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
}
