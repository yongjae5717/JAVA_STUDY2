package elwlahd555.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2470_두_용액 {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
 
    static int pick1 = -1;
    static int pick2 = -1;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int n = stoi(br.readLine());
        int[] arr = new int[n];
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = stoi(st.nextToken());
 
        Arrays.sort(arr);
 
        solution(n, arr);
 
        System.out.println(pick1 + " " + pick2);
    }
 
    static void solution(int n, int[] arr) {
        int left = 0;
        int right = n-1;
        int max = 2000000000;
 
        while(left < right) {
            int sum = arr[left] + arr[right];
 
            // 두 용액 갱신
            if(Math.abs(sum) < max) {
                pick1 = arr[left];
                pick2 = arr[right];
                max = Math.abs(sum);
            }
 
            if(sum > 0)
                right--;
            else
                left++;
        }
    }
}