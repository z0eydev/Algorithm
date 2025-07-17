// https://www.acmicpc.net/problem/1753
package Baekjoon.Graph.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1753 {
    static class Node{
        int to, value;
        public Node(int to, int value){
            this.to = to;
            this.value = value;
        }
    }
    static class PqFormat implements Comparable<PqFormat>{
        int index, dist;
        PqFormat(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        @Override
        public int compareTo(PqFormat o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Node>[] connections = new ArrayList[v+1];
        for(int i = 1; i <= v; i++){
            connections[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            connections[start].add(new Node(end, value));
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean visited[] = new boolean[v+1];

        PriorityQueue<PqFormat> pq = new PriorityQueue<>();
        pq.add(new PqFormat(k, 0));

        while(!pq.isEmpty()){
            PqFormat now = pq.poll();
            if(visited[now.index]) continue;

            visited[now.index] = true;
            for(Node node : connections[now.index]){
                if(dist[node.to] > dist[now.index] + node.value){
                    dist[node.to] = dist[now.index] + node.value;
                    pq.add(new PqFormat(node.to, dist[node.to]));
                }
            }
        }
        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
