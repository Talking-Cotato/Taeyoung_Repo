package PGS.HASH;

import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        /*Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }*/

        Map<String, Integer> hashMap = new HashMap<>();

        int cnt = 0;
        for (String p : phone_book) {
            hashMap.put(p, cnt);
            cnt++;
        }

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (hashMap.containsKey(s.substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
