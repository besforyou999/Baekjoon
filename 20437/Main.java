import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();
            Integer K = Integer.parseInt(br.readLine());
            Integer MAX = -1, MIN = Integer.MAX_VALUE;

            if (K == 1) {
                bw.write("1 1 \n");
                continue;
            }

            int alpha[] = new int[26];
            for (int i = 0 ; i < line.length() ; i++) {
                alpha[line.charAt(i) - 'a'] += 1;
            }

            for (int i = 0 ; i < line.length() ; i++) {
                if (alpha[line.charAt(i) - 'a'] < K) continue;

                int count = 1;
                for (int j = i + 1 ; j < line.length() ; j++) {
                    if (line.charAt(i) == line.charAt(j)) count++;
                    if (count == K) {
                        MAX = Math.max(MAX, j - i + 1);
                        MIN = Math.min(MIN, j - i + 1);
                        break;
                    }
                }
            }

            if (MAX == -1 || MIN == Integer.MAX_VALUE) {
                bw.write(-1 + "\n");
            } else {
                bw.write(MIN + " " + MAX + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
