package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P42627_디스크컨트롤러 {
    // 작업의 번호, 작업의 요청 시각, 작업의 소요 시간
    // 작업 소요 시간이 짧은 것, 작업의 요청 시간이 빠른 것, 작업의 번호가 작은 것 순
    // 한 작업이 끝날 때 까지 그 작업만 실행함
    static class Job implements Comparable<Job>{
        int number;
        int requestTime;
        int workTime;

        public Job(int number, int requestTime, int workTime){
            this.number = number;
            this.requestTime = requestTime;
            this.workTime = workTime;
        }

        @Override
        public int compareTo(Job j){
            if(this.workTime == j.workTime){
                if(this.requestTime == j.requestTime) {
                    return Integer.compare(this.number, j.number);
                }
                return Integer.compare(this.requestTime, j.requestTime);
            }
            return Integer.compare(this.workTime, j.workTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] jobs = new int[3][2];

        for(int i = 0; i < jobs.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(jobs));
    }

    static public int solution(int[][] jobs){
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0])); // 요청 시각 기준 정렬

        PriorityQueue<Job> pq = new PriorityQueue<>();

        int time = 0; // 현재 시간
        int idx = 0; // jobs 베열 인덱스
        int total = 0; // 총 소요 시간
        int count = jobs.length;

        // 아직 처리하지 않는 작업이 남아있거나 큐에 대기 중인 작업이 있다면
        while (idx < count || !pq.isEmpty()) {
            // 현재 시간보다 요청 시간이 작거나 같은 작업을 큐에 넣음
            // jobs[idx]를 안전하게 접근하기 위한 필수 안전장치
            while (idx < count && jobs[idx][0] <= time) {
                pq.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.workTime;
                total += time - job.requestTime; // 종료시간 - 요청시간
            } else {
                time = jobs[idx][0]; // 작업이 없으면 시간 점프
            }
        }

        return total / count;
    }
}

/*
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0])); // 요청 시점 순 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업시간 기준 정렬

        int time = 0;      // 현재 시간
        int idx = 0;       // jobs 인덱스
        int totalTime = 0; // 총 작업 시간
        int count = 0;     // 완료된 작업 수

        while (count < jobs.length) {
            // 현재 시간까지 요청된 모든 작업 PQ에 추가
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1]; // 작업 수행
                totalTime += time - job[0]; // (끝난 시각 - 요청 시각)
                count++;
            } else {
                // 대기 중인 작업이 없으면 다음 작업의 요청 시각으로 이동
                time = jobs[idx][0];
            }
        }

        return totalTime / jobs.length;
    }
}

 */