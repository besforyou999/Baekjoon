import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int e, s, cost;
    Edge (int e, int s, int cost) {
        this.e = e;
        this.s = s;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e1) {
        return cost - e1.cost;
    }
}

class Star {
    int x, y, z;
    int number;
    Star(int x, int y, int z, int number) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.number = number;
    }
}

public class Main {
    public static int N;
    public static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parent[i] = i;
        }

        Star [] stars = new Star[N];

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            stars[i-1] = new Star(x, y, z, i);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        Arrays.sort(stars, (p1, p2) -> p1.x - p2.x);

        for (int i = 0 ; i < N - 1 ; i++) {
            int weight = Math.abs(stars[i].x - stars[i + 1].x);
            edges.add(new Edge(stars[i].number, stars[i + 1].number, weight));
        }

        Arrays.sort(stars, (p1, p2) -> p1.y - p2.y);

        for (int i = 0 ; i < N - 1 ; i++) {
            int weight = Math.abs(stars[i].y - stars[i + 1].y);
            edges.add(new Edge(stars[i].number, stars[i + 1].number, weight));
        }

        Arrays.sort(stars, (p1, p2) -> p1.z - p2.z);

        for (int i = 0 ; i < N - 1 ; i++) {
            int weight = Math.abs(stars[i].z - stars[i + 1].z);
            edges.add(new Edge(stars[i].number, stars[i + 1].number, weight));
        }

        Collections.sort(edges);
        int answer = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!hasSameParent(edge.e, edge.s)) {
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

    public static boolean hasSameParent(int x, int y) {
        return (find_root(x) == find_root(y)) ? true : false;
    }
}

