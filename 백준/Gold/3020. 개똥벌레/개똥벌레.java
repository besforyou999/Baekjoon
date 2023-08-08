import java.io.*;
import java.util.*;

public class Main {
    static int N, H;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int [] low = new int[N / 2];
        int [] high = new int[N / 2];

        for (int n = 0 ; n < N ; n++) {
            int val = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {
                low[n / 2] = val;
            } else {
                high[n / 2] = val;
            }
        }

        Arrays.sort(low);
        Arrays.sort(high);

        int min = N, cnt = 0;

        for (int i = 1 ; i <= H ; i++) {
            int destory = bSearch(0, N / 2, low, i) + bSearch(0, N / 2, high, H + 1 - i);
            if (min > destory) {
                min = destory;
                cnt = 1;
            } else if (min == destory) {
                cnt++;
            }
        }

        System.out.print(min + " " + cnt);
    }

    public static int bSearch(int left, int right, int [] arr, int h) {

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }


}