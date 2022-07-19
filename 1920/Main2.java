import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 0;
        Integer N = Integer.parseInt(br.readLine());
        Integer A[] = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            A[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Integer M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(b_search(A, target) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int b_search(Integer A[], Integer target) {
        int len = A.length;
        int lp = 0, rp = len - 1;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (target < A[mid]) {
                rp = mid - 1;
            } else if (target > A[mid]) {
                lp = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}

