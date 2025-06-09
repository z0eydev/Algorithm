// https://www.acmicpc.net/problem/1931
// 백준 gold5 회의실 배정

package Baekjoon.Greedy.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] timeList = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] time = new int[]{s, e};
            timeList[i] = time;
        }
        Arrays.sort(timeList, (x, y) -> {
            if(x[1] != y[1]){
                return x[1] - y[1];
            }else{
                return x[0] - y[0];
            }
        });

        int answer = 1;
        int endTime = timeList[0][1];

        for(int i = 1; i < N; i++){
            if(endTime>timeList[i][0]) continue;
            endTime = timeList[i][1];
            answer += 1;
        }

        System.out.println(answer);
    }
}
