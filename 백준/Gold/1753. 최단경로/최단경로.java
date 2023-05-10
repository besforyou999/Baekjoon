import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int node, distance;
    Edge(int n, int d) {
        this.node = n;
        this.distance = d;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(distance, o.distance);
    }
}

public class Main {
    static int V, E, K;
    static PriorityQueue<Edge> edges[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        edges = new PriorityQueue[V + 1];
        for (int v = 0 ; v < V + 1 ; v++) {
            edges[v] = new PriorityQueue<>();
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        int distance[] = new int[V + 1];
        Arrays.fill(distance, -1);

        distance[K] = 0;

        while(!edges[K].isEmpty()) {
            Edge edge = edges[K].poll();
            int node = edge.node;
            int dist = edge.distance;

            if (distance[node] != -1) continue;
            distance[node] = dist;

            for (Edge next : edges[node]) {
                edges[K].add(new Edge(next.node, next.distance + dist));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int v = 1 ; v <= V ; v++) {
            if (distance[v] == -1) {
                sb.append("INF");
            } else {
                sb.append(distance[v]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}