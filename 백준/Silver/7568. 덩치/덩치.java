import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Pair array[];
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans = "";
        N = Integer.parseInt(br.readLine());
        array = new Pair[N];
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[i] = new Pair(x,y);
        }

        for (int i = 0 ; i < N ; i++) {
            Integer k = count_bigger(i) + 1;
            ans += ( k.toString() + " " );
        }

        System.out.print(ans);
    }

    static Integer count_bigger(int idx) {
        int count = 0;
        Pair p1 = array[idx];
        for (int i = 0 ; i < N ; i++) {
            if (i == idx) continue;
            Pair p2 = array[i];
            if (p1.x < p2.x && p1.y < p2.y) count += 1;
        }
        return count;
    }

}

class Pair {
    public int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
