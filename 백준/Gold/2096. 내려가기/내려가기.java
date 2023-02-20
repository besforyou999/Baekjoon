import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
    int low;
    int high;
    Point() {
        low = 0;
        high = 0;
    }
    Point(int l, int h) {
        this.low = l;
        this.high = h;
    }
}

public class Main {

    static Point points[][];
    static int mat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        mat = new int[3][N + 1];
        points = new Point[3][N + 1];

        points[0][0] = new Point();
        points[1][0] = new Point();
        points[2][0] = new Point();

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mat[0][i] = Integer.parseInt(st.nextToken());
            mat[1][i] = Integer.parseInt(st.nextToken());
            mat[2][i] = Integer.parseInt(st.nextToken());

            points[0][i] = new Point();
            points[1][i] = new Point();
            points[2][i] = new Point();
        }

        for (int i = 1 ; i <= N ; i++) {
            points[0][i].high = mat[0][i] + Math.max(points[0][i-1].high, points[1][i-1].high);
            points[1][i].high = mat[1][i] + maximum(points[0][i-1].high, points[1][i-1].high, points[2][i-1].high);
            points[2][i].high = mat[2][i] + Math.max(points[1][i-1].high, points[2][i-1].high);

            points[0][i].low = mat[0][i] + Math.min(points[0][i-1].low, points[1][i-1].low);
            points[1][i].low = mat[1][i] + minimum(points[0][i-1].low, points[1][i-1].low, points[2][i-1].low);
            points[2][i].low = mat[2][i] + Math.min(points[1][i-1].low, points[2][i-1].low);
        }

        int MAX = maximum(points[0][N].high, points[1][N].high, points[2][N].high);
        int MIN = minimum(points[0][N].low, points[1][N].low, points[2][N].low);

        System.out.println(MAX + " " + MIN);
    }

    static int maximum(int a, int b, int c) {
        int tmp = Math.max(a, b);
        return Math.max(tmp, c);
    }

    static int minimum(int a, int b, int c) {
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }
    
}