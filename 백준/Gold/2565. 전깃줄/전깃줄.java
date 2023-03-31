import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
    int idx, number;
    Pair(int i, int n) {
        this.idx = i;
        this.number = n;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.idx, o.idx);
    }
}

public class Main {
    static int N;
    static ArrayList<Pair> pairs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(idx, number));
        }

        Collections.sort(pairs);

        int dp [] = new int[N];

        int max = -1;

        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (pairs.get(i).number > pairs.get(j).number && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}