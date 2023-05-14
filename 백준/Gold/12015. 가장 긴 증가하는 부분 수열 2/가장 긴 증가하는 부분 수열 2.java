import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);

        for (int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(st.nextToken());
            int len = ans.size();

            if (ans.get(len - 1) < val) {
                ans.add(val);
            } else {
                int lp = 1, rp = len - 1;
                while (lp < rp) {
                    int mid = (lp + rp) / 2;
                    if (ans.get(mid) < val) {
                        lp = mid + 1;
                    } else {
                        rp = mid;
                    }
                }
                ans.set(rp, val);
            }
        }

        System.out.println(ans.size() - 1);
    }
}