package org.algorithm.solution;

import java.util.*;

public class P138477_명예의전당 {
    public static void main(String[] args) {
        // 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/138477

        // 제한 사항
        // 3 ≤ k ≤ 100
        // 7 ≤ score의 길이 ≤ 1,000
        // 0 ≤ score[i] ≤ 2,000

        // k : 명예의 전당 갯수
        // score : 각 일차별 점수 (매일 한명의 가수가 부르는 노래의 점수)
        // answer: 1일부터 n일까지 제공되는 최하위 점수 = score.length

        // 입출력 결과 예시
        //  [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]

        int k = 3;

        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int answer[] = new int[score.length];

//        PriorityQueue<Integer> rank = new PriorityQueue<>(Collections.reverseOrder()); // 사용되지 않아서 없어도 됨.
        PriorityQueue<Integer> lowestRank = new PriorityQueue<>();

        // 우선순위 큐로 score을 내림차순으로 추가한다.
        for (int i = 0; i < score.length; i++){
//            rank.offer(score[i]);

            // i일까지 중 k등수까지 오름차순으로 저장
            lowestRank.offer(score[i]);
            if(lowestRank.size() > k){
                lowestRank.poll();
            }
            // i일까지 중 가장 낮은 점수 추가
            answer[i] = lowestRank.peek();
        }

        for (int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

        /* 다른 사람 문제 풀이
        Integer[] scores = new Integer[score.length];

        return IntStream.range(0, score.length)
                .peek(i -> scores[i] = score[i])
                .map(i -> {
                    Arrays.sort(scores, 0, i + 1, Collections.reverseOrder(Integer::compare));
                    return i < k ? scores[i] : scores[k - 1];
                })
                .toArray();
         */
    }
}
