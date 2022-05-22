import java.io.*;

public class Main {
    static int N;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE, three = 0, five = 0;

        for (three = 0 ; three * 3 <= N ; three++) {
            int weight = N, bag_num = 0;
            weight -= three * 3;
            if (weight % 5 != 0) continue;
            five = weight / 5;
            bag_num = three + five;
            min = Math.min(min,bag_num);
        }

        if (min == Integer.MAX_VALUE) min = -1;

        System.out.print(min);

    }
}
