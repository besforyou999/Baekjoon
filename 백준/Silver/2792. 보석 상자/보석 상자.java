import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        int max = -1;
        for (int m = 0 ; m < M ; m++) {
            arr[m] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[m]);
        }

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }

        System.out.println(binarySearch(1, max));
    }

    public static int binarySearch(int left, int right) {

        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cntGroups = 0;

            for (int i = 0 ; i < M ; i++) {
                if (arr[i] % mid == 0) {
                    cntGroups += arr[i] / mid;
                } else {
                    cntGroups += arr[i] / mid + 1;
                }
            }

            if (cntGroups > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }
}