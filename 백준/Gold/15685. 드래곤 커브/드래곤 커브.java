import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int MAX = 101;
    static int N;

    static int dr[] = {0, -1, 0, 1};
    static int dc[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int mat [][] = new int[MAX][MAX];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            mat[y][x] = 1;

            Point endPoint = getEndPoint(new Point(y, x), d);

            mat[endPoint.r][endPoint.c] = 1;

            ArrayList<Integer> directions = new ArrayList<>();
            directions.add(d);

            for (int j = 1 ; j <= g ; j++) {
                int size = directions.size();
                for (int l = size - 1 ; l >= 0 ; l--) {
                    int dir = directions.get(l);
                    dir = getNextDir(dir);
                    endPoint.r += dr[dir];
                    endPoint.c += dc[dir];
                    mat[endPoint.r][endPoint.c] = 1;
                    directions.add(dir);
                }
            }
        }

        int ans = 0;

        for (int r = 0 ; r < MAX - 1 ; r++) {
            for (int c = 0 ; c < MAX - 1 ; c++) {
                if (mat[r][c] == 1) {
                    int cnt = 0;
                    cnt += mat[r + 1][c];
                    cnt += mat[r][c + 1];
                    cnt += mat[r + 1][c + 1];
                    if (cnt == 3) ans += 1;
                }
            }
        }

        System.out.println(ans);
    }

    public static Point getEndPoint(Point start, int d) {
        int nr = start.r + dr[d];
        int nc = start.c + dc[d];
        return new Point(nr, nc);
    }

    public static int getNextDir(int d) {
        d += 1;
        if (d > 3) d = 0;
        return d;
    }
}