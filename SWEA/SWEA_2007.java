package SWEA;

import java.util.Scanner;

public class SWEA_2007 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int tc = Integer.parseInt(sc.nextLine().trim());
//
//        for (int t = 1; t < tc + 1; t++) {
//            String string = sc.nextLine();
//
//            // java에서 string은 reference type임에도 불구,
//            // 기존 클래스는 그대로 두고 새로운 string 클래스 주소를 만들어 대체한다.
//
//            // 문자열 하나씩 늘려가면서 만든 해당 문자열을 기존 문자열에서 제거하고,
//            // 남은 문자열의 길이가 이전 수행에서 남은 문자열의 길이보다 길어질 때 break (sout 찍어보면 패턴 알 수 있음)
//            StringBuilder sb = new StringBuilder();
//            int leftLength = string.length();
//            for (int i = 0; i < 10; i++) {
//                sb.append(string.charAt(i));
//                String left = string.replace(sb.toString(), "");
//
//                if (left.length() > leftLength) {
//                    break;
//                }
//                leftLength = left.length();
//            }
//
//            System.out.println("#" + t + " " + (sb.toString().length() - 1));
//        }
//    }

    // 더 간단한 풀이... 더 논리적!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine().trim());

        for (int t = 1; t < tc + 1; t++) {
            String string = sc.nextLine();
            int answer = 1;

            while (true) {
                String a = string.substring(0, answer);
                String b = string.substring(answer, answer + answer);

                if (a.equals(b)) {
                    break;
                }

                answer++;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
