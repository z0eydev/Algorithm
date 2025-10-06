package KAKAO.KAKAO_BLIND_RECRUITMENT_2023;
// 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
// 2. 이모티콘 판매액을 최대한 늘리는 것.
// 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.

import java.util.Arrays;

public class lv2_2 {
    static int[] discount = new int[]{10, 20, 30, 40};
    static int[] emoticonDiscount;
    static int emoticonCnt;
    static int emoticonPlus;
    static int totalCost;

    static public void result(int[][] users, int[] emoticons){
        int[] finalEmoticons = new int[emoticonCnt];
        int plusCnt = 0;
        int nowCost = 0;
        for(int i = 0; i < emoticonCnt; i++){
            finalEmoticons[i] = emoticons[i] * (100 - emoticonDiscount[i]) / 100;
        }
        for(int[] user : users){
            int cost = 0;
            for(int i = 0; i < emoticonCnt; i++){
                if(user[0] <= emoticonDiscount[i]) cost += finalEmoticons[i];
            }
            if(cost >= user[1]){
                cost = 0;
                plusCnt += 1;
            }
            nowCost += cost;
        }
        if(plusCnt > emoticonPlus){
            emoticonPlus = plusCnt;
            totalCost = nowCost;
        } else if(plusCnt == emoticonPlus){
            totalCost = Math.max(totalCost, nowCost);
        }
        return;
    }
    static public void setDiscount(int[] emoticons, int depth, int[][] users){
        if(depth == emoticonCnt){
            result(users, emoticons);
            return;
        }
        for(int i : discount){
            emoticonDiscount[depth] = i;
            setDiscount(emoticons, depth+1, users);
        }
    }
    static public int[] solution(int[][] users, int[] emoticons) {
        int[] answer;
        emoticonCnt = emoticons.length;
        emoticonDiscount = new int[emoticonCnt];
        setDiscount(emoticons, 0, users);
        answer = new int[]{emoticonPlus, totalCost};
        return answer;
    }
    public static void main(String[] args) {
        // int[][] users = new int[][]{{40, 10000}, {25, 10000}};
        int[][] users = new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        // int[] emoticons = new int[]{7000, 9000};
        int[] emoticons = new int[]{1300, 1500, 1600, 4900};
        int[] result = solution(users, emoticons);
        System.out.println(Arrays.toString(result));
    }
}
