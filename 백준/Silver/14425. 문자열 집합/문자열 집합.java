import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int n = 0 ; n < N ; n++) {
            set.add(br.readLine());
        }

        int cnt = 0;

        for (int m = 0 ; m < M ; m++) {
            if (set.contains(br.readLine())) cnt += 1;
        }

        System.out.println(cnt);
    }
}