// https://www.acmicpc.net/problem/1715
// 백준 gold4 카드 정렬하기

package Baekjoon.Greedy.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            int bundle = first + second;
            result += bundle;
            pq.add(bundle);
        }

        System.out.println(result);
    }
}
