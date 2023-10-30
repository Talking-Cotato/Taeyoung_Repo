package PGS.HASH;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<String> genreOrder = new ArrayList<>();
        Map<String, ArrayList<Integer>> songOrder = new HashMap<>();

        Map<String, Integer> genrePlay = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> songPlay = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // genrePlay
            int playCnt = plays[i];
            if (genrePlay.get(genres[i]) != null) {
                playCnt += genrePlay.get(genres[i]);
            }
            genrePlay.put(genres[i], playCnt);

            // songPlay
            HashMap<Integer, Integer> numPlay = songPlay.get(genres[i]);
            if(numPlay == null){
                numPlay = new HashMap<>();
            }
            numPlay.put(i, plays[i]);
            songPlay.put(genres[i], numPlay);
        }

        // genreOrder
        ArrayList<Integer> playCntList = new ArrayList<>(genrePlay.values());
        playCntList.sort(Comparator.reverseOrder());
        for (Integer p : playCntList) {
            for (Map.Entry<String, Integer> e : genrePlay.entrySet()) {
                if (e.getValue().equals(p)) {
                    genreOrder.add(e.getKey());
                }
            }
        }

        // songOrder
        for (String key : songPlay.keySet()) {
            ArrayList<Integer> arrayList = new ArrayList<>(songPlay.get(key).values());
            arrayList.sort(Comparator.reverseOrder());

            ArrayList<Integer> keyList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : songPlay.get(key).entrySet()) {
                if (entry.getValue().equals(arrayList.get(0))) {
                    keyList.add(entry.getKey());
                    break;
                }
            }
            if (songPlay.get(key).size() > 1) {
                for (Map.Entry<Integer, Integer> entry2 : songPlay.get(key).entrySet()) {
                    if (keyList.get(0).equals(entry2.getKey())) {
                        continue;
                    }   // 같은 재생 횟수인 노래가 있는 경우

                    if (entry2.getValue().equals(arrayList.get(1))) {
                        keyList.add(entry2.getKey());
                        break;
                    }
                }
            }

            songOrder.put(key, keyList);
        }

        ArrayList<Integer> playList = new ArrayList<>();
        for (String g : genreOrder) {
            for (int i = 0; i < songOrder.get(g).size(); i++) {
                playList.add(songOrder.get(g).get(i));
            }
        }

        answer = playList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
