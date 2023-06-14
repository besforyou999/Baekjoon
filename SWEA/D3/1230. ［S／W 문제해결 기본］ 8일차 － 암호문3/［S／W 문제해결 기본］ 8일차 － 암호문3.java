import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= 10 ; tc++) {
            int N = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int cnt = 0 ;

            while (cnt < M) {
                String cmd = st.nextToken();

                if (cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0 ; i < y ; i++) {
                        list.add(x + i, Integer.parseInt(st.nextToken()));
                    }
                } else if (cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0 ; i < y ; i++) {
                        list.remove(x);
                    }
                } else if (cmd.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0 ; i < y ; i++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }

                cnt += 1;
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0 ; i < 10 ; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}