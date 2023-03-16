import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start, end, cost;
    Edge(int s, int e, int c) {
        start = s;
        end = e;
        cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class Main {
    static int N, M;

    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MakeSet();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int cost = 0;
        int max_edge = -1;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!sameParent(edge.start, edge.end)) {
                union(edge.start, edge.end);
                cost += edge.cost;
                if (edge.cost > max_edge) max_edge = edge.cost;
            }
        }

        System.out.println(cost - max_edge);
    }

    static void MakeSet() {
        parent = new int[N + 1];
        for (int i = 1 ; i <= N ; i++) parent[i] = i;
    }

    static int findRoot(int x) {
        if (x == parent[x]) return x;
        else
            return parent[x] = findRoot(parent[x]);
    }

    static boolean union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x == y) {
            return false;
        } else {
            if (x < y) {
                parent[y] = x;
            } else
                parent[x] = y;
            return true;
        }
    }

    static boolean sameParent(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}