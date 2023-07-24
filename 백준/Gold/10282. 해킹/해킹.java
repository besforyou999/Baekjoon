import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int node, weight;
        Edge(int n, int w) {
            this.node = n;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int n, d, c;
    static final int INF = 1_000_000_000;
    static ArrayList<Edge>[] edges;
    static int [] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n + 1];
            distance = new int[n + 1];

            for (int i = 0 ; i < n + 1 ; i++) {
                edges[i] = new ArrayList<>();
                distance[i] = INF;
            }

            for (int i = 0 ; i < d ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edges[b].add(new Edge(a, s));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(c, 0));
            distance[c] = 0;

            boolean [] visit = new boolean[n + 1];

            while (!pq.isEmpty()) {

                Edge edge = pq.poll();

                if (!visit[edge.node]) {
                    visit[edge.node] = true;

                    for (Edge next : edges[edge.node]) {
                        if (distance[next.node] > distance[edge.node] + next.weight) {
                            distance[next.node] = distance[edge.node] + next.weight;
                            pq.add(new Edge(next.node, distance[next.node]));
                        }
                    }
                }
            }

            int cnt = 0, result = 0;

            for (int i = 1 ; i < n + 1; i++) {
                if (distance[i] != INF) {
                    cnt += 1;
                    result = Math.max(result, distance[i]);
                }
            }

            sb.append(cnt).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}