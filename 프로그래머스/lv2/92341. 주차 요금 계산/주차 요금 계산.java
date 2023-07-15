import java.util.*;

class Solution {

    // 차 번호, 입차시간(분)
    HashMap<String, Integer> in_record;
    // 차 번호, 누적시간(분)
    HashMap<String, Integer> minuteParked;

    public int[] solution(int[] fees, String[] records) {

        in_record = new HashMap<>();
        minuteParked = new HashMap<>();

        for (String record : records) {
            String [] tokens = record.split(" ");

            int time = hourToMinute(tokens[0]);
            String carNumber = tokens[1];
            String cmd = tokens[2];

            if (cmd.equals("IN")) {
                in_record.put(carNumber, time);
            } else {
                int inTime = in_record.get(carNumber);

                if(minuteParked.containsKey(carNumber)) {
                    int rec = minuteParked.get(carNumber);
                    minuteParked.put(carNumber, rec + time - inTime);
                } else {
                    minuteParked.put(carNumber, time - inTime);
                }

                in_record.remove(carNumber);
            }
        }


        // 출차 기록이 없는 차량들 ( 23:59 출차로 간주 )
        for (String carNumber : in_record.keySet()) {

            int inTime = in_record.get(carNumber);
            int outTime = hourToMinute("23:59");

            if (minuteParked.containsKey(carNumber)) {
                int rec = minuteParked.get(carNumber);
                minuteParked.put(carNumber, rec + outTime - inTime);
            } else {
                minuteParked.put(carNumber, outTime - inTime);
            }
        }


        ArrayList<String> carNumbers = new ArrayList<>(minuteParked.keySet());
        Collections.sort(carNumbers);

        int [] answer = new int[carNumbers.size()];

        for (int i = 0 ; i < carNumbers.size() ; i++) {
            answer[i] = calcCost(fees, minuteParked.get(carNumbers.get(i)));
        }

        return answer;
    }

    public int calcCost(int[]fees, int minuteParked) {
        if (minuteParked <= fees[0]) {
            return fees[1];
        } else {
            int overTime = minuteParked - fees[0];
            double division = (double)overTime / (double)fees[2];
            overTime = (int)Math.ceil(division);
            return fees[1] + overTime * fees[3];
        }
    }

    public int hourToMinute(String time) {
        String [] token = time.split(":");
        int hour = Integer.parseInt(token[0]);
        int minute = Integer.parseInt(token[1]);
        return hour * 60 + minute;
    }
}