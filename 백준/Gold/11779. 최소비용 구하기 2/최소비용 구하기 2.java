import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int d;
    long cost;
    Edge (int d, long c) {
        this.d = d;
        this.cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Edge>> edges;
    static int [] route;
    static long [] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int n = 0 ; n <= N ; n++) {
            edges.add(new ArrayList<>());
        }

        for (int m = 0 ; m < M ; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edges.get(start).add(new Edge(end, cost));
        }

        for (ArrayList<Edge> edge : edges) {
            Collections.sort(edge);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        route = new int[N + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, 1_000_000_001);

        dijkstra(start);

        System.out.println(distance[end]);

        Stack<Integer> routes = new Stack<>();
        int current = end;
        while (current != 0) {
            routes.add(current);
            current = route[current];
        }

        System.out.println(routes.size());

        StringBuilder sb = new StringBuilder();
        while(!routes.isEmpty())
            sb.append(routes.pop()).append(" ");

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0l));
        boolean [] visit = new boolean[N + 1];
        distance[start] = 0;
        route[start] = 0;

        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (visit[edge.d]) continue;

            visit[edge.d] = true;

            for (Edge next : edges.get(edge.d)) {
                if (!visit[next.d]) {
                    if (distance[next.d] > distance[edge.d] + next.cost) {
                        distance[next.d] = distance[edge.d] + next.cost;
                        queue.add(new Edge(next.d, distance[next.d]));
                        route[next.d] = edge.d;
                    }
                }
            }
        }
    }



}