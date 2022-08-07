package com.company;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N == 10){
            System.out.println(-1);
            return;
        }

        boolean[][] edge = new boolean[6][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a][b] = true;
            edge[b][a] = true;
        }

        int cnt = 0;

        for(int i=1 ; i<5; i++){
            for(int j= i+2; j<=5 ;j++){
                if(j==i+1 ||j==i+4) continue;
                if(!edge[i][j]) continue;

                for(int p = i+1; p<5; p++){
                    for(int q = p+2; q<=5; q++){

                        if(!edge[p][q]) continue;
                        if(i<p && j<q && p<j) cnt++;
                    }
                }
            }
        }

        int answer = 0;

        if(cnt == 5) answer = 2;
        else if(cnt == 0);
        else answer = 1;


        System.out.println(answer);
    }
}