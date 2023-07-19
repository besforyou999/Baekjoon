import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int [][] mat;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    static ArrayList<ArrayList<Point>> colisions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        mat = new int[N + 1][N + 1];

        for (int r = 1 ; r < N + 1 ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < N + 1 ; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int day = 0; day < 2000 ; day++) {

            colisions = new ArrayList<>();

            buildColision();

            if (colisions.size() == N * N)
                break;

            movePopulation();

            answer += 1;
        }

        System.out.println(answer);
    }

    public static void movePopulation() {
        for (ArrayList<Point> colision : colisions) {

            int total_population = 0;

            for (Point point : colision) {
                total_population += mat[point.r][point.c];
            }

            for (Point point : colision) {
                mat[point.r][point.c] = total_population / colision.size();
            }
        }
    }


    public static void buildColision() {

        boolean [][] visit = new boolean[N + 1][N + 1];

        for (int r = 1 ; r < N + 1 ; r++) {
            for (int c = 1 ; c < N + 1 ; c++) {
                if (!visit[r][c]) {
                    bfs(visit, r, c);
                }
            }
        }

    }
    public static void bfs(boolean[][] visit, int r, int c) {
        ArrayList<Point> colision = new ArrayList<>();
        colision.add(new Point(r, c));

        Queue<Point> points = new LinkedList<>();
        points.add(new Point(r, c));
        visit[r][c] = true;

        while (!points.isEmpty()) {
            Point point = points.poll();
            int pop1 = mat[point.r][point.c];

            for (int i = 0 ; i < 4 ; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                if (isIn(nr, nc) && !visit[nr][nc]) {
                    int pop2 = mat[nr][nc];
                    if (borderNeedsOpen(pop1, pop2)) {
                        visit[nr][nc] = true;
                        points.add(new Point(nr, nc));
                        colision.add(new Point(nr, nc));
                    }
                }
            }
        }

        colisions.add(colision);
    }

    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }

    public static boolean borderNeedsOpen(int country1, int country2) {
        int diff = Math.abs(country1 - country2);
        return (L <= diff && diff <= R);
    }
}

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}