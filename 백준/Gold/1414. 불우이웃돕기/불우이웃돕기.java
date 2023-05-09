import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int from, to, weight;

    Edge(int f, int t, int w) {
        this.from = f;
        this.to = t;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }
}

public class Main {
    static int N;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int n = 1 ; n <= N ; n++)
            parent[n] = n;

        char [][] map = new char[N][N];

        for (int i = 0 ; i < N ; i++)
            map[i] = br.readLine().toCharArray();

        int total = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                char val = map[i][j];
                if ('a' <= val && val <= 'z') {
                    total += val - 'a' + 1;
                    pq.add(new Edge(i + 1, j + 1, val - 'a' + 1));
                }
                else if ('A' <= val && val <= 'Z') {
                    total += val - 'A' + 27;
                    pq.add(new Edge(i + 1, j + 1, val - 'A' + 27));
                }
            }
        }

        int connected = 0;
        int used = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int fromRoot = findRoot(edge.from);
            int toRoot = findRoot(edge.to);

            int cost = edge.weight;

            if (fromRoot != toRoot) {
                used += cost;
                connected += 1;
                union(edge.from, edge.to);
            }
        }

        if (connected != N - 1) {
            System.out.println(-1);
        } else {
            System.out.println(total - used);
        }
    }

    static int findRoot(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = findRoot(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}