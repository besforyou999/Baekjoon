import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start, end, cost;
    Edge(int s, int e, int c) {
        this.start = s;
        this.end = e;
        this.cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class Main {
    static int m, n;

    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            MakeSet();

            ArrayList<Edge> edges = new ArrayList<>();

            int totalZ = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                totalZ += z;
                edges.add(new Edge(x, y, z));
            }

            Collections.sort(edges);

            int sum = 0;

            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (!sameParent(edge.start, edge.end)) {
                    union(edge.start, edge.end);
                    sum += edge.cost;
                }
            }

            System.out.println(totalZ - sum);
        }
    }

    static void MakeSet() {
        parent = new int[m + 1];
        for (int i = 1 ; i <= m ; i++) parent[i] = i;
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
