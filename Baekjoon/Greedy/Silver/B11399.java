// https://www.acmicpc.net/problem/11399
// 백준 silver4 ATM(자바)

package Baekjoon.Greedy.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] P = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);

        int result = 0;
        int wait = 0;

        for(int p : P){
            wait += p;
            result += wait;
        }

        System.out.println(result);

    }
}
