import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int start, end, cost;
    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main {

    static int N, M, K;
    static int [] parent;
    static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        init();

        // 모든 발전소 -1
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        edges = new ArrayList<>();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, c));
        }

        edges.sort((e1, e2) -> e1.cost - e2.cost);

        long cost = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);

            if (!sameParent(edge.start, edge.end)) {
                cost += edge.cost;
                union(edge.start, edge.end);
            }

            if (allConnectedToPowerplant()) break;
        }

        System.out.print(cost);
    }

    public static boolean allConnectedToPowerplant() {
        for (int i = 1 ; i <= N ; i++) {
            if (find(i) != -1) return false;
        }
        return true;
    }

    public static void init() {
        parent = new int[N + 1];
        for (int n = 0 ; n < N + 1 ; n++) {
            parent[n] = n;
        }
    }

    public static int find (int x) {
        if (parent[x] == -1) return -1;
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static boolean sameParent(int x, int y) {
        return find(x) == find(y);
    }
}