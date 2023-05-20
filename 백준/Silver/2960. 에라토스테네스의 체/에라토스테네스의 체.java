import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [] num = new int[N + 1];

        ArrayList<Integer> delete = new ArrayList<>();
        delete.add(0);

        for (int i = 2 ; i <= N ; i++) {
            if (num[i] == 0) {
                delete.add(i);
                num[i] = 1;
                for (int j = i + i ; j <= N ; j += i) {
                    if (num[j] == 0) {
                        delete.add(j);
                        num[j] = 1;
                    }
                }
            }
        }


        System.out.println(delete.get(K));

    }
}