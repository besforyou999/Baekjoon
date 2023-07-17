import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(-2_000_000_000);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 1 ; n < N + 1 ; n++) {

            int value = Integer.parseInt(st.nextToken());
            int len = seq.size();

            if (value > seq.get(len - 1))
                seq.add(value);
            else
                insertNumber(seq, value, len);
        }

        System.out.println(seq.size() - 1);
    }

    public static void insertNumber(ArrayList<Integer> seq, int number, int len) {
        int lp = 0, rp = len - 1;

        while (lp < rp) {
            int mid = (lp + rp) / 2;
            if (seq.get(mid) < number)
                lp = mid + 1;
            else
                rp = mid;
        }

        seq.set(rp, number);
    }
}