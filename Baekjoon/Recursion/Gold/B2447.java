package Baekjoon.Recursion.Gold;

import java.io.*;

public class B2447 {

    static char[][] starArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //3의 거듭제곱

        starArray = new char[N][N]; //별 찍는 배열

        checkStar(0, 0, N, false); //함수 초기 호출(시작 0, 0 크기 N, 공백 아님)

        //별 출력하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(starArray[i][j]);
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    //시작 x축, 시작 y축, 크기 N, 공백 여부
    static void checkStar(int x, int y, int N, boolean blank) {

        //공백일 경우
        if (blank) {
            //시작 점 x, y 부터 해당 구역의 크기 만큼(N)
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    starArray[i][j] = ' ';
                }
            }
            return;
        }

        //더이상 쪼갤 수 없을 때
        if(N <= 1){
            //더이상 쪼갤 수 없는 값은 중간 값도 구할 수 없기 때문에 무조건 별(*)
            starArray[x][y] = '*';
            return;
        }

        int blockSize = N/3; //N은 3의 거듭제곱임으로 한 블록의 사이즈를 구하기 위해선  3으로 나눈다
        int startCount = 0; //별 공백 기준을 체크하는 변수, 별 구역 누적

        //구역으로 구분하는 것이므로 증가값이 블록사이즈만큼 증가해야한다.
        for(int i = x; i < x + N; i+=blockSize){
            for(int j = y; j < y + N;j+=blockSize){
                startCount++;
                //N이 3, 9, 27 .. 3의 거듭제곱일 때 9개의 구역을 나눈다.
                // => 9개의 구역으로 나눴을 때 5번째가 무조건 공백이다.
                if(startCount == 5){
                    checkStar(i, j, blockSize, true);
                }else{
                    checkStar(i, j, blockSize, false);
                }
            }
        }
    }
}