import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to;
    int weight;
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
    static int V, E;
    static ArrayList<Edge> list;
    static int parent[];
    public static void main(String[] args) throws IOException {

        list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int v = 1 ; v <= V ; v++) {
            parent[v] = v;
        }

        for (int v = 0 ; v < E ; v++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.add(new Edge(A, B, C));
        }

        Collections.sort(list);

        int cost = 0, connection = 0;

        for (Edge edge : list) {
            if (!sameParent(edge.from, edge.to)) {
                union(edge.from, edge.to);
                cost += edge.weight;
                connection++;
            }

            if (connection == V - 1) break;
        }

        System.out.println(cost);

    }

    static int findRoot(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = findRoot(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    static boolean sameParent(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}