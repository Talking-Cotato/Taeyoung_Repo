package PGS.STACK_QUEUE;

import java.util.*;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;

        // String -> split 대신 charAt 사용.
        // charAt 사용해도 equals 사용 시 효율성 테스트 통과 x
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sElem = s.charAt(i);
            if (sElem == '(') {
                stack.push(sElem);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
