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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int n = 0 ; n < N ; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(idx, val));
        }

        Collections.sort(pairs);

        int max = -1;
        int [] dp = new int[N];

        for (int k = 0 ; k < N ; k++) {
            dp[k] = 1;
            for (int i = 0 ; i < k ; i++) {
                if (pairs.get(k).number > pairs.get(i).number) {
                    dp[k] = Math.max(dp[k], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[k]);
        }

        System.out.println(N - max);
    }
}