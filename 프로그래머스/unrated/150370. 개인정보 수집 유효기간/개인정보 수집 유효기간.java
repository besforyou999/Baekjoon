import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        ArrayList<Integer> ans = new ArrayList<>();

        String [] tokens = today.split("\\.");

        int todayYear  = Integer.parseInt(tokens[0]);
        int todayMonth = Integer.parseInt(tokens[1]);
        int todayDay   = Integer.parseInt(tokens[2]);

        HashMap<String, Integer> limit = new HashMap<>();

        for (String t : terms) {
            tokens = t.split(" ");
            limit.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        for (int i = 0 ; i < privacies.length ; i++) {
            String privacy = privacies[i];
            tokens = privacy.split(" ");

            String [] date = tokens[0].split("\\.");

            int year  = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day   = Integer.parseInt(date[2]);

            String term = tokens[1];
            int carryLength = limit.get(term);
            int carryYear = carryLength / 12;
            int carryMonth = carryLength % 12;

            year += carryYear;
            month += carryMonth;
            
            if (month > 12) {
                year += 1;
                month -= 12;
            }

            if (expired(todayYear, todayMonth, todayDay, year, month, day)) {
                ans.add(i + 1);
            }

        }

        int [] answer = new int[ans.size()];
        for (int i = 0 ; i < ans.size() ; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public boolean expired(int ty, int tm, int td, int y, int m, int d) {
        if (ty > y) {
            return true;
        } else if (ty == y) {
            if (tm > m) {
                return true;
            } else if (tm == m) {
                if (td >= d) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}