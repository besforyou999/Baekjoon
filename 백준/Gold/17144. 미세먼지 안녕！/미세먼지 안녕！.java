import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, T;
    static int [][] map;
    static Point [] airCleaner = new Point[2];

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        int airIdx = 0;
        for (int r = 1 ; r < R + 1 ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1 ; c < C + 1 ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1)
                    airCleaner[airIdx++] = new Point(r, c);
            }
        }

        for (int t = 0 ; t < T ; t++) {
            // 1. 먼지 확산
            spreadDust();
            // 2. 윗 공기 순환
            airCirculationTop();
            // 3. 아래 공기 순환
            airCirculationDown();
        }

        System.out.println(getDust());
    }

    public static int getDust() {
        int sum = 0;
        for (int r = 1 ; r < R + 1 ; r++) {
            for (int c = 1; c < C + 1; c++) {
                if (map[r][c] != -1) {
                    sum += map[r][c];
                }
            }
        }
        return sum;
    }

    public static void airCirculationTop() {
        ArrayList<Point> circulationRoute = new ArrayList<>();

        int r = airCleaner[0].r;
        int c = airCleaner[0].c + 1;

        while (c < C + 1) {
            circulationRoute.add(new Point(r, c));
            c++;
        }

        c -= 1;
        r -= 1;

        while (r >= 1) {
            circulationRoute.add(new Point(r, c));
            r--;
        }

        r += 1;
        c -= 1;

        while (c >= 1) {
            circulationRoute.add(new Point(r, c));
            c -= 1;
        }

        c += 1;

        while (r < airCleaner[0].r) {
            circulationRoute.add(new Point(r, c));
            r++;
        }

        int len = circulationRoute.size();

        for (int i = len - 1 ; i >= 1 ; i--) {
            Point dest = circulationRoute.get(i);
            Point src = circulationRoute.get(i - 1);
            map[dest.r][dest.c] = map[src.r][src.c];
        }

        Point start = circulationRoute.get(0);
        map[start.r][start.c] = 0;

    }

    public static void airCirculationDown() {
        ArrayList<Point> circulationRoute = new ArrayList<>();
        int r = airCleaner[1].r;
        int c = airCleaner[1].c + 1;

        while (c < C + 1) {
            circulationRoute.add(new Point(r, c));
            c++;
        }

        c -= 1;
        r += 1;

        while (r < R + 1) {
            circulationRoute.add(new Point(r, c));
            r++;
        }

        r -= 1;
        c -= 1;

        while (c >= airCleaner[1].c) {
            circulationRoute.add(new Point(r, c));
            c--;
        }

        r -= 1;
        c += 1;

        while (r > airCleaner[1].r) {
            circulationRoute.add(new Point(r, c));
            r--;
        }

        int len = circulationRoute.size();

        for (int i = len - 1 ; i >= 1 ; i--) {
            Point dest = circulationRoute.get(i);
            Point src = circulationRoute.get(i - 1);
            map[dest.r][dest.c] = map[src.r][src.c];
        }

        Point start = circulationRoute.get(0);
        map[start.r][start.c] = 0;
    }

    public static void spreadDust() {

        int [][]rec = new int[R + 1][C + 1];

        for (int r = 1 ; r < R + 1 ; r++) {
            for (int c = 1 ; c < C + 1 ; c++) {
                int Arc = map[r][c];
                int spreadCnt = 0;
                for (int i = 0 ; i < 4 ; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (isIn(nr, nc) && map[nr][nc] != -1) {
                        spreadCnt += 1;
                        rec[nr][nc] += Arc / 5;
                    }
                }

                rec[r][c] += Arc - (Arc/ 5) * spreadCnt;
            }
        }

        for (int r = 1 ; r < R + 1 ; r++) {
            for (int c = 1 ; c < C + 1 ; c++) {
                map[r][c] = rec[r][c];
            }
        }

    }

    public static boolean isIn(int r, int c) {
        return ( r >= 1 && r <= R && c >= 1 && c <= C);
    }

}