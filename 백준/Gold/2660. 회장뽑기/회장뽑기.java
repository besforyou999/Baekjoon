import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, INF = 1_000_000;

    static int [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 1 ; i < N + 1 ; i++) {
            for (int j = 1 ; j < N + 1 ; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            map[a][b] = map[b][a] = 1;
        }

        for (int k = 1 ; k < N + 1 ; k++) {
            for (int i = 1 ; i < N + 1 ; i++) {
                for (int j = 1 ; j < N + 1 ; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int [] scores = new int[N + 1];
        int readScore = INF;

        for (int i = 1 ; i < N + 1 ; i++) {
            int score = 0;
            for (int j = 1 ; j < N + 1 ; j++) {
                if (map[i][j] != INF) {
                    score = Math.max(score, map[i][j]);
                }
            }

            scores[i] = score;
            readScore = Math.min(readScore, score);
        }

        StringBuilder title = new StringBuilder();
        title.append(readScore).append(" ");

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1 ; i < N + 1 ; i++) {
            if (scores[i] == readScore) {
                candidates.add(i);
            }
        }

        title.append(candidates.size());

        StringBuilder body = new StringBuilder();

        for (int i : candidates) {
            body.append(i).append(" ");
        }

        System.out.println(title.toString());
        System.out.println(body.toString());
    }
}