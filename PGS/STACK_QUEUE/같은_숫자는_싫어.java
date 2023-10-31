package PGS.STACK_QUEUE;

import java.util.*;
public class 같은_숫자는_싫어 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int a : arr) {
            if (stack.isEmpty() || stack.peek() != a) {
                stack.push(a);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
