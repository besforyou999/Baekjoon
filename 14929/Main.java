import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N + 1];
        int [] Si = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers[1] = Integer.parseInt(st.nextToken());
        Si[1] = numbers[1];

        for (int i = 2 ; i <= N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            Si[i] = Si[i-1] + numbers[i];
        }

        long sum = 0;
        for (int i = 1 ; i <= N ; i++)
            sum += numbers[i] * (Si[N] - Si[i]);

        System.out.println(sum);
    }
}