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

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(-2_000_000_000);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 1 ; n < N + 1 ; n++ ) {
            int val = Integer.parseInt(st.nextToken());
            int len = seq.size();

            if (seq.get(len - 1) < val) {
                seq.add(val);
            } else {
                int lp = 0;
                int rp = len - 1;

                while (lp + 1 < rp) {
                    int mid = (lp + rp) / 2;

                    if (seq.get(mid) < val) {
                        lp = mid;
                    } else {
                        rp = mid;
                    }
                }
                seq.set(rp, val);
            }
        }

        System.out.println(seq.size() - 1);
    }
}