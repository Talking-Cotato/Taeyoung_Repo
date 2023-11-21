package BOJ;

import java.util.Scanner;

public class BOJ_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt5 = 0;
        int cnt2 = 0;

        for (int i = N; i > 0; i--) {
            int temp = i;
            while (temp % 5 == 0) {
                temp = temp / 5;
                cnt5++;
            }
            while (temp % 2 == 0) {
                temp = temp / 2;
                cnt2++;
            }
        }

        System.out.println(Math.min(cnt2, cnt5));
    }
}
