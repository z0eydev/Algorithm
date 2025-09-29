package KAKAO.KAKAO_BLIND_RECRUITMENT_2023;
import java.util.*;

public class lv2_1 {
        static public int[] round(int[] l, int n, int total){
        for(int i = n; i >= 0; i--){
            if(total > l[i]){
                total -= l[i];
                l[i] = 0;
            } else if(total == l[i]){
                l[i] = 0;
                break;
            }else{
                l[i] -= total;
                break;
            }
        }
        return l;

    }
    static public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int location = n-1;
        while(location >= 0){
            if(deliveries[location] > 0 || pickups[location] > 0){
                answer += (location+1);
                deliveries = round(deliveries, location, cap);
                pickups = round(pickups, location, cap);
            } else location -= 1;
        }
        return answer*2;
    }
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[]{1, 0, 3, 1, 2};
        int[] pickups = new int[]{0, 3, 0, 4, 0};
        long answer = solution(cap, n, deliveries, pickups);
        System.out.println(answer);
    }
}
