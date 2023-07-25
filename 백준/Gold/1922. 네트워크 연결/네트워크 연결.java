import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static class Edge implements Comparable<Edge> {
        int node, cost;
        Edge(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M;

    static ArrayList<ArrayList<Edge>> edges; // 특정 정점에서 특정 정점으로 가는 edge를 기록하기 위한 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int v = 0 ; v <= N ; v++) {
            edges.add(new ArrayList<Edge>());
        }

        for (int e = 0 ; e < M ; e++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.get(A).add(new Edge(B, C));
            edges.get(B).add(new Edge(A, C));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        boolean [] visit = new boolean[N + 1];

        int cnt = 0;
        long cost = 0;

        while (!pq.isEmpty() && cnt < N) {
            Edge edge = pq.poll();

            if (visit[edge.node]) continue;

            visit[edge.node] = true;

            cnt++;
            cost += edge.cost;

            for (Edge next : edges.get(edge.node)) {
                if (!visit[next.node]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(cost);
    }
}