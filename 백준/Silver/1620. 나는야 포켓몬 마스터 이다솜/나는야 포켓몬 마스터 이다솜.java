import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();

        for (int n = 0 ; n < N ; n++) {
            String line = br.readLine();
            name.put(line, n + 1);
            number.put(n + 1, line);
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            String line = br.readLine();
            char first = line.charAt(0);

            if (first >= '1' && first <= '9') {
                Integer num = Integer.parseInt(line);
                sb.append(number.get(num)).append("\n");
            } else {
                sb.append(name.get(line)).append("\n");
            }
        }

        System.out.println(sb);

    }
}