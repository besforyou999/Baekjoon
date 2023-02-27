import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snail {
    int r, c, direction, number; // 동 남 서 북
    Snail(int r, int c) {
        this.r = r;
        this.c = c;
        this.direction = 0;
        this.number = 1;
    }

    void spin() {
        direction += 1;
        if (direction == 4) direction = 0;
    }

    void setNextPos(int nr, int nc) {
        this.r = nr;
        this.c = nc;
    }

    void increaseNum() {
        this.number += 1;
    }
}

public class Main {
    static int C, R, K;
    static int [][] mat;

    static int ansR, ansC;

    public static int dc[] = {0, 1, 0, -1};
    public static int dr[] = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        if (C * R < K) {
            System.out.println(0);
            return;
        }

        mat = new int[R + 1][C + 1];

        snail();

        System.out.println(ansC + " " + (R - ansR + 1));
    }

    public static void snail() {
        Queue<Snail> queue = new LinkedList<>();
        queue.add(new Snail(R, 1));

        while (!queue.isEmpty()) {
            Snail snail = queue.poll();

            mat[snail.r][snail.c] = snail.number;
            if (snail.number >= K) {
                ansR = snail.r;
                ansC = snail.c;
                break;
            }
            int dir = snail.direction;
            int nr = snail.r + dr[dir];
            int nc = snail.c + dc[dir];

            if (!isIn(nr, nc) || mat[nr][nc] != 0) {
                snail.spin();
                queue.add(snail);
            } else if (mat[nr][nc] == 0){
                snail.setNextPos(nr, nc);
                snail.increaseNum();
                queue.add(snail);
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= R && c >= 1 && c <= C);
    }
}