import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;

        String str = Integer.toString(n, k);

        int idx = 0;

        ArrayList<String> answers = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (idx = 0 ; idx < str.length() ; idx++) {
            char ch = str.charAt(idx);
            if (ch != '0') {
                sb.append(ch);
            } else {
                if (sb.length() != 0) {
                    String tmp = sb.toString();
                    if (isPrime(Integer.parseInt(tmp))) {
                        answers.add(tmp);
                    }
                    sb = new StringBuilder();
                }
            }
        }

        if (sb.length() != 0) {
            String tmp = sb.toString();
            if (isPrime(Long.parseLong(tmp))) {
                answers.add(tmp);
            }
        }

        return answers.size();
    }

    public boolean isPrime(long number) {
        if (number == 1) return false;

        if (number == 2 || number == 3)
            return true;

        if (number % 2 == 0) return false;

        for (int div = 3 ; div <= Math.sqrt(number) ; div += 2) {
            if (number % div == 0) return false;
        }

        return true;
    }
}