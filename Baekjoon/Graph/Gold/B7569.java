// https://www.acmicpc.net/problem/7569
// 백준 gold5 토마토 BFS

package Baekjoon.Graph.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 1, 0, -1};
    static int[] dz = new int[]{0, 0, 1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[h][n][m];
        Queue<int[]> ripeTomatoes = new ArrayDeque<>();
        int count = 0;
        int turn = -1;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    int state = Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = state;
                    if (state != 0){
                        count++;
                        if(state == 1){
                            int[] ripeTomato = new int[]{i, j, k, turn+1};
                            ripeTomatoes.add(ripeTomato);
                        }
                    }
                }
            }
        }

        while(!ripeTomatoes.isEmpty()){
            if(count==n*m*h) break;
            int[] r = ripeTomatoes.poll();
            turn = r[3];
            for(int i = 0; i < 6; i++){
                int nx = r[0] + dx[i];
                int ny = r[1] + dy[i];
                int nz = r[2] + dz[i];
                if(0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m && tomatoes[nx][ny][nz] == 0){
                    int[] ripeTomato = new int[]{nx, ny, nz, turn+1};
                    ripeTomatoes.add(ripeTomato);
                    tomatoes[nx][ny][nz] = 1;
                    count++;
                }
            }
        }

        if(count < n*m*h) System.out.println(-1);
        else System.out.println(turn+1);
    }
}
