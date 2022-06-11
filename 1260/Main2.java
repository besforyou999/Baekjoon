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
    static int N, M, V;
    static int mat[][];
    static boolean visited[];
    static BufferedWriter bw;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        mat = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            mat[first][second] = mat[second][first] = 1;
        }

        DFS(V);
        bw.flush();
        visited_reset();
        bw.write("\n");
        BFS(V);
        bw.flush();
        bw.close();
    }

    public static void visited_reset() {
        for (int i = 0 ; i < N + 1 ; i++) visited[i] = false;
    }

    public static void DFS(int v) throws IOException {
        if (visited[v] == true) return;
        visited[v] = true;
        bw.write(v + " ");
        for (int i = 1 ; i <= N ; i++) {
            if (visited[i] == false && mat[v][i] == 1) DFS(i);
        }
    }

    public static void BFS(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(queue.isEmpty() == false) {
            int node = queue.poll();
            if (visited[node] == false) {
                visited[node] = true;
                bw.write(node + " ");
                for (int i = 1 ; i <= N ; i++) {
                    if (mat[node][i] == 1 && visited[i] == false) queue.add(i);
                }
            }
        }
        bw.flush();
    }
}
