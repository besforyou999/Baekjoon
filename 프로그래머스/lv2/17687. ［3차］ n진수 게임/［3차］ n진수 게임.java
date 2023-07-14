import java.util.*;

class Solution {

    StringBuilder sb;
    ArrayList<Character> answers;

    public String solution(int n, int t, int m, int p) {
        sb = new StringBuilder();
        answers = new ArrayList<>();
        Integer number = 0;

        while (answers.size() <= t * m) {
            String tmp = changeNumber(number, n);
            for (char ch : tmp.toCharArray()) {
                answers.add(ch);
            }
            number += 1;
        }

        int idx = 0;
        int turn = 1;
        while (sb.length() < t) {
            if (turn == p) {
                char ch = answers.get(idx);
                if (ch >= 'a' && ch <= 'z') {
                    sb.append(Character.toUpperCase(ch));
                } else
                    sb.append(answers.get(idx));
            }

            if (turn == m) {
                turn = 0;
            }

            turn += 1;
            idx += 1;
        }

        return sb.toString();
    }

    public String changeNumber(Integer number, int n) {
        return Integer.toString(number, n);
    }
}