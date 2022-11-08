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

public class Main {
    public static int N, M;
    public static int parent[];
    public static int matrix[][];
    public static boolean visited[][];
    public static int dx [] = {-1, 1, 0, 0};
    public static int dy [] = {0, 0, -1, 1};
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int island = 1;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j, island++);
                }
            }
        }

        island -= 1;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (matrix[i][j] != 0) {
                    buildEdges(i, j);
                }
            }
        }

        Collections.sort(edges);

        parent = new int[island + 1];
        for (int i = 0 ; i <= island ; i++) {
            parent[i] = i;
        }

        int answer = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            Edge edge = edges.get(i);
            if (!hasSameParent(edge.e, edge.s)) {
                union(edge.e, edge.s);
                answer += edge.cost;
            }
        }

        int firstRoot = parent[1];
        for (int i = 2 ; i <= island ; i++) {
            if (firstRoot != find_root(parent[i])) {
                answer = -1;
                break;
            }
        }

        System.out.print(answer);
    }

    public static void buildEdges(int row, int col) {
        int originIslandNumber = matrix[row][col];

        for (int i = 0 ; i < 4 ; i++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {row, col, 0});

            while (!queue.isEmpty()) {
                int [] tmp = queue.poll();
                int r = tmp[0];
                int c = tmp[1];
                int move = tmp[2];

                int nr = r + dy[i];
                int nc = c + dx[i];

                if (nr < 0 || nc < 0 || nc >= M || nr >= N) continue;
                if (matrix[nr][nc] == originIslandNumber) continue;
                if (matrix[nr][nc] != 0) {
                    if (move > 1) {
                        edges.add(new Edge(originIslandNumber, matrix[nr][nc], move));
                        break;
                    }
                } else {
                    queue.add(new int[] {nr, nc, move + 1});
                }
            }
        }
    }
    // x == row, y == col
    public static void bfs(int row, int col, int number) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;
        matrix[row][col] = number;

        while (!queue.isEmpty()) {
            int []p = queue.poll();
            int pr = p[0];
            int pc = p[1];
            for (int i = 0 ; i < 4 ; i++) {
                int nr = pr + dy[i];
                int nc = pc + dx[i];
                if (nr < 0 || nc < 0 || nc >= M || nr >= N) continue;

                if (matrix[nr][nc] == 1 && visited[nr][nc] == false) {
                    visited[nr][nc] = true;
                    matrix[nr][nc] = number;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
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

