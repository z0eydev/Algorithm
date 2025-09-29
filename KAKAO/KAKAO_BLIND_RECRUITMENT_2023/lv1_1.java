package KAKAO.KAKAO_BLIND_RECRUITMENT_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lv1_1{
    static int[] splitDate(String d){
        String[] dateArr = d.split("\\.");
        int[] dateArr2 = Arrays.stream(dateArr).mapToInt(Integer::parseInt).toArray();
        return dateArr2;
    }
    static boolean calculate(int[] t, int[] d, int m){
        int todayYear = t[0];
        int todayMonth = t[1];
        int todayDay = t[2];
        int endYear = d[0];
        int endMonth = d[1] + m;
        int endDay = d[2] - 1;
        if(endDay < 1){
            endDay = 28;
            endMonth--;
        }
        if(endMonth > 12){
            int tmp = endMonth % 12;
            endYear += (endMonth/12);
            if(tmp == 0) endMonth = 12;
            else endMonth = tmp;
        }
        if(todayYear < endYear) return false;
        else if(todayYear > endYear) return true;
        else{
            if(todayMonth < endMonth) return false;
            else if(todayMonth > endMonth) return true;
            else{
                if(todayDay <= endDay) return false;
                else return true;
            }
        }

    }
    static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int[] td = splitDate(today);

        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        for(int i = 0; i < privacies.length; i++){
            String[] privacyArr = privacies[i].split(" ");
            int[] d = splitDate(privacyArr[0]);
            String alpha = privacyArr[1];
            boolean result = calculate(td, d, termMap.get(alpha));
            if(result) answer.add(i+1);
        }
        int[] answer2 = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            answer2[i] = answer.get(i);
        }
        return answer2;
    }
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = new String[]{"A 6", "B 12", "C 3"};
        String[] privacies = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution(today, terms, privacies);
    }
}