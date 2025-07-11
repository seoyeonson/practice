package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P42646_더맵게 {
    public static void main(String[] args) throws IOException {
        // 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42626
        
        // 문제 해석
        // 우선순위 큐 (max, mini heap)
        // 예외처리가 많이 필요함
        // ex)
        // [1, 2, 3, 4, 5], k=100000이상이면 평생 안됌


        // 공부 순서
        // 1. 힙 자료 구조 공부 : 우선순위 큐 (max, mini heap)
        // 2. AI한테 문제를 주면서 힌트를 달라고 한다.
        // 3. 혼자서 풀어본다. (30~1시간)
        // 4. 풀이과정을 받고 리뷰한다.
        // 5. https://school.programmers.co.kr/learn/courses/30/lessons/138477 풀고 리뷰쓰기

        // 제한 사항
//        scoville의 길이는 2 이상으로 1,000,000 이하입니다.
//        K는 0 이상 1,000,000,000 이하입니다.
//        scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
//        모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

        // 입출력 결과
        // scoville = [1, 2, 3, 9, 10, 12]
        // k = 7
        // return = 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int sNo = Integer.parseInt(st.nextToken());
        int[] s = new int[sNo];
        for (int i = 0; i < sNo; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(s, k));


    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville) {
            pq.offer(s);
        }

        while(pq.size() >= 2 && pq.peek() < K) {
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.offer(food1 + food2*2);
            answer++;
        }

        if (pq.peek() < K) return -1;

        return answer;
    }
}
