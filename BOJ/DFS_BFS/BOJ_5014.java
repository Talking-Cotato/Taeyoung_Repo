package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014 {

    static int[] visited = new int[1000001];
    static int F, S, G, U, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();   // 총 층수
        S = sc.nextInt();   // 현재 층
        G = sc.nextInt();   // 회사 층
        U = sc.nextInt();   // 위로 가는 층 수
        D = sc.nextInt();   // 아래로 가는 층 수

        sc.close();

        int result = bfs(S);

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }

    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int X = queue.poll();

            if (X == G) {
                return visited[X] - 1;
            }

            if (X + U <= F && visited[X + U] == 0) {
                visited[X + U] = visited[X] + 1;
                queue.offer(X + U);
            }

            if (X - D >= 1 && visited[X - D] == 0) {
                visited[X - D] = visited[X] + 1;
                queue.offer(X - D);
            }
        }

        return -1;
    }
}
