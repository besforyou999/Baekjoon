import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);

        for (int i = 0 ; i < N ; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (arr.get(arr.size() - 1) < value) {
                arr.add(value);
            } else {
                int lp = 1, rp = arr.size() - 1;
                while ( lp < rp ) {
                    int mid = (lp + rp) / 2;
                    if (arr.get(mid) < value) {
                        lp = mid + 1;
                    } else
                        rp = mid;
                }
                arr.set(rp, value);
            }
        }
        System.out.print(arr.size() - 1);
    }
}
