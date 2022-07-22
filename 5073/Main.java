import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) break;
            int [] tri = {a, b, c};
            Arrays.sort(tri);

            bw.write(result(tri) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static String result(int [] tri) {
        String result = new String();
        if (tri[2] >= tri[0] + tri[1]) {
            result = "Invalid";
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(tri[0]);
            set.add(tri[1]);
            set.add(tri[2]);

            if (set.size() == 1) {
                result = "Equilateral";
            } else if (set.size() == 2) {
                result = "Isosceles";
            } else if (set.size() == 3) {
                result = "Scalene";
            }
        }
        return result;
    }
}
