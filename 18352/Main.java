import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static final int INF = Integer.MAX_VALUE;
    static int N, M, K, X;
    static ArrayList<Node> []mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        mat = new ArrayList[N + 1];
        for (int i = 0 ; i <= N ; i++) {
            mat[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a].add(new Node(b, 1));
        }

        int dest [] = dijkstra(X);

        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i <= N ; i++) {
            if (dest[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        System.out.print(sb);

    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int dp [] = new int[N + 1];
        boolean visit[] = new boolean[N + 1];
        Arrays.fill(dp, INF);
        dp[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int to = tmp.to;
            int weight = tmp.weight;
            if (visit[to]) continue;
            for (Node n : mat[to]) {
                if (dp[n.to] > n.weight + weight) {
                    dp[n.to] = n.weight + weight;
                    queue.add(new Node(n.to, dp[n.to]));
                }
            }
        }
        return dp;
    }
}

