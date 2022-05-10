import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N , L;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Float leak [] = new Float[N];

        Integer idx = 0;

        while(st.hasMoreTokens()) {
            leak[idx++] = Float.parseFloat(st.nextToken());
        }

        Arrays.sort(leak);

        Integer answer = 0;
        idx = 0;

        for (; idx < leak.length ; idx++) {
            Float start_point = leak[idx] - 0.5f;
            Float end_point = start_point + L;
            answer += 1;
            if (idx + 1 >= leak.length) break;
            do {
                Float next_leak = leak[idx + 1];
                if (next_leak > end_point) break;
                idx += 1;
            } while (idx < leak.length - 1);
        }
        System.out.println(answer);
    }
}

