import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int d, cost;
        Node (int d, int c) {
            this.d = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M, INF = 2_000_000_000;
    static ArrayList<ArrayList<Node>> edges;

    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for (int n = 0 ; n <= N ; n++) {
                edges.add(new ArrayList<>());
            }

            for (int m = 0 ; m < M ; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges.get(a).add(new Node(b, c));
                edges.get(b).add(new Node(a, c));
            }

            int K = Integer.parseInt(br.readLine());

            distance = new int[K][N];

            st = new StringTokenizer(br.readLine());

            for (int k = 0 ; k < K ; k++) {
                dijkstra(Integer.parseInt(st.nextToken()), k);
            }

            int minDistSum = INF;
            int roomNumber = 1;

            for (int i = 1 ; i <= N ; i++) {
                int sum = 0;
                for (int k = 0 ; k < K ; k++) {
                    sum += distance[k][i];
                }

                if (sum < minDistSum) {
                    roomNumber = i;
                    minDistSum = sum;
                }
            }

            System.out.println(roomNumber);
        }
    }

    public static void dijkstra (int start, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int [] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        boolean [] visit = new boolean[N + 1];

        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visit[node.d]) {
                visit[node.d] = true;
                for (Node next : edges.get(node.d)) {
                    if (dist[next.d] > dist[node.d] + next.cost) {
                        dist[next.d] = dist[node.d] + next.cost;
                        pq.add(new Node(next.d, dist[next.d]));
                    }
                }
            }
        }

        distance[k] = dist;
    }
}