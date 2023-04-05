import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int [] chosen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 개수 2 <= N <= 30,000
        d = Integer.parseInt(st.nextToken()); // 초밥 번호 범위 1 ~ d. 2 <= d <= 3,000
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시. 2 <= k <= 3,000
        c = Integer.parseInt(st.nextToken()); // 쿠폰. 1 <= c <= d

        int [] dishes = new int[N];
        chosen = new int[d + 1];
        HashSet<Integer> chosenSet = new HashSet<>();

        for (int i = 0 ; i < N ; i++)
            dishes[i] = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < k ; i++) {
            int type = dishes[i];
            chosen[type]++;
            chosenSet.add(type);
        }

        int lp = 0;
        int rp = k;

        int types = chosenSet.size();
        if (chosen[c] == 0) types += 1;

        int max = types;
        int spin = 0;
        while (spin <= N + 1) {
            chosen[dishes[lp]]--;
            chosen[dishes[rp]]++;

            if (chosen[dishes[lp]] == 0)
                chosenSet.remove(dishes[lp]);
            chosenSet.add(dishes[rp]);

            types = chosenSet.size();
            if (chosen[c] == 0) types += 1;
            max = Math.max(max, types);

            lp++;
            rp++;
            if (rp == N) rp = 0;
            if (lp == N) lp = 0;
            spin++;
        }

        System.out.print(max);
    }
}