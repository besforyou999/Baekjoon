import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static final int MAX_LEN = 200;
    static final int MAX = 10001;

    static int dr[] = {0, -1, -1, 0, 1, 1, 1};
    static int dc[] = {1, 1, 0, -1, -1, 0};

    static int numberUsed[] = {0, 0, 0, 0, 0, 0}; // 인덱스 0은 사용 안함

    static int mat[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int startR = MAX_LEN / 2;
        final int startC = MAX_LEN / 2;

        mat = new int[MAX_LEN + 1][MAX_LEN + 1];

        ArrayList<Integer> dx = new ArrayList<>();

        int loop = 1;
        int prevDir = 0;
        for (int i = 0 ; i < MAX ; i++) {
            int nextDir = i % 6;
            if (prevDir == 5 && nextDir == 0) {
                loop += 1;
            }

            if (nextDir == 1) {
                for (int l = 0; l < loop - 1; l++) {
                    dx.add(nextDir);
                }
            } else {
                for (int l = 0; l < loop; l++) {
                    dx.add(nextDir);
                }
            }
            prevDir = nextDir;
        }

        int r = startR;
        int c = startC;
        mat[r][c] = 1;
        numberUsed[1] += 1;

        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(1);

        for (int i = 0 ; i < MAX ; i++) {
            int dir = dx.get(i);

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isIn(nr, nc)) {
                int nextInt = getNextNumber(nr, nc);
                answers.add(nextInt);
                mat[nr][nc] = nextInt;
                numberUsed[nextInt] += 1;
                r = nr;
                c = nc;
            }
        }


        int C = Integer.parseInt(br.readLine());

        for (int test_case = 0 ; test_case < C ; test_case++) {

            int N = Integer.parseInt(br.readLine());

            if (N <= 1) {
                System.out.println(N);
            } else {
                System.out.println(answers.get(N - 1));
            }
        }

    }

    static int getNextNumber(int r, int c) {

        // 조건 1. 인접한 타일과는 다른 자원
        boolean [] used = new boolean[6];
        for (int i = 0 ; i < 6 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc)) {
                int val = mat[nr][nc];
                used[val] = true;
            }
        }

        // 주변에서 안 쓰인 숫자
        ArrayList<Integer> unusedNumber = new ArrayList<>();
        for (int i = 1 ; i < used.length ; i++) {
            if (!used[i]) unusedNumber.add(i);
        }

        // 조건 2. 보드에서 가장 적게 나타난 자원
        int minUsed = Integer.MAX_VALUE;
        int minUsedNumber = unusedNumber.get(0);
        for (int num : unusedNumber) {
            int usedCnt = numberUsed[num];
            if (minUsed > usedCnt) {
                minUsed = usedCnt;
                minUsedNumber = num;
            }
        }

        // 조건 3. 가장 적게 나타난 자원이 여러 개이면 번호가 작은 거 반환하면 됨.
        return minUsedNumber;
    }

    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= MAX_LEN && c >= 1 && c <= MAX_LEN);
    }
}