package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P2109_순회강연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 대학 개수
        Speech[] speechs = new Speech[n]; // 강의 정보

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            speechs[i] = new Speech(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 기간 순으로 정렬 (내림차순)
        Arrays.sort(speechs);
        
        // 가격 저장 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Speech speech : speechs) {
            pq.offer(speech.pay);
            if(pq.size() > speech.day) {
                pq.poll();
            }
        }

        int result = 0;
        while(!pq.isEmpty()) result += pq.poll();

        System.out.println(result);
    }
}

class Speech implements Comparable<Speech> {
    int pay; // 금액
    int day; // 기간

    // 생성자
    public Speech(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    // 정렬
    @Override
    public int compareTo(Speech s){
        if(this.day == s.day){ //기간이 같을 때
            // 금액 내림차순
            return Integer.compare(s.pay, this.pay);
        }
        // 기간은 오름차순
        return Integer.compare(this.day, s.day);
    }
}
