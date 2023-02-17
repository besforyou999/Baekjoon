import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int len = N * N;
        int []nums = new int[len];
        int idx = 0;

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(nums);

        System.out.print(nums[len - N]);
    }
}