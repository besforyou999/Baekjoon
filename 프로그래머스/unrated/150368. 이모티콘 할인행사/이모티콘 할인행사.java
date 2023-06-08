class Solution {

    int [] BEST = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {

        occurances(0, new int[emoticons.length], users, emoticons);

        //System.out.println(BEST[0] + " " + BEST[1]);

        return BEST;
    }

    public void occurances(int depth, int [] rec, int[][] users, int [] emoticons) {
        if (depth == rec.length) {

            int emo_plus = 0, total_purchase = 0;

            for (int i = 0 ; i < users.length ; i++) {
                int user_percent = users[i][0]; // 사용자가 원하는 할인률
                int user_spent = 0;

                for (int j = 0 ; j < rec.length ; j++) {
                    int discount = rec[j]; // j번째 이모티콘 할인 비율
                    if (discount >= user_percent) user_spent += (emoticons[j] / 100) * (100 -discount);
                }

                // 사용자 구매 비용이 기준 넘으면
                if (user_spent >= users[i][1] )
                    emo_plus += 1;
                else
                    total_purchase += user_spent;

            }

            compare(emo_plus, total_purchase);

            return;
        }

        for (int i = 1 ; i <= 4 ; i++) {
            rec[depth] = i * 10;
            occurances(depth + 1, rec, users, emoticons);
        }
    }

    public void compare(int emo_plus, int pay) {
        if (BEST[0] < emo_plus) {
            BEST[0] = emo_plus;
            BEST[1] = pay;
        } else if (BEST[0] == emo_plus) {
            BEST[1] = Math.max(BEST[1], pay);
        }
    }
}