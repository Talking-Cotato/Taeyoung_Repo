package PGS.HASH;

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            int cnt = 1;
            if (hashMap.get(p) != null) {
                cnt = hashMap.get(p) + 1;
            }
            hashMap.put(p, cnt);
        }

        for (String c : completion) {
            int cnt = 0;
            if (hashMap.get(c) != null) {
                cnt = hashMap.get(c) - 1;
            }
            hashMap.put(c, cnt);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }

        return answer;
    }

    /*public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[i];
    }*/
}
