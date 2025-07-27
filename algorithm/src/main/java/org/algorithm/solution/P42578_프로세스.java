package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P42578_프로세스 {
    static public class Process implements Comparable<Process> {
        int priority;
        int idx;

        public Process(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }

        @Override
        public int compareTo(Process p){
            return Integer.compare(p.priority, this.priority); // 우선순위 내림차순
        }
    }
    public static void main(String[] args) throws IOException{
        // 내림차순 우선순위
        // 프로세스의 중요도가 담긴 배열 priorites
        // 프로세스 위치를 알려주는 location
        // location   0     1      2     3
        //          [A(2), B(1), C(3), D(2)]
        // location 2 => [C(3), D(2), A(2), B(1)] => return 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력
        int n = Integer.parseInt(br.readLine());
        int[] priorities = new int[n];
        int location = Integer.parseInt(br.readLine());

        for (int i =0; i < priorities.length; i++) {
            priorities[i] = Integer.parseInt(br.readLine());
        }

        Queue<Process> q = new LinkedList<>(); // 문서 관리 큐
        PriorityQueue<Process> pq = new PriorityQueue<>(); // 우선순위 큐 (판단용)
        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process(priorities[i], i);
            q.offer(p);
            pq.offer(p);
        }

        int count = 0;

        while(!q.isEmpty()){
            Process current = q.poll();
            if(current.priority != pq.peek().priority){
                q.offer(current);
            } else {
                pq.poll();
                count++;

                if(current.idx == location) break;
            }
        }

        System.out.println(count);
    }
}

/* 다른 풀이 1
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
 */
