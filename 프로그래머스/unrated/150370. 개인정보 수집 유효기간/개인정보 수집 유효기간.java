import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> limit = new HashMap<>();

        int currentDay = getDays(today);

        for (String term : terms) {
            String [] tokens = term.split(" ");
            limit.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        for (int i = 0 ; i < privacies.length ; i++) {
            String [] tokens = privacies[i].split(" ");

            if (currentDay >= getDays(tokens[0]) + limit.get(tokens[1]) * 28)
                ans.add(i + 1);
        }
        
        return ans.stream().mapToInt(Integer -> Integer).toArray();
    }

    public int getDays(String date) {
        String [] tokens = date.split("\\.");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}