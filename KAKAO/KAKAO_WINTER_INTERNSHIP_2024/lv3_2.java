package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class lv3_2 {
    static int cardLen; // card의 개수
    static int cardCnt; // 처음 card의 개수
    static HashMap<Integer, Integer> cardLocation = new HashMap<>();
    static PriorityQueue<int[]> enable;
    static Set<Integer> used = new HashSet<>();
    static int round = 1; // 진행한 카드게임 라운드 수
    static int possible = 0;

    static public void addHeapq(int pair, int location, int need){
        int[] tmp;
        if(location < cardCnt) tmp = new int[]{0, pair, need};
        else{
            int r = (location - (cardCnt - 2)) / 2;
            tmp = new int[]{r, pair, need};
        }
        enable.offer(tmp);
    }

    static public void makeHeapq(int start, int end, int[] cards, int need){
        for(int i = start; i < end; i++){
            int pair1 = cards[i];
            if(used.contains(pair1)) continue;
            int pair2 = cardLen + 1 - pair1;
            int location = cardLocation.get(pair2);
            if(i > location) addHeapq(pair1, i, need);
            else addHeapq(pair2, location, need);
            used.add(pair1);
            used.add(pair2);
        }
    }

    static public int solution(int coin, int[] cards) {
        cardLen = cards.length;
        enable = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[2], b[2]);
            }
        );

        // Map에 card의 인덱스 위치를 저장
        for(int i = 0; i < cardLen; i++){
            cardLocation.put(cards[i], i);
        }

        cardCnt = cardLen/3;
        int ableRound = (cardLen - cardCnt) / 2 + 1;
        makeHeapq(0, cardCnt, cards, 0);
        while(!enable.isEmpty() && round < ableRound){
            int[] cur = enable.poll();
            if(cur[0] == 0 && cur[0] <= round) round += 1;
            else if(coin > 0 && cur[0] <= round){
                round += 1;
                if(cur[0] > 0) coin -= 1;
            }else {
                enable.offer(cur);
                break;
            }
        }
        makeHeapq(cardCnt, cardLen, cards, 1);
        if(coin <= 1) return round;
        while(coin > 0 && !enable.isEmpty() && round < ableRound){
            int[] cur = enable.poll();
            if(cur[0] <= round){
                if(cur[2] == 1){
                    if(coin < 2){
                        if(cur[0] > round) break;
                        continue;
                    }
                    round += 1;
                    coin -= 2;
                } else{
                    round += 1;
                    coin -= 1;
                }
            } else break;
        }
        return round;
    }
    public static void main(String[] args) {
        int coin = 3;
        int[] cards = new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        // int[] cards = new int[]{1, 12, 2, 11, 3, 10, 4, 9, 5, 8, 6, 7};
        // int[] cards = new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7};
        // int[] cards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(solution(coin, cards));
    }
}