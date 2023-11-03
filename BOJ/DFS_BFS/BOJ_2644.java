package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2644 {
    static boolean[] visited;
    static LinkedList<LinkedList<Integer>> adjacent;
    static int result = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int i1 = scanner.nextInt(), i2 = scanner.nextInt();
        int m = scanner.nextInt();

        // 1부터 시작
        visited = new boolean[n + 1];
        adjacent = new LinkedList<>();

        for (int i = 0; i < n + 1; i++) {
            adjacent.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            adjacent.get(n1).add(n2);
            adjacent.get(n2).add(n1);
        }

        dfs(i1, i2, 0);
        System.out.println(result);

        scanner.close();
    }

    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            result = cnt;
            return;
        }

        visited[start] = true;

        for (int i = 0; i < adjacent.get(start).size(); i++) {
            int next = adjacent.get(start).get(i);
            if (!visited[next]) {
                dfs(next, end, cnt + 1);
            }
        }
    }
}
