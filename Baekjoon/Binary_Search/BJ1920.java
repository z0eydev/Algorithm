package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
    static int[] nums;
    static boolean binary_search(int key, int low, int high){
        int mid;

        if(low <= high){
            mid = (low + high) / 2;

            if(nums[mid] == key) return true;
            else if(nums[mid] < key) return binary_search(key, mid+1, high);
            else return binary_search(key, low, mid-1);
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        int num;
        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }

        Arrays.sort(nums);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int[] num_array = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            num = Integer.parseInt(st.nextToken());
            num_array[i] = num;
        }

        for(int key : num_array){
            boolean result = binary_search(key, 0, nums.length-1);
            if(result) System.out.println(1);
            else System.out.println(0);
        }
    }
}
