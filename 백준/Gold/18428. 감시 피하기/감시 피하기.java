import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

/**
 * [키워드]
 * 상, 하, 좌, 우 4가지 방향 - bfs 탐색
 * 빈 칸 중에 설치할 위치를 골라, 정확히 3개의 장애물 설치해야함 - 조합
 * [풀이과정]
 * 1. 빈칸의 좌표, 선생님 좌표, 학생 좌표만 따로 모아 저장
 * 2. 좌표들 중 3개를 순서 상관없이 선택하여 장애물을 설치하고 선생님 위치에서 BFS 탐색
 * 3. 모든 S 위치에 닿을 수 없다면 "YES" 출력하고 프로그램 종료
 * 3. 어떠한 경우에도 S 위치에 닿지않게 할 수 없다면 "NO" 출력하고 종료
 * [입력]
 * 3 <= N <= 6
 * 첫 줄 : N
 * N 개의 행, N개의 원소 주어짐
 * [출력]
 * YES 혹은 NO
 * @author besforyou
 * @see
 * @performance
 * @category #그래프, #BFS
 */


public class Main {

    static int [][] delta = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    static int N;
    static char [][] mat;
    static ArrayList<Point> XPoints;
    static ArrayList<Point> students;
    static ArrayList<Point> teachers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new char[N][N];

        for (int i  = 0 ; i < N ; i++)
            for (int j = 0 ; j < N ; j++)
                mat[i][j] = 'X';

        XPoints = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                char ch = st.nextToken().charAt(0);
                mat[r][c] = ch;
                if (ch == 'X')
                    XPoints.add(new Point(r, c));
                else if (ch == 'S')
                    students.add(new Point(r, c));
                else
                    teachers.add(new Point(r, c));
            }
        }

        int [] numbers = new int[XPoints.size()];
        for (int i = 0 ; i < numbers.length ; i++) numbers[i] = i;

        back(new boolean[numbers.length], 0, 0, numbers);

        System.out.println("NO");
    }

    static void back(boolean [] used, int start, int depth, int [] numbers) {
        if (depth == 3) {
            int [] objects = new int[3];
            int idx = 0;
            for (int i = 0 ; i < used.length ; i++) {
                if (used[i]) {
                    objects[idx] = i;
                    idx += 1;
                }
            }

            if (AllHidden(objects)) {
                System.out.println("YES");
                System.exit(0);
            }

            return;
        }

        for (int i = start ; i < used.length ; i++) {
            used[i] = true;
            back(used, i + 1, depth + 1, numbers);
            used[i] = false;
        }
    }

    static char[][] copyMat() {
        char [][] tmp = new char[N][N];
        for (int r = 0 ; r < N ; r++)
            for (int c = 0 ; c < N ; c++)
                tmp[r][c] = mat[r][c];
        return tmp;
    }

    static boolean AllHidden(int [] objects) {

        char [][] map = copyMat();
        boolean [][] visit = new boolean[N][N];

        for (int idx : objects) {
            Point point = XPoints.get(idx);
            map[point.r][point.c] = 'O';
        }

        Queue<Sight> queue = new LinkedList<>();
        for (Point point : teachers) {
            for (int dir = 0; dir < 4; dir++) {
                queue.add(new Sight(point.r, point.c, dir));
                visit[point.r][point.c] = true;
            }
        }

        while (!queue.isEmpty()) {
            Sight sight = queue.poll();
            int r = sight.r;
            int c = sight.c;
            int dir = sight.direction;

            int nr = r + delta[dir][0];
            int nc = c + delta[dir][1];

            if (isIn(nr, nc)) {
                if (map[nr][nc] == 'S') return false;
                if (map[nr][nc] == 'X' || map[nr][nc] == 'T') {
                    visit[nr][nc] = true;
                    queue.add(new Sight(nr, nc, dir));
                }
            }
        }

        return true;
    }

    static class Sight {
        int r, c, direction;
        Sight(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.direction = dir;
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }
}