import java.io.*;
import java.util.*;


class Main {
    public static int N, M;
    public static int mat[][];
    public static boolean visited [];
    public static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            mat[one][two] = mat[two][one] = 1;
        }

        sb = new StringBuilder();

        DFS(V);
        sb.append("\n");
        reset();
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int v) {
        if (visited[v])
            return;

        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1 ; i <= N ; i++) {
            if (mat[v][i] == 1 && !visited[i])
                DFS(i);
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()) {
            int next = queue.poll();
            if (!visited[next]) {
                visited[next] = true;
                sb.append(next).append(" ");
                for (int i = 1; i <= N; i++) {
                    if (mat[next][i] == 1 && !visited[i])
                        queue.add(i);
                }
            }
        }
    }

    public static void reset() {
        Arrays.fill(visited, false);
    }
}
