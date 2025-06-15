// https://www.acmicpc.net/problem/11729
// 백준 gold5 하노이탑 이동 순서 Recrusion

package Baekjoon.Recursion.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11729 {
    static StringBuilder sb = new StringBuilder();
    static int count;

    static void hanoi(int n, int from, int to, int others){
        count++;
        if(n == 1){
            sb.append(from + " " + to + "\n");
            return;
        }else{
            // N-1 1 -> 2
            hanoi(n-1, from, others, to);
            // N 1 -> 3
            sb.append(from + " " + to + "\n");
            // N-1 2 -> 3
            hanoi(n-1, others, to, from);
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
