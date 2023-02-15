import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int MAX = 0;
    static String [] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];

        // words 초기화
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }

        boolean [] visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        back(visited, 0, 0);

        System.out.println(MAX);
    }

    static void back(boolean [] visited, int start, int depth) {
        if (depth == K - 5) {
            int cnt = 0;
            for (int i = 0 ; i < N ; i++) {
                String line = words[i];
                boolean flag = true;
                for (int j = 0 ; j < line.length() ; j++) {
                    char c = line.charAt(j);
                    if (!visited[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
            MAX = Math.max(MAX, cnt);
            return;
        }

        for (int i = start ; i < visited.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}


