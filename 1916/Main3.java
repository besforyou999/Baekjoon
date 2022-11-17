import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    int weight;
    public Edge(int n, int w) {
        this.node = n;
        this.weight = w;
    }
    @Override
    public int compareTo(Edge e1) {
        return this.weight - e1.weight;
    }
}

public class Main {
    public static int N, M;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> adj [] = new PriorityQueue[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            adj[i] = new PriorityQueue<>();
        }

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[start].add(new Edge(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int [] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        while (!adj[start].isEmpty()) {
            Edge e = adj[start].poll();
            int n = e.node;
            int w = e.weight;
            if (distance[n] != -1) continue;
            distance[n] = w;
            for (Edge next : adj[n]) {
                adj[start].add(new Edge(next.node, next.weight + w));
            }
        }

        System.out.print(distance[end]);
    }
}

