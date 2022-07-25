package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    static int N;
    static int M;
    static int[] parent;
    static int[][] pos;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

       String[] input = br.readLine().split(" ");
       N = Integer.parseInt(input[0]);
       M = Integer.parseInt(input[1]);

        PriorityQueue<NodeInfo> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));
        parent = new int[N+1];
        pos = new int[N+1][2];
        for(int i=0; i<N+1; i++) parent[i] = i;

        for(int i=1; i< N+1; i++){
           String[] position = br.readLine().split(" ");
           pos[i][0] = Integer.parseInt(position[0]);
           pos[i][1] = Integer.parseInt(position[1]);
       }

        for(int i=1; i< N+1; i++){
            for(int j= i+1; j<N+1; j++){
               pq.offer(new NodeInfo(i,j,getDistance(pos[i],pos[j])));
            }
        }



       for(int j=0; j<M; j++){
           String[] node = br.readLine().split(" ");
           int a = Integer.parseInt(node[0]);
           int b = Integer.parseInt(node[1]);
           union(a,b);
       }

       int count = 0;
       double distance = 0.d;
       while(count<N-M-1){
           NodeInfo nodeInfo = pq.poll();
           if(find(nodeInfo.nodeA) == find(nodeInfo.nodeB)) continue;
           else{
               count++;
               distance += nodeInfo.distance;
               union(nodeInfo.nodeA, nodeInfo.nodeB);
           }

       }

       System.out.println(String.format("%.2f",distance));
    }
    public static double getDistance(int[] posA, int[] posB){
       return Math.sqrt( Math.pow((posA[0]-posB[0]),2)+Math.pow((posA[1]-posB[1]),2));
    }
    public static int find(int a){
        if(parent[a]!= a){
             return parent[a] = find(parent[a]);
        }else return a;
    }


    public static void union(int a, int b){

        a = find (a);
        b = find (b);

        if(a!=b) parent[b] = a;

    }

}

class NodeInfo {
    int nodeA;
    int nodeB;
    double distance;

    public NodeInfo(int a, int b, double d){
        nodeA = a;
        nodeB = b;
        distance = d;
    }

}