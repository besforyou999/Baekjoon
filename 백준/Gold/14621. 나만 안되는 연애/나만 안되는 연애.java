import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge {
    int start, end, weight;
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static int [] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [] university = new char[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            university[i] = st.nextToken().charAt(0);
        }

        edgeList = new ArrayList<>();

        for (int e = 0 ; e < M ; e++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(A, B, C));
        }

        parent = new int[N + 1];
        for (int i = 1 ; i < N + 1 ; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);

        int cnt = 0, ans = 0;

        for (int i = 0 ; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) != find(edge.end)) {
                if (university[edge.start] != university[edge.end]) {
                    cnt++;
                    ans += edge.weight;

                    union(edge.start, edge.end);
                }
            }
        }

        System.out.println( (cnt != N - 1 ? -1 : ans));
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}