import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0 ; t < T ; t++) {
            int n = Integer.parseInt(br.readLine());
            int [] numbers = new int[n + 1];
            Arrays.fill(numbers, -1);

            for (int k = 1 ; k <= n ; k++)
                for (int i = k ; i <= n ; i += k)
                    numbers[i] *= -1;

            int cnt = 0;

            for (int i = 1 ; i <= n ; i++)
                if (numbers[i] == 1) cnt += 1;

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
