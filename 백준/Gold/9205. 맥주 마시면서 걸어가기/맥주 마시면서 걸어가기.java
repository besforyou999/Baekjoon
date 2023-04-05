import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int r, c, num;
    Point(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}

public class Main {

    static final String HAPPY = "happy";
    static final String SAD = "sad";

    static Point start;
    static Point end;

    static int n;

    static ArrayList<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {

            n = Integer.parseInt(br.readLine());

            points = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            start = new Point(r, c, 0);

            for (int i = 1 ; i <= n ; i++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                points.add(new Point(r, c, i));
            }

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            end = new Point(r, c, n + 1);
            points.add(end);

            boolean result = bfs();
            if (result) {
                System.out.println(HAPPY);
            } else
                System.out.println(SAD);
        }
    }

    static boolean bfs() {

        boolean [] visit = new boolean[n + 2];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(Point nextPoint : points) {
                if (!visit[nextPoint.num] && distance(point, nextPoint) <= 1000) {
                    visit[nextPoint.num] = true;
                    queue.add(nextPoint);
                }
            }
        }
        return visit[n + 1];
    }

    static int distance(Point p1, Point p2) {
        return distance_between_to_num(p1.r, p2.r) + distance_between_to_num(p1.c, p2.c);
    }

    static int distance_between_to_num(int n1, int n2) {
        if (n1 > 0 && n2 > 0) return Math.abs(n1 - n2);
        else if (n1 > 0 && n2 < 0) return n1 - n2;
        else if (n1 < 0 && n2 > 0) return n2 - n1;
        else
            return Math.abs(n1 - n2);
    }
}