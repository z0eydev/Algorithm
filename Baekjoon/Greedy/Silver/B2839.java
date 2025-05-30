// https://www.acmicpc.net/problem/2839
// 백준 silver4 설탕 배달(자바)
package Baekjoon.Greedy.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = -1;
        int cnt = 0;
        while(n >= 0){
            if(n%5 == 0){
                result = n/5 + cnt;
                break;
            }
            cnt += 1;
            n -= 3;
        }
        System.out.println(result);
    }
}