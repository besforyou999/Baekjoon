import java.util.*;


class Solution {

    HashMap<String, String> id_nickname;
    ArrayList<Rec> records;

    public String[] solution(String[] recordArr) {
        String[] answer = {};

        id_nickname = new HashMap<>();
        records = new ArrayList<Rec>();

        for (String record : recordArr) {
            String[] token = record.split(" ");

            switch (token[0]) {
                case "Enter" -> {
                    id_nickname.put(token[1], token[2]);
                    records.add(new Rec(0, token[1]));
                }
                case "Leave" -> {
                    records.add(new Rec(1, token[1]));
                }
                case "Change" -> {
                    id_nickname.put(token[1], token[2]);
                }
            }
        }

        answer = new String[records.size()];

        for (int i = 0 ; i < records.size() ; i++) {
            StringBuilder sb = new StringBuilder();
            Rec record = records.get(i);
            sb.append(id_nickname.get(record.uid));

            if (record.type == 0) {
                sb.append("님이 들어왔습니다.");
            } else {
                sb.append("님이 나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}

class Rec {
    int type; // 0 : enter, 1 : leave, 2 : change
    String uid;

    public Rec(int type, String uid) {
        this.type = type;
        this.uid = uid;
    }
}