package SWEA;

import java.util.Scanner;

public class SWEA_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String[] temp = Integer.toString(i).split("");
            int cnt = 0;
            for (String s : temp) {
                if (s.equals("3") || s.equals("6") || s.equals("9")) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                sb.append(i);
            } else {
                sb.append("-".repeat(Math.max(0, cnt)));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

// 제출 코드
/*
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        String result = "";
		for(int i = 1; i <= T; i++)
		{
            String[] temp = Integer.toString(i).split("");
            int cnt = 0;
            for (String s : temp) {
                if (s.equals("3") || s.equals("6") || s.equals("9")) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                result += Integer.toString(i);
            } else {
                for(int k = 0; k < cnt; k++){
                	result += "-";
                }
            }
            result += " ";
		}
        System.out.println(result);
	}
}
 */