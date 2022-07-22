import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer H, W, total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Integer height[] = new Integer[W];
        int idx = 0;
        while (st.hasMoreTokens()) {
            height[idx++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int current_height = height[i];
            int left = 0, right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(height[j], right);
            }

            if (left > current_height && right > current_height) {
                total += (Math.min(left, right) - current_height);
            }
        }

        System.out.print(total);
    }
}
