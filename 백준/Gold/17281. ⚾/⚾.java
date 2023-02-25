import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int playersRecord[][];
    static int ANS = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        playersRecord = new int[N][10];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= 9 ; j++)
                playersRecord[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean [] used = new boolean[8];
        int [] players = {2, 3, 4, 5, 6, 7, 8, 9};

        permutation(used, players, new int[8], 0, 8);
        System.out.println(ANS);
        //System.out.println(cnt);
    }


    static void permutation(boolean [] used, int [] players, int [] order, int depth, int r) {
        if (depth == r) {
            int [] realOrder = buildRealOrder(order);
            simulation(realOrder);
            cnt++;
            return;
        }

        for (int i = 0 ; i < players.length ; i++) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = players[i];
                permutation(used, players, order, depth + 1, r);
                used[i] = false;
            }
        }
    }

    static int[] buildRealOrder(int [] order) {
        int [] realOrder = new int[9];

        for (int i = 0 ; i <= 2 ; i++) realOrder[i] = order[i]; // 1, 2, 3번 타자

        realOrder[3] = 1; // 4번 타자

        for (int i = 4 ; i < 9 ; i++) realOrder[i] = order[i - 1]; // 5 ~ 9번 타자

        return realOrder;
    }

    static void simulation(int [] order) {
        boolean [] base = new boolean[3]; //  1 : 1루, 2 : 2루, 3 : 3루
        int outs = 0, score = 0, ening = 0, player = 0;

        while (ening < N) {
            int taja = order[player];
            int result = playersRecord[ening][taja];

            //System.out.println("taja : result");
            //System.out.println(taja + " " + result);

            if (result == 0) {
                outs += 1;
            } else if (result > 0 ) {
                //System.out.println("dubgg");
                score += buildNextStatus(base, result);
            }

            player++;
            if (player >= order.length) player = 0;


            if (outs == 3) {
                ening++;
                Arrays.fill(base, false);
                outs = 0;
            }
        }

        ANS = Math.max(ANS, score);
    }

    static int buildNextStatus(boolean [] base, int hit) {
        if (hit == 4) {
            int cnt = 0;
            for (int i = 0 ; i < base.length ; i++) {
                if (base[i]) cnt++;
            }
            Arrays.fill(base, false);
            return cnt + 1; // 출루한 선수 + 자기 자신
        } else if (hit == 3) {
            int cnt = 0;
            for (int i = 0 ; i < base.length ; i++) {
                if (base[i]) cnt++;
            }
            Arrays.fill(base, false);
            base[base.length - 1] = true;
            return cnt;
        } else if (hit == 2) {
            int cnt = 0;
            for (int i = 1 ; i < base.length ; i++) {
                if (base[i]) cnt++;
            }

            base[2] = base[1] = false;
            if (base[0]) base[2] = true;
            base[0] = false;
            base[1] = true;
            return cnt;
        } else if (hit == 1) {
            int cnt = 0;
            if (base[2]) cnt++;
            base[2] = false;

            if (base[1]) {
                base[2] = true;
                base[1] = false;
            }

            if (base[0]) {
                base[1] = true;
                base[0] = false;
            }

            base[0] = true;
            return cnt;
        }
        return 0;
    }

}