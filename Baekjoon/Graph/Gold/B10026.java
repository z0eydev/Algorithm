// https://www.acmicpc.net/problem/10026
// 백준 gold5 적록색약

// 적록색약 (R과 G 구분하지 못함)
// 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램

package Baekjoon.Graph.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B10026 {
    static int n;
    static boolean[][] colorArrayBoolean;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    // 적록색약이 아닌 경우
    static void findColorZone(String[][] colorArray, int a, int b){
        Deque<int[]> q = new ArrayDeque<>();
        int[] coor = new int[]{a, b};
        String color = colorArray[a][b];
        q.offer(coor);
        while(!q.isEmpty()){
            int[] c = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !colorArrayBoolean[nx][ny] && colorArray[nx][ny].equals(color)){
                    coor = new int[]{nx, ny};
                    q.offer(coor);
                    colorArrayBoolean[nx][ny] = true;
                }
            }
        }
        return;
    }

    // 적록색약인 경우
    static void findColorZoneBlind(String[][] colorArray, int a, int b){
        Deque<int[]> q = new ArrayDeque<>();
        int[] coor = new int[]{a, b};
        String color = colorArray[a][b];
        q.offer(coor);
        while(!q.isEmpty()){
            int[] c = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                if(color.equals("R") || color.equals("G")){
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !colorArrayBoolean[nx][ny] && !colorArray[nx][ny].equals("B")){
                        coor = new int[]{nx, ny};
                        q.offer(coor);
                        colorArrayBoolean[nx][ny] = true;
                    }
                } else{
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !colorArrayBoolean[nx][ny] && colorArray[nx][ny].equals(color)){
                        coor = new int[]{nx, ny};
                        q.offer(coor);
                        colorArrayBoolean[nx][ny] = true;
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[][] colorArray = new String[n][n];
        colorArrayBoolean = new boolean[n][n];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                String color = String.valueOf(line.charAt(j));
                colorArray[i][j] = color;
            }
        }

        // 적록색약이 아닌 경우
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!colorArrayBoolean[i][j]) {
                    colorArrayBoolean[i][j] = true;
                    findColorZone(colorArray, i, j);
                    count++;
            }
        }
        }
        sb.append(count+" ");

        // 적록색약인 경우
        colorArrayBoolean = new boolean[n][n];
        count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!colorArrayBoolean[i][j]) {
                    colorArrayBoolean[i][j] = true;
                    findColorZoneBlind(colorArray, i, j);
                    count++;
            }
        }
        }
        sb.append(count);

        System.out.println(sb.toString());
    }
}
