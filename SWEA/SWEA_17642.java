package SWEA;

import java.math.BigInteger;
import java.util.Scanner;

public class SWEA_17642 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t < T + 1; t++) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            BigInteger ans;
            if (a.equals(b)) {
                ans = BigInteger.ZERO;
            } else if (a.compareTo(b) == 1) { // a는 더하기 연산만 가능
                ans = BigInteger.ONE.negate();
            } else {
                BigInteger diff = b.add(a.negate());

                if (diff.equals(BigInteger.ONE)) {
                    ans = BigInteger.ONE.negate();
                } else {
                    ans = diff.divide(BigInteger.valueOf(2));
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
