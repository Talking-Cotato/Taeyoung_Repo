package SWEA;

import java.util.Scanner;

public class SWEA_19003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= T; t++) {
            String[] nm = sc.nextLine().split(" ");
            // 문자열 개수 n, 각 문자열 길이 m
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            // 문자열 입력 받을 배열
            String[] s = new String[n];

            // 문자열 입력받으면서 팰린드롬인 문자열 개수 세기
            int pCnt = 0;
            for (int k = 0; k < n; k++) {
                s[k] = sc.nextLine();
                if (check(s[k])) {
                    pCnt++;
                }
            }

            // 만약 전부 팰린드롬이면, 중복되는 문자열 들어오지 않으므로 해당 케이스는 문자열 길이 출력
            if (pCnt == n) {
                System.out.println("#" + t + " " + m);
                continue;
            }

            // 두 문자열을 합쳤을 때 팰린드롬이 되는 경우의 수를 세기
            int fCnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }

                    String word = s[i].concat(s[j]);
                    if (check(word)) {
                        fCnt++;
                    }
                }
            }

            // 처음부터 팰린드롬인 것이 하나라도 있으면, 이걸 가운데에 두면 됨.
            // ex) abc, cba, ded, abb, bba가 있으면 -> abbbba, bbaaab, abccba, cbaabc 이렇게 나올 수 있음
            // abbbba나 bbaaab나 길이는 똑같고, 또 다른 팰린드롬은 반으로 나눠서 양쪽으로 계속 확장 가능 -> abcabbbbacba 이런 식
            // 따라서 (fCnt / 2) * (m * 2) + m -> (fCnt + 1) * m
            if(pCnt > 0)
                System.out.println("#" + t + " " + ((fCnt + 1) * m));

            // 하나도 팰린드롬인 게 없으면, 그냥 (fCnt / 2) * (m * 2)
            else
                System.out.println("#" + t + " " + fCnt * m);
        }
    }

    // 팰린드롬인지 아닌지 체크
    static boolean check(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
