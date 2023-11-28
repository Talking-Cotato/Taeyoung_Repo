package BOJ.STRING;

import java.util.Scanner;

public class BOJ_2908 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(sb.append(str[0]).reverse().toString());

        sb = new StringBuilder();
        int B = Integer.parseInt(sb.append(str[1]).reverse().toString());

        System.out.println(Math.max(A, B));
    }
}
