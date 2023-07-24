import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int dest, cost;
        Node (int d, int c) {
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M, INF = 50000 * 1000 + 1;
    static ArrayList<Node>[] edges;
    static int [] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int n = 0 ; n < N + 1 ; n++) {
            edges[n] = new ArrayList<Node>();
        }

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[A].add(new Node(B, C));
            edges[B].add(new Node(A, C));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dijkstra();

        System.out.println(dist[N]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));

        boolean [] visit = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visit[node.dest]) {
                visit[node.dest] = true;

                for (int i = 0 ; i < edges[node.dest].size() ; i++) {
                    Node next = edges[node.dest].get(i);
                    if (dist[next.dest] > dist[node.dest] + next.cost) {
                        dist[next.dest] = dist[node.dest] + next.cost;
                        pq.add(new Node(next.dest, dist[next.dest]));
                    }
                }
            }
        }
    }
}