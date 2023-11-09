package BOJ.STRING;

import java.util.Scanner;

public class BOJ_8892 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(sc.nextLine());

            String[] s = new String[k];
            for (int j = 0; j < k; j++) {
                s[j] = sc.nextLine();
            }

            boolean find = false;
            Loop: for (int n = 0; n < k; n++) {
                for (int m = 0; m < k; m++) {
                    if (n == m) {   // 앞뒤 바뀐 경우도 살펴야 하기 때문에
                        continue;
                    }

                    String word = s[n].concat(s[m]);
                    if (palinedrome(word)) {
                        System.out.println(word);
                        find = true;
                        break Loop;
                    }
                }
            }

            if (!find) {
                System.out.println(0);
            }
        }
    }

    static boolean palinedrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
