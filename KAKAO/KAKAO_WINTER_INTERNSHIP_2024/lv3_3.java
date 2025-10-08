package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

// 시작이 0일 때 : x = 3 // next = 2
// 시작이 1일 때 : x = 4 // next = 3
// 그 다음이 0일 때 : x = x * 2 + next * 1 // next = x * 1 + next
// 그 다음이 1일 때 : x = x * 3 + next * 1 // next = x * 2 + next

public class lv3_3 {
    static public int solution(int n, int[] tops) {
        int answer = 0;
        int x;
        int next;
        if(tops[0] == 0){
            x = 3;
            next = 2;
        }else{
            x = 4;
            next = 3;
        }
        for(int i = 1; i < n; i++){
            int tmp = 0;
            if(tops[i] == 0){
                tmp = 2 * x + next;
                next = x + next;
                x = tmp;
            }else{
                tmp = 3 * x + next;
                next = 2 * x + next;
                x = tmp;
            }
        }
        answer = x % 10007;
        return answer;
    }
    public static void main(String[] args) {
        // int n = 4;
        // int[] tops = new int[]{1, 1, 0, 1};
        // int n = 2;
        // int[] tops = new int[]{0, 1};
        int n = 10;
        int[] tops = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution(n, tops));
    }
}
