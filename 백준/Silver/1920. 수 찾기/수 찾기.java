import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            sb.append(bSearch(arr, Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    public static int bSearch(int [] arr, int target) {
        int lp = 0, rp = arr.length - 1;

        while ( lp <= rp ) {
            int mid = (lp + rp) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                rp = mid - 1;
            } else {
                lp = mid + 1;
            }
        }

        return 0;
    }
}