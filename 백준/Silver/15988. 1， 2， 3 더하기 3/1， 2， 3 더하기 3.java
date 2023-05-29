import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long DIV = 1_000_000_009;

        long[] arr = new long[1_000_001];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4 ; i < 1_000_001 ; i++) {
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % DIV;
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.print(sb);
    }
}