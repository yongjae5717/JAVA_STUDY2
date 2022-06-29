package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] seq;
    static int[] count;
    static int[] next;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        count = new int[N];
        next = new int[N];
        int max =1;
        int maxIdx =0;
        Arrays.fill(count,1);
        Arrays.fill(next, 0);
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0; i < N ; i++){
           seq[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(seq[i]>seq[j]&&count[i]<count[j]+1){
                    count[i] = count[j]+1;
                    next[i] = i-j;
                    if(count[i]>max){
                        max= count[i];
                        maxIdx = i;
                    }
                }
            }
        }
        int idx = max;
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (count[i] == idx) {
                lis.add(seq[i]);
                idx--;
            }
        }
        Collections.sort(lis);


// wrong answer.
//        int idx = maxIdx;
//        StringBuilder sb = new StringBuilder();
//        while(next[idx]!=0){
//            idx -= next[idx];
//        }
//
//        int val = 0;
//        for(int i=idx; i<N; i++){
//            if(seq[i]>val){
//                val = seq[i];
//                sb.append(seq[i]).append(" ");
//            }
//        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lis.size(); i++){
            sb.append(lis.get(i)).append(" ");
        }


        System.out.println(max);
        System.out.print(sb.toString());
    }
}