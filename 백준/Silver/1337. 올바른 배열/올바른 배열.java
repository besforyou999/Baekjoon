import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static int N;
    static int [] arr;

    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        if (N == 1) {
            System.out.println(4);
            return;
        }

        for (int n = 0 ; n < N; n++)
            arr[n] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int minNeeded = 5;

        for (int lp = 0 ; lp < N ; lp++) {

            buildSet(arr[lp]);

            int contains = 0;

            for (int i = 0 ; i < 5 ; i++) {
                if (lp + i < N) {
                    if(set.contains(arr[lp + i])) contains += 1;
                }
            }

            minNeeded = Math.min(minNeeded, 5 - contains);
        }

        System.out.println(minNeeded);
    }

    public static void buildSet(int val) {
        set = new HashSet<>();
        for (int i = 0 ; i < 5 ; i++) {
            set.add(val + i);
        }
    }


}