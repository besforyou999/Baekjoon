import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Main {
    static final String FAIL = "I'm Sorry Hansoo";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : name.toCharArray()) {
            if (map.containsKey(ch)) {
                int cnt = map.get(ch);
                map.put(ch, cnt + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Set<Character> keyset = map.keySet();
        ArrayList<Character> keys = new ArrayList<>();

        int odds = 0;
        char ch = 'A';

        for (char key : keyset) {
            keys.add(key);
            if (map.get(key) % 2 == 1) {
                odds++;
                ch = key;
            }
        }

        if (odds > 1) {
            System.out.println(FAIL);
            return;
        }

        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();

        for (int k = 0 ; k < keys.size() ; k++) {
            char key = keys.get(k);
            int cnt = map.get(key);
            for (int i = 0 ; i < cnt / 2 ; i++) sb.append(key);
        }

        if (odds == 1)
            sb.append(ch);

        for (int k = keys.size() - 1 ; k >= 0 ; k--) {
            char key = keys.get(k);
            int cnt = map.get(key);
            for (int i = 0 ; i < cnt / 2 ; i++) sb.append(key);
        }

        System.out.println(sb);
    }
}