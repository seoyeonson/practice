package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P12927_야근지수 {
    public static void main(String[] args) throws IOException {

        // 일할 수 있는 시간 n
        int n = 3;
        // 주어진 작업량 works
        int[] works = {1, 1};
        long result = 0;

        // 주어진 작업량을 우선순위 큐에 넣는다 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }

        // for 문을 돌면서 -1을 한 뒤 다시 우선순위 큐에 넣는 작업을 반복
        for(int i = 0; i < n; i++){
            int max = pq.poll();
            if(max <= 0) break;
            pq.offer(max - 1);
        }

        // 결과값을 제곱해서 출력한다.
        while(!pq.isEmpty()){
            int work = pq.poll();
            result += (long) work * work;
        }

        System.out.println(result);
    }
}
