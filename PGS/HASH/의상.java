package PGS.HASH;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> closet = new HashMap<>();

        for(String[] c : clothes){
            int cnt = 1;
            if (closet.get(c[1]) != null) {
                cnt = closet.get(c[1]) + 1;
            }
            closet.put(c[1], cnt);
        }

        int clothCase = 1;
        for (String key : closet.keySet()) {
            clothCase *= closet.get(key) + 1;
        }

        answer = clothCase - 1;

        return answer;
    }
}
