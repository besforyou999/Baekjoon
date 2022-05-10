import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer arr [] = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (sum + 2 <= arr[i]) break;
            sum += arr[i];
        }

        System.out.print(sum + 1);
    }
}

