package KAKAO.KAKAO_WINTER_INTERNSHIP_2024;

import java.util.*;

public class lv3_1 {
    static int l;
    static int[] tmp;
    static Set<Integer> dice1  = new HashSet<>();
    static Set<Integer> dice2;
    static int[][] dices;
    static ArrayList<Integer> hapArr = new ArrayList<>();
    static ArrayList<Integer> hapArr1;
    static ArrayList<Integer> hapArr2;
    static int result = 0;
    static int[] answer = new int[l/2];

    static public int binarySearch(int n, ArrayList<Integer> arr){
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            if(arr.get(mid) >= n) end = mid-1;
            else start = mid + 1;
        }
        return start;
    }

    static public void calculateHapArray(int[] arr, int depth){
        if(depth == arr.length){
            return;
        }
        int idx = arr[depth];
        if(hapArr.size() == 0){
            for(int i = 0; i < 6; i++){
                hapArr.add(dices[idx-1][i]);
            }
        }else{
            int size = hapArr.size();
            for(int i = 0; i < size; i++){
                int tmp = hapArr.remove(0);
                for(int j = 0; j < 6; j++){
                    hapArr.add(tmp + dices[idx-1][j]);
                }
            }
        }
        calculateHapArray(arr, depth+1);
    }

    static public void makeArr(int[] tmp){
        dice2 = new HashSet<>();
        hapArr1 = new ArrayList<>();
        hapArr2 = new ArrayList<>();
        for(int i : tmp){
            dice2.add(i);
        }
        dice1.removeAll(dice2);
        int[] tmp2 = new int[l/2];
        int idx = 0;
        for(int i : dice1){
            tmp2[idx++] = i;
        }
        hapArr = new ArrayList<>();
        calculateHapArray(tmp, 0);
        hapArr1 = hapArr;
        hapArr = new ArrayList<>();
        calculateHapArray(tmp2, 0);
        hapArr2 = hapArr;

        Collections.sort(hapArr1);
        Collections.sort(hapArr2);
        int total = 0;
        int rtotal = 0;
        for(int i : hapArr1){
            int t = binarySearch(i, hapArr2);
            total += t;
        }
        for(int i : hapArr2){
            int t = binarySearch(i, hapArr1);
            rtotal += t;
        }
        if(total > result) {
            result = total;
            answer = tmp.clone();
        }
        if(rtotal > result){
            result = rtotal;
            answer = tmp2.clone();
        }
        dice1.addAll(dice2);
    }

    static public void combin(int idx, int n){
        if(idx == (l/2)){
            makeArr(tmp);
            return;
        }
        for(int i = n; i <= l; i++){
            tmp[idx] = i;
            combin(idx+1, i+1);
        }
    }
    static public int[] solution(int[][] dice) {
        dices = dice;
        l = dice.length;
        for(int i = 1; i <= l; i++){
            dice1.add(i);
        }
        tmp = new int[l/2];
        tmp[0] = 1;
        combin(1, 2);
        return answer;
    }
    public static void main(String[] args) {
        // int[][] dice = new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        int[][] dice = new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
