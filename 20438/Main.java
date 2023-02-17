import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] students = new int[N + 3];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < K ; i++) {
            int sleep = Integer.parseInt(st.nextToken());
            students[sleep] = -1;
        }
        /*
        System.out.println("sleeping");
        for (int i = 3 ; i < N + 3 ; i++)
            System.out.print(students[i] + " ");
        System.out.println();
        */
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < Q ; i++) {
            int code = Integer.parseInt(st.nextToken());
            if (students[code] == -1) continue;
            operate(code, students);
        }
        /*
        System.out.println("After op");
        for (int i = 3 ; i < N + 3 ; i++)
            System.out.print(students[i] + " ");
        System.out.println();
        */
        int [] Si = new int[N + 3];

        for (int i = 3 ; i < N + 3 ; i++) {
            Si[i] = Si[i-1];
            if (students[i] == -1 || students[i] == 0) {
                Si[i] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(Si[r] - Si[l - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static void operate(int code, int [] students) {
        for (int i = code ; i < students.length ; i += code) {
            if (students[i] == -1) continue;
            students[i] = 1;
        }

    }

}