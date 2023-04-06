import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Move {
    int time, dir;
    Move(int t, int d) {
        this.time = t;
        this.dir = d;
    }
}

public class Main {
    static int N;
    static int mat [][];
    // 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위
    static int dr [] = {0, 1, 0, -1};
    static int dc [] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());

        for (int k = 0 ; k < K ; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mat[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> spinDirection = new HashMap<>();

        for (int l = 0 ; l < L ; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            int dir = 0;
            if (direction.equals("L")) dir = 1;

            spinDirection.put(time, dir);
        }

        Set<Integer> keys = spinDirection.keySet();

        int snakeDirection = 0, time = 0;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {1, 1});

        mat[1][1] = 9;

        while (true) {

            int [] head = deque.peekFirst();

            int nr = head[0] + dr[snakeDirection];
            int nc = head[1] + dc[snakeDirection];

            if (!isIn(nr, nc)) break;

            int val = mat[nr][nc];

            if (val == 0) { // 다음 칸이 빈칸
                mat[nr][nc] = 9;
                deque.addFirst(new int[] {nr, nc});

                int [] tail = deque.pollLast();
                mat[tail[0]][tail[1]] = 0;
            } else if (val == 1) { // 다음 칸이 사과
                mat[nr][nc] = 9;
                deque.addFirst(new int[] {nr, nc});
            } else if (val == 9) { // 다음 칸이 자기 자신
                break;
            }

            time += 1;

            if (keys.contains(time)) {
                int spin = spinDirection.get(time);
                if (spin == 0) {
                    snakeDirection += 1;
                    if (snakeDirection == 4) snakeDirection = 0;
                } else {
                    snakeDirection -= 1;
                    if (snakeDirection < 0) snakeDirection = 3;
                }
            }

            //print();
            //System.out.println("time : " + time);
        }

        System.out.println(time + 1);
    }

    static void print() {
        for (int r = 1 ; r <= N ; r++) {
            for (int c= 1 ; c <= N ; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
    }




    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }
}