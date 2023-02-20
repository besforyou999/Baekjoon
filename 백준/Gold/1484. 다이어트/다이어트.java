import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine());

        long g = 0;
        long l = 1;
        long r = 1;

        ArrayList<Long> ans = new ArrayList<>();

        while (true) {
            g = (long)Math.pow(r, 2) - (long)Math.pow(l, 2);
            if (g == G) {
                ans.add(r);
            }

            if (r - l == 1 && g > G) break;
            if (g > G) l++;
            else r++;
        }

        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();

        for (long a : ans)
            sb.append(a).append("\n");

        System.out.print(sb);
    }
}