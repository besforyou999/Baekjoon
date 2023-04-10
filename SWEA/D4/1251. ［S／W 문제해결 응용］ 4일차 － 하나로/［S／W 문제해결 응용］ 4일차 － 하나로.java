import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start, end;
    double weight;

    public Edge(int s, int e, double w) {
        this.start = s;
        this.end = e;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}

public class Solution {
    static int [][] points;
    static double [][] weights;

    static int [] parent, rank;

    static double E;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testcase = 1 ; testcase <= T ; testcase++) {
            N = Integer.parseInt(br.readLine());

            points = new int[N + 1][2];
            weights = new double[N + 1][N + 1];

            for (int i = 0 ; i < 2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= N ; j++) {
                    points[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            E = Double.parseDouble(br.readLine());

            makeSet();
            makeWeights();
            long result = (long)Math.round(kruskal());
            sb.append("#").append(testcase).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    static void makeSet() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1 ; i <= N ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static int findRoot(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = findRoot(parent[x]);
        }
    }

    static boolean union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x == y) {
            return false;
        } else {
            if (rank[x] >= rank[y]) {
                rank[x]++;
                parent[y] = x;
            } else {
                rank[y]++;
                parent[x] = y;
            }
            return true;
        }
    }

    static void makeWeights() {
        for (int r = 1 ; r <= N ; r++) {
            for (int c = 1 ; c <= N ; c++) {
                weights[r][c] = distance(points[r], points[c]);
            }
        }
    }

    static double distance(int [] point1, int [] point2) {
        double xx = Math.pow(point1[0] - point2[0], 2);
        double yy = Math.pow(point1[1] - point2[1], 2);
        return (xx + yy) * E;
    }

    static double kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int r = 1 ; r <= N ; r++)
            for (int c = 1 ; c <= N ; c++)
                pq.add(new Edge(r, c, weights[r][c]));

        double answer = 0;
        int cnt = 0;

        while (cnt < N - 1) {
            Edge edge = pq.poll();
            if (union(edge.start, edge.end)) {
                answer += edge.weight;
                cnt++;
            }
        }

        return answer;
    }
}