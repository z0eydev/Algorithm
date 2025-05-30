// https://www.acmicpc.net/problem/1744
// 백준 gold4 수 묶기
package Baekjoon.Greedy.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1744 {
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minusList = new PriorityQueue<>();
        PriorityQueue<Integer> plusList = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0){
                minusList.add(num);
            }else if(num == 1){
                result += 1;
            }else{
                plusList.add(num);
            }
        }
        calculate(minusList);
        calculate(plusList);
        System.out.println(result);
    }
    public static void calculate(PriorityQueue<Integer> pq){
        while(pq.size() > 0){
            if(pq.size() == 1){
                result += pq.poll();
                break;
            }
            result += (pq.poll() * pq.poll());
        }
    }
}
