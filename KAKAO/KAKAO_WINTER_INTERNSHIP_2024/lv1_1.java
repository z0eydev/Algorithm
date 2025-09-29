package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lv1_1 {
    static int solution(String[] friends, String[] gifts) {
        // 친구들의 인덱스 저장 배열
        Map<String, Integer> friendsIdx = new HashMap<>();
        for(int i = 0 ; i < friends.length; i++){
            friendsIdx.put(friends[i], i);
        }

        // 친구 이차원 배열
        // Q friends.length를 따로 변수를 저장하는게 좋은지? 추후에 자주 쓰인다면
        // Q split할 때, 만약 "1 2"를 스플리트해서 int[]에 어떻게 담는지
        int[][] friendsGift = new int[friends.length][friends.length];
        // 선물 지수 배열
        int[] GiftNum = new int[friends.length];
        for(String gift : gifts){
            String[] giftSplit = gift.split(" ");
            int giveIdx = friendsIdx.get(giftSplit[0]);
            int takeIdx = friendsIdx.get(giftSplit[1]);
            friendsGift[giveIdx][takeIdx] += 1;
            GiftNum[giveIdx] += 1;
            GiftNum[takeIdx] -= 1;
        }
        // 선물 받은 수 배열
        int[] GiftCnt = new int[friends.length];

        // 친구별로 돌면서
        // 1. friendsGift[i][j]랑 friendsGift[j][i] 둘 다 0이 넘는지 / 넘으면 숫자가 더 큰 친구의 GiftCnt += 1하기
        // 2. 하나라도 0이 안 넘으면 선물 지수 비교해서 더 큰 선물지수가 GiftCnt += 1
        // 3. 선물지수까지 같으면 PASS
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                if(i>=j) continue;
                int friend1 = friendsGift[i][j];
                int friend2 = friendsGift[j][i];
                if((friend1 > 0 || friend2 > 0) && friend1 != friend2){
                    if(friend1 > friend2) GiftCnt[i] += 1;
                    else if(friend2 > friend1) GiftCnt[j] += 1;
                }
                else{
                    if(GiftNum[i] < GiftNum[j]) GiftCnt[j] += 1;
                    else if(GiftNum[j] < GiftNum[i]) GiftCnt[i] += 1;
                    else continue;
                }
            }
        }
        return Arrays.stream(GiftCnt).max().getAsInt();
    }
    public static void main(String[] args) {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));

    }
}
