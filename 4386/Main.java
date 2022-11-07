import java.io.*;
import java.util.*;

class Edge {
    int e, s;
    double cost;
    Edge (int e, int s, double cost) {
        this.e = e;
        this.s = s;
        this.cost = cost;
    }
}

class Star {
    double x, y;
    int number;
    Star(double x, double y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

public class Main {
    public static int result [];
    public static ArrayList<Star> stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Edge> edges = new ArrayList<>();

        stars = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars.add(new Star(a, b, i));
        }

        for (int i = 0 ; i < N ; i++) {
            Star crit = stars.get(i);
            for (int j = 0 ; j < N ; j++) {
                if (i == j) continue;
                Star comp = stars.get(j);

                double dist = distance(crit, comp);
                edges.add(new Edge(crit.number, comp.number, dist));
            }
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.cost > o2.cost) {
                    return 1;
                } else if (o1.cost < o2.cost) {
                    return -1;
                } else
                    return 0;
            }
        });

        result = new int[N + 1];
        for (int i = 0 ; i <= N ; i++) {
            result[i] = i;
        }

        double answer = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!isSameParent(edge.e, edge.s)) {
                union(edge.e, edge.s);
                answer += edge.cost;
            }
        }

        answer = (Math.round(answer * 100) / 100.0);
        System.out.print(answer);
    }

    public static int find_root(int x) {
        if (x == result[x]) {
            return x;
        }
        return result[x] = find_root(result[x]);
    }

    public static void union(int x, int y) {
        x = find_root(x);
        y = find_root(y);

        if (x != y) {
            if (x < y ) {
                result[y] = x;
            } else {
                result[x] = y;
            }
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find_root(x);
        y = find_root(y);
        if (x == y) return true;
        return false;
    }

    public static double distance(Star a, Star b) {
        double a2 = Math.pow(a.x - b.x, 2);
        double b2 = Math.pow(a.y - b.y, 2);
        return Math.sqrt(a2 + b2);
    }
}

