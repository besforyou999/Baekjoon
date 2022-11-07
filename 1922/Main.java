import java.io.*;
import java.util.*;

class Edge {
    int e, s, cost;
    Edge(int e, int s, int cost) {
        this.e = e;
        this.s = s;
        this.cost = cost;
    }
}

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Edge> edges = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        int answer = 0;

        for (int i = 0 ; i < M ; i++) {
            Edge edge = edges.get(i);
            if (!sameParent(edge.e, edge.s)) {
                union(edge.e, edge.s);
                answer += edge.cost;
            }
        }
        System.out.print(answer);
    }

    public static int find_root(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find_root(parent[x]);
    }

    public static void union(int x, int y) {
        x = find_root(x);
        y = find_root(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static boolean sameParent(int x, int y) {
        x = find_root(x);
        y = find_root(y);
        if (x == y) return true;
        return false;
    }
}

