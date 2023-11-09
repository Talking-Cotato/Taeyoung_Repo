package BOJ.STRING;

import java.util.Scanner;

public class BOJ_10174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            if (check(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean check(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(s.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
