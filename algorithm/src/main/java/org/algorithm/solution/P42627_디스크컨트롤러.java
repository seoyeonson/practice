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
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0])); // 요청 시각 기준 정렬

        PriorityQueue<Job> pq = new PriorityQueue<>();

        return 0;
    }
}

/*
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
*/