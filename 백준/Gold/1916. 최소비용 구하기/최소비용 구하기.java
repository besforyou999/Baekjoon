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
    static int N, M;
    static PriorityQueue<Edge> edges [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new PriorityQueue[N + 1];
        for (int i = 0 ; i <= N ; i++) {
            edges[i] = new PriorityQueue<Edge>();
        }

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[city1].add(new Edge(city2, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int distance[] = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        while (!edges[start].isEmpty()) {
            Edge edge = edges[start].poll();
            int node = edge.node;
            int dist = edge.distance;

            if (distance[node] != -1) continue;
            distance[node] = dist;

            for(Edge next : edges[node]) {
                edges[start].add(new Edge(next.node, next.distance + dist));
            }
        }

        System.out.println(distance[end]);
    }
}