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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Node> [] adj = new PriorityQueue[N+1];
        for (int i = 1; i <= N ; i++) {
            adj[i] = new PriorityQueue<Node>();
        }

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //시작점에서 다른 정점으로의 최단 경로 구하기
        int [] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        while (!adj[start].isEmpty()) {
            Node tmp = adj[start].poll();
            int to = tmp.to;
            int weight = tmp.weight;
            if (distance[to] == -1) {
                distance[to] = weight;
                for (Node n : adj[to]) {
                    adj[start].add(new Node(n.to, n.weight + weight));
                }
            }
        }
        System.out.print(distance[end]);
    }
}

