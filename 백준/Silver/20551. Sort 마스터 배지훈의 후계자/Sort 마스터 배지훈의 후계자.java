import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            sb.append(bsearch(arr, Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.print(sb);
    }

    public static int bsearch(int [] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (arr[right] == target) ? right : -1;
    }

}