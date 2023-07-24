import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int node, weight;

        Edge (int n, int w) {
            this.node = n;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    static int INF = 1_000_000_000;
    static ArrayList<Edge> [] edges;
    static int [] dist;

    static int N, D, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N + 1];
            dist = new int[N + 1];

            for (int i = 0 ; i < N + 1 ; i++) {
                edges[i] = new ArrayList<>();
                dist[i] = INF;
            }

            for (int i = 0 ; i < D ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edges[b].add(new Edge(a, s));
            }

            dijkstra(C);

            int cnt = 0, result = 0;

            for (int i = 1 ; i < N + 1 ; i++) {
                if (dist[i] != INF) {
                    cnt += 1;
                    result = Math.max(result, dist[i]);
                }
            }

            sb.append(cnt).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        boolean [] visit = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!visit[edge.node]) {
                visit[edge.node] = true;

                for (Edge next : edges[edge.node]) {
                    if (dist[next.node] > dist[edge.node] + next.weight) {
                        dist[next.node] = dist[edge.node] + next.weight;
                        pq.add(new Edge(next.node, dist[next.node]));
                    }
                }
            }
        }
    }
}