import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int e, s;
    double cost;
    Edge (int e, int s, double cost) {
        this.e = e;
        this.s = s;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e1) {
        if (this.cost > e1.cost) {
            return 1;
        } else if (this.cost < e1.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Point {
    int x, y, number;
    Point(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.number = n;
    }
}

public class Main {
    public static int N, M;
    public static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Edge> edges = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Point [] points = new Point[N + 1];

        parent = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parent[i] = i;
        }

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y, i);
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            union(one, two);
        }

        for (int i = 1 ; i <= N ; i++) {
            Point p1 = points[i];
            for (int j = 1 ; j <= N ; j++) {
                if (i == j) continue;
                if (sameParent(i, j)) continue;
                Point p2 = points[j];
                double distance = getDistance(p1, p2);
                edges.add(new Edge(i, j, distance));
            }
        }

        Collections.sort(edges);
        double ans = 0;
        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!sameParent(edge.e, edge.s)) {
                ans += edge.cost;
                union(edge.e, edge.s);
            }
        }

        System.out.print(String.format("%.2f", ans));
    }

    public static int find_root(int x) {
        if (x == parent[x]) return x;
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
        return find_root(x) == find_root(y);
    }

    public static double getDistance(Point p1, Point p2) {
        double x = Math.pow((p1.x - p2.x), 2);
        double y = Math.pow((p1.y - p2.y), 2);
        return Math.sqrt(x + y);
    }
}
