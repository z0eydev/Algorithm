// https://www.acmicpc.net/problem/15686

package Baekjoon.BackTracking.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location{
    int x;
    int y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class B15686 {
    static int N, M;
    static int[][] maps;
    static ArrayList<Location> house, chicken;
    static boolean[] openChicken;
    static int answer = Integer.MAX_VALUE;
    static int result;

    // cnt : open한 치킨집 개수
    static void DFS(int idx, int cnt){
        if(cnt == M){
            result = 0;
            for(int i = 0; i < house.size(); i++){
                int tmp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if(openChicken[j]){
                        tmp = Math.min(tmp, (Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y)));
                    }
                }
                result += tmp;
            }
            answer = Math.min(answer, result);
            return;
        }

        for(int i = idx; i < chicken.size(); i++){
            openChicken[i] = true;
            DFS(i+1, cnt+1);
            openChicken[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                maps[i][j] = num;
                if(num == 1) house.add(new Location(i, j));
                if(num == 2) chicken.add(new Location(i, j));
            }
        }

        openChicken = new boolean[chicken.size()];
        DFS(0, 0);
        System.out.println(answer);
    }
}
