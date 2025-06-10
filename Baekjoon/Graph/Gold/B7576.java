// https://www.acmicpc.net/problem/7576
// 백준 gold5 토마토 BFS
package Baekjoon.Graph.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B7576 {
    static int M, N;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int totalCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] tomatoBox = new int[N][M];
        PriorityQueue<int[]> ripeTomatoes = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int e = Integer.parseInt(st.nextToken());
                if (e == 1) {
                    tomatoBox[i][j] = 1;
                    int[] ripeTomato = new int[]{0, i, j};
                    ripeTomatoes.offer(ripeTomato);
                    totalCnt += 1;
                }
                else if(e == -1) {
                    tomatoBox[i][j] = -1;
                    totalCnt += 1;
                }
            }
        }

        int result = -1;
        while (!ripeTomatoes.isEmpty()){
            if(totalCnt == N*M) break;
            int[] ripeTomato = ripeTomatoes.poll();
            result = ripeTomato[0];
            int x = ripeTomato[1];
            int y = ripeTomato[2];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && tomatoBox[nx][ny] == 0){
                    tomatoBox[nx][ny] = 1;
                    ripeTomato = new int[]{result + 1, nx, ny};
                    ripeTomatoes.offer(ripeTomato);
                    totalCnt += 1;
                }
            }
        }
        if(totalCnt == N*M) System.out.println(result+1);
        else System.out.println(-1);

    }
}
