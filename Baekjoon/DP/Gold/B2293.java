// https://www.acmicpc.net/problem/2293

package Baekjoon.DP.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2293 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        dp[0] = 1;
        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int coin : coins){
            for(int i = coin; i <= k; i++){
                dp[i] += dp[i-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
