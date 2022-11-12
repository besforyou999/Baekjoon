import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    double dist;
    public Edge(int n, double d) {
        this.node = n;
        this.dist = d;
    }

    @Override
    public int compareTo(Edge e1) {
        return Double.compare(dist, e1.dist);
    }
}

class Star {
    double x, y;
    public Star(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N;
    public static Star stars [];
    public static ArrayList<ArrayList<Edge>> graph;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stars = new Star[N];
        graph = new ArrayList<>();
        for (int i = 0 ; i < N ; i++) {
            graph.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
        }

        for (int i = 0 ; i < N ; i++) {
            Star one = stars[i];
            for (int j = 0 ; j < N ; j++) {
                if (i == j) continue;
                Star two = stars[j];
                double dist = distance(one, two);
                graph.get(i).add(new Edge(j, dist));
                graph.get(j).add(new Edge(i, dist));
            }
        }

        double ans = Math.round( ( prim(0) * 100 ) )/ 100.0 ;
        System.out.print(ans);
    }

    public static double distance(Star s1, Star s2) {
        double x = Math.pow(s1.x - s2.x, 2);
        double y = Math.pow(s1.y - s2.y, 2);
        return Math.sqrt(x + y);
    }

    public static double prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visit[] = new boolean[N];
        pq.add(new Edge(start, 0));
        Edge e;
        double cost = 0;

        while(!pq.isEmpty()) {
            e = pq.remove();
            if (!visit[e.node]) {
                visit[e.node] = true;
                cost += e.dist;
                for (Edge next : graph.get(e.node)) {
                    if (!visit[next.node]) {
                        pq.add(next);
                    }
                }
            }
        }
        return cost;
    }
}

