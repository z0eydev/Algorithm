package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lv2_1 {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> sets = new HashSet<>();
        int maxNum = 0;
        for(int[] edge : edges){
            sets.add(edge[0]);
            sets.add(edge[1]);
            maxNum = Math.max(Math.max(edge[0], edge[1]), maxNum);
            if(!map.containsKey(edge[0])){
                List<Integer> list = new ArrayList<>();
                map.put(edge[0], list);
            }
            map.get(edge[0]).add(edge[1]);
        }
        int graphNum = 2;
        List<Integer> numList = new ArrayList<>();
        for(int i : sets){
            if(!map.containsKey(i)) {
                answer[2]++;
                continue;
            }
            int num = map.get(i).size();
            if(num == 1) continue;
            else if(num >= 3) {
                graphNum = num;
                answer[0] = i;
            }
            else if(num == 2) {
                answer[3]++;
                numList.add(i);
            }
        }
        boolean found = false;
        int cnt = 0;
        if(answer[0] == 0){
            answer[3]--;
            if(numList.size() == 1){
                answer[0] = numList.get(0);
            }else{
                for(int n : numList){
                    cnt++;
                    if(found) break;
                    if(cnt == numList.size()){
                        answer[0] = n;
                        break;
                    }
                    int next = map.get(n).get(0);
                    while(true){
                        if(next == n) break;
                        else if(!map.containsKey(next) || map.get(next).size() == 2){
                            answer[0] = n;
                            found = true;
                            break;
                        }else next = map.get(next).get(0);
                    }
                }
            }
        }
        answer[1] = graphNum - (answer[2] + answer[3]);

        return answer;
    }
    public static void main(String[] args) {

    }
}
