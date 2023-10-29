package PGS.HASH;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> hashSet = new HashSet<>();

        for (int i : nums) {
            hashSet.add(i);
        }

        if (nums.length / 2 >= hashSet.size()) {
            answer = hashSet.size();
        } else {
            answer = nums.length / 2;
        }

        return answer;
    }

    /*
    public int solution(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i : nums) {
            hashSet.add(i);
        }

        return Math.min(hashSet.size(), nums.length / 2);
    }
     */
}
