import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer MIN = Integer.MAX_VALUE;
        int a_len = 0;
        for (int i = 0; i < line.length() ; i++) {
            if (line.charAt(i) == 'a')
                a_len += 1;
        }

        for (int i = 0 ; i < line.length() ; i++) {
            int b_cnt = 0;
            for (int j = i ; j < a_len + i ; j++) {
                if (line.charAt(j % line.length()) == 'b')
                    b_cnt += 1;
            }
            MIN = Math.min(MIN, b_cnt);
        }
        System.out.print(MIN);
    }
}
