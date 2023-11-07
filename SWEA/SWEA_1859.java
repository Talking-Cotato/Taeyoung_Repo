package SWEA;

import java.util.Scanner;

public class SWEA_1859 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        String[] result = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] sale = new int[N];
            for (int j = 0; j < N; j++) {
                sale[j] = scanner.nextInt();
            }

            int[] dp = new int[N];
            int max_price = sale[N - 1];
            for (int k = N - 2; k >= 0; k--) {
                if (max_price >= sale[k]) {
                    dp[k + 1] = max_price - sale[k];
                } else {
                    max_price = sale[k];
                }
            }

            long sum = 0;   // 범위 초과 가능이므로 long으로
            for (int d : dp) {
                sum += d;
            }

            result[i] = "#" + (i + 1) + " " + sum;
        }

        for (String s : result) {
            System.out.println(s);
        }
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
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] price = new int[N];
            for(int i = 0; i < N; i++){
            	price[i] = sc.nextInt();
            }

            int[] dp = new int[N];
            int max_price = price[N - 1];
            for(int i = N - 2; i >= 0; i--){
                if(max_price >= price[i]){
                	dp[i+1] = max_price - price[i];
                } else{
                	max_price = price[i];
                }
            }

            long sum = 0;
            for(int d : dp){
            	sum += d;
            }

            System.out.println("#" + test_case + " " + sum);
		}
	}
}
 */