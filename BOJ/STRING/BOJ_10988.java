package BOJ.STRING;

import java.util.Scanner;

public class BOJ_10988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (palinedrome(scanner.nextLine())) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
