import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int start, end;
    double cost;
    Edge(int s, int e, double c) {
        this.start = s;
        this.end = e;
        this.cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.cost, o.cost);
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

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        MakeSet();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            union(num1, num2);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0 ; i < N - 1; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                double dist = calcDist(p1, p2);
                edges.add(new Edge(i+1, j + 1, dist));
            }
        }

        Collections.sort(edges);

        double cost = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!sameParent(edge.start, edge.end)) {
                cost += edge.cost;
                union(edge.start, edge.end);
            }
        }

        System.out.printf("%.2f", cost);
    }

    static void MakeSet() {
        parent = new int[N + 1];
        for (int i = 1 ; i <= N ; i++) parent[i] = i;
    }

    static int findRoot(int x) {
        if (x == parent[x])
            return x;
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

    static double calcDist(Point p1, Point p2) {
        double d1 = Math.pow(p1.x - p2.x, 2);
        double d2 = Math.pow(p1.y - p2.y, 2);
        return Math.sqrt(d1 + d2);
    }
}
