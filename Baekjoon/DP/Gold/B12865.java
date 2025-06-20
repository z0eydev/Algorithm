// https://www.acmicpc.net/problem/12865
// 백준 gold5 평범한 배낭 DP

package Baekjoon.DP.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		int[] dp = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = K; j - W[i] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
			}
		}
		System.out.println(dp[K]);
	}
}