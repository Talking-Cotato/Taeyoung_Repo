package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2606 {
    static boolean[] visited;
    static LinkedList<LinkedList<Integer>> adjacent;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int com = scanner.nextInt();
        int pair = scanner.nextInt();

        visited = new boolean[com + 1];
        adjacent = new LinkedList<>();

        for(int i = 0; i < com + 1; i++){
            adjacent.add(new LinkedList<>());
        }

        for (int i = 0; i < pair; i++) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();

            adjacent.get(c1).add(c2);
            adjacent.get(c2).add(c1);
        }

        dfsR(1);
        System.out.println(cnt - 1);

        scanner.close();
    }

    private static void dfsR(int index){
        visited[index] = true;
        cnt++;

        for(int i : adjacent.get(index)){
            if(!visited[i]){
                dfsR(i);
            }
        }
    }
}
