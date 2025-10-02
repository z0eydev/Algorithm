package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

public class lv3_2 {
    static int round = 1; // 진행한 카드게임 라운드 수



    static public int solution(int coin, int[] cards) {

        return round;
    }
    public static void main(String[] args) {
        int coin = 4;
        int[] cards = new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        // int[] cards = new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12};
        // int[] cards = new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7};
        // int[] cards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(solution(coin, cards));
    }
}
