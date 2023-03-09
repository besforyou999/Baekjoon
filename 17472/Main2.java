import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int start, end, cost;
    Edge(int s, int e, int c) {
        this.start = s;
        this.end = e;
        this.cost = c;
    }
}

public class Main {
    static int N, M;
    static int [][] mat;
    static boolean [][] visit;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N][M];
        visit = new boolean[N][M];

        for (int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int island = 1;

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++) {
                int val = mat[r][c];
                if (val == 1 && !visit[r][c]) bfs(r, c, island++);
            }
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++) {
                if (mat[r][c] != 0) buildEdges(r, c, edges);
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        MakeSet(island);

        int cost = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!sameParent(edge.start, edge.end)) {
                union(edge.start, edge.end);
                cost += edge.cost;
            }
        }

        for (int i = 2 ; i < island ; i++) {
            if (!sameParent(1, i)) {
                cost = -1;
                break;
            }
        }

        System.out.println(cost);
    }

    static void MakeSet(int island) {
        parent = new int[island];
        for (int i = 0 ; i < island ; i++) parent[i] = i;
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

    static void buildEdges(int r, int c, ArrayList<Edge> edges) {
        int originIslandNum = mat[r][c];

        for (int d = 0 ; d < 4 ; d++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{r, c, 0});

            while (!queue.isEmpty()) {
                int[] coord = queue.poll();
                int nr = coord[0] + dr[d];
                int nc = coord[1] + dc[d];
                int cost = coord[2];

                if (isIn(nr, nc)) {
                    if (mat[nr][nc] == 0) {
                        queue.add(new int[]{nr, nc, cost + 1});
                    } else if (mat[nr][nc] > 0 && mat[nr][nc] != originIslandNum) {
                        if (cost > 1) {
                            edges.add(new Edge(originIslandNum, mat[nr][nc], cost));
                        }
                        break;
                    }
                }
            }
        }

    }

    static void bfs(int r, int c, int island) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        visit[r][c] = true;
        mat[r][c] = island;

        while(!queue.isEmpty()) {
            int coord [] = queue.poll();
            int cr = coord[0];
            int cc = coord[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (isIn(nr, nc)) {
                    if (!visit[nr][nc] && mat[nr][nc] != 0) {
                        visit[nr][nc] = true;
                        mat[nr][nc] = island;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }
}
