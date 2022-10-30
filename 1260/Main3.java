import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int mat[][];
    static boolean visited[];
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            mat[start][end] = mat[end][start] = 1;
        }

        dfs(V);
        bw.write("\n");
        bw.flush();

        Arrays.fill(visited, false);
        bfs(V);
        bw.flush();
        bw.close();
    }

    static void dfs(int start) throws IOException {
        if (visited[start]) return;
        visited[start] = true;
        bw.write(start + " ");
        for (int i = 1 ; i < N + 1; i++) {
            if (mat[start][i] == 1)
                dfs(i);
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            bw.write(v + " ");

            for (int i = 1 ; i < N + 1 ; i++) {
                if (mat[v][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

