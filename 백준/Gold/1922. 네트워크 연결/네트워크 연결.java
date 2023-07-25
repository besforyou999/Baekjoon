import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge>{
    int node, cost;

    Edge(int n, int c) {
        node = n;
        cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0 ; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(prim(1));

    }

    static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visit[] = new boolean[N + 1];
        pq.add(new Edge(start, 0));
        Edge e;
        int ans = 0;
        while(!pq.isEmpty()) {
            e = pq.remove();
            if (!visit[e.node]) {
                visit[e.node] = true;
                ans += e.cost;

                for (Edge next : graph.get(e.node)) {
                    if (!visit[next.node]) {
                        pq.add(next);
                    }
                }
            }
        }
        return ans;
    }
}