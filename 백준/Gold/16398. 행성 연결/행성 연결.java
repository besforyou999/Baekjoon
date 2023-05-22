import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start, end;
    long cost;

    Edge(int n, int e, long c) {
        this.start = n;
        this.end = e;
        this.cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(cost, o.cost);
    }
}

public class Main {
    static int N;
    static int [] parents;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parents[i] = i;
        }

        for (int n = 1 ; n <= N ; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m = 1 ; m <= N ; m++) {
                int weight = Integer.parseInt(st.nextToken());
                if (n == m)
                    continue;
                pq.add(new Edge(n, m, weight));
            }
        }

        int connections = 0;
        long total = 0;

        while (connections < N - 1) {

            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            long cost = edge.cost;

            if (!sameParent(start, end)) {
                union(start, end);
                connections += 1;
                total += cost;
            }
        }

        System.out.println(total);


    }

    static int findParent(int x) {
        if (x == parents[x])
            return x;
        else
            return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static boolean sameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

}