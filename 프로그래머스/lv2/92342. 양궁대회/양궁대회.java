
class Solution {

    int score_diff = -1;

    int [] answer = new int[11];

    public int[] solution(int n, int[] info) {

        int [] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] result = new int[n];
        combination(arr, result, info, 0, 0);

        if (score_diff == -1) {
            answer = new int[] {-1};
        }

        return answer;
    }


    public void combination(int[] arr, int[] result, int[] info, int cnt, int idx) {
        if (cnt == result.length) {

            //System.out.println(Arrays.toString(result));

            int lionScore[] = new int[info.length];

            for (int a : result)
                lionScore[a] += 1;

            int lion = 0, peach = 0;

            for (int i = 0 ; i < info.length ; i++) {
                int a = info[i];
                int b = lionScore[i];

                if (a == 0 && b == 0) continue;

                if (a >= b) {
                    peach += 10 - i;
                } else {
                    lion += 10 - i;
                }
            }

            if (lion > peach) {
                int diff = Math.abs(lion - peach);

                if (diff > score_diff) {
                    score_diff = diff;
                    for (int i = 0 ; i < lionScore.length ; i++) {
                        answer[i] = lionScore[i];
                    }
                } else if (diff == score_diff) {
                    for (int i = lionScore.length - 1 ; i >= 0 ; i--) {
                        if (answer[i] < lionScore[i]) {
                            answer = lionScore.clone();
                        } else if (answer[i] > lionScore[i]){
                            break;
                        }
                    }
                }
            }
            return;
        }

        for (int i = idx ; i < arr.length ; i++) {
            result[cnt] = arr[i];
            combination(arr, result, info,cnt + 1, i);
        }
    }
}