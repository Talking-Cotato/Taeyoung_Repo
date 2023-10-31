package PGS.STACK_QUEUE;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            int days = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < days) {
                list.add(queue.size());
                queue.clear();
            }

            queue.offer(days);
        }

        list.add(queue.size());

        answer = list.stream().mapToInt(Integer::intValue).toArray();

//        List<Integer> list = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//        int days = 0;
//        while (list.size() != progresses.length) {
//
//            for (int i = list.size(); i < speeds.length; i++) {
//                progresses[i] += speeds[i];
//                if (progresses[i] >= 100) {
//                    progresses[i] = 100;
//                }
//                queue.offer(progresses[i]);
//            }
//            days++;
//
//            if (queue.peek() != 100) {
//                queue.clear();
//            } else {
//                int cnt = queue.size();
//                for (int i = 0; i < cnt; i++) {
//                    int temp = queue.poll();
//                    if (temp == 100) {
//                        list.add(days);
//                    } else {
//                        queue.clear();
//                        break;
//                    }
//                }
//            }
//        }
//
//        List<Integer> temp = new ArrayList<>();
//
//        int cnt = 1;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).equals(list.get(i - 1))) {
//                cnt++;
//            } else {
//                temp.add(cnt);
//                cnt = 1;
//            }
//        }
//        temp.add(cnt);
//
//        answer = temp.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
