package Baekjoon.BackTracking.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    static int N;
    static int[] numList;
    static int[] operators;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void BackTracking(int num, int idx){
        if(idx == N){
            maxNum = Math.max(num, maxNum);
            minNum = Math.min(num, minNum);
        }
        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){
                operators[i]--;
                switch (i) {
                    case 0: BackTracking(num + numList[idx], idx+1); break;
                    case 1: BackTracking(num - numList[idx], idx+1); break;
                    case 2: BackTracking(num * numList[idx], idx+1); break;
                    case 3: BackTracking(num / numList[idx], idx+1); break;
                }
                operators[i]++;
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        numList = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for(int i = 0; i < 4; i++){
            int o = Integer.parseInt(st.nextToken());
            operators[i] = o;
        }

        BackTracking(numList[0], 1);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
