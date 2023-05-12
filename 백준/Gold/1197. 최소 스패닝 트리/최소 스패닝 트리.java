import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int e, s;
    int weight;
    public Edge(int e, int s, int w) {
        this.e = e;
        this.s = s;
        this.weight = w;
    }
    @Override
    public int compareTo(Edge e1) {
        return this.weight - e1.weight;
    }
}

class Main {
    public static int V, E;
    public static int [] parent;
    public static ArrayList<Edge> edges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        parent = new int[V + 1];
        for (int i = 0 ; i < V + 1 ; i++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges);

        int cost = 0;
        for (Edge e : edges) {
            if (!sameParent(e.e, e.s)) {
                union(e.e, e.s);
                cost += e.weight;
            }
        }
        System.out.print(cost);
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
            } else
                parent[x] = y;
        }
    }

    public static boolean sameParent(int x, int y) {
        return find_root(x) == find_root(y);
    }
}
