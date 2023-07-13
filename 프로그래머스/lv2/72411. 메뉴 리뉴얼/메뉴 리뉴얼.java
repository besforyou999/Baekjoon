import java.util.*;

class Solution {

    HashMap<String, Integer> patternCnt;
    ArrayList<Character> alphabets;

    Order [] orderClass;

    int mostChosenNumber = 0;

    public String[] solution(String[] orders, int[] course) {

        // 초기화
        init(orders);

        ArrayList<String> answer = new ArrayList<>();

        // 코스 길이
        for (int rec : course) {

            // 코스 길이보다 긴 패턴 개수
            int LenBiggerThanRec = 0;
            // 가장 많이 선택된 숫자 초기화
            mostChosenNumber = 0;

            patternCnt = new HashMap<>();

            for (Order order : orderClass)
                if (order.len >= rec) LenBiggerThanRec += 1;

            // 코스 길이보다 긴 패턴의 개수가 2개 이상이여만 조합 생성
            if (LenBiggerThanRec >= 2)
                combination(new char[rec], 0, 0);

            if (mostChosenNumber > 1) {
                for (String key : patternCnt.keySet()) {
                    if (patternCnt.get(key) == mostChosenNumber)
                        answer.add(key);
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }


    public void combination(char [] rec, int start, int r) {
        if (rec.length == r) {

            int cnt = 0;
            for (Order order : orderClass) {
                if (order.len < rec.length) continue;

                if (order.hasAll(rec)) cnt += 1;
            }

            mostChosenNumber = Math.max(mostChosenNumber, cnt);
            patternCnt.put(new String(rec), cnt);
            return;
        }

        for (int i = start ; i < alphabets.size() ; i++) {
            rec[r] = alphabets.get(i);
            combination(rec, i + 1, r + 1);
        }
    }


    public void init(String [] orders) {

        HashSet<Character> set = new HashSet<>();
        orderClass = new Order[orders.length];

        for (int i = 0 ; i < orders.length ; i++) {
            orderClass[i] = new Order();
            for (char ch : orders[i].toCharArray()) {
                orderClass[i].alphas.add(ch);
                set.add(ch);
            }
            orderClass[i].setLen();
        }

        alphabets = new ArrayList<>(set);
        Collections.sort(alphabets);
    }


    class Order {
        int len;
        HashSet<Character> alphas;
        Order() {
            this.alphas = new HashSet<>();
            this.len = 0;
        }

        public void setLen() {
            this.len = this.alphas.size();
        }

        public boolean hasAll(char [] chars) {
            for (char ch : chars) {
                if (!alphas.contains(ch)) return false;
            }
            return true;
        }
    }

}