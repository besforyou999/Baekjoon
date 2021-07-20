import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int [] xi = new int[n];

        for (int i = 0; i < n ; i++)
            xi[i] = sc.nextInt();

        Arrays.sort(xi);

        int left = 1;
        int right = xi[n-1] - xi[0];
        int d = 0;
        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            int start = xi[0];
            int cnt = 1;

            for (int i = 1; i < n ; i++) {
                d = xi[i] - start;
                if (mid <= d) {
                    ++cnt;
                    start = xi[i];
                }
            }

            if (cnt >= c) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}