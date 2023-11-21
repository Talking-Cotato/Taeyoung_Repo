package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack5 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = N; i > 0; i--) {
            int temp = i;
            if (temp % 5 == 0) {
                while (temp % 5 == 0) {
                    temp = temp / 5;
                    stack5.add(5);
                }
            }
            if (temp % 2 == 0) {
                while (temp % 2 == 0) {
                    temp = temp / 2;
                    stack2.add(2);
                }
            }
        }

        int cnt5 = stack5.toArray().length;
        int cnt2 = stack2.toArray().length;

        System.out.println(Math.min(cnt2, cnt5));
    }
}
