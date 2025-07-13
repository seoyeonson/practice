package org.algorithm.solution;
import java.io.*;
import java.util.*;

public class P1931_회의실배정 {
    static class Meeting implements Comparable<Meeting>{
        int startTime; // 시작시간
        int endTime; // 끝나는 시간

        public Meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting m){
            if(this.endTime == m.endTime) { // 끝나는 시간이 같다면
                return Integer.compare(this.startTime, m.startTime); // 시작 시간이 빠른 순
            }
            return Integer.compare(this.endTime, m.endTime); // 끝나는 시간 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        // 회의실 개수 N
        // 회의 (시작시간, 끝나는 시간)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        int availableTime  = 0; // 가능한 시간
        int count = 0; // 가능한 회의 개수

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        for(Meeting meeting : meetings) {
            if(meeting.startTime >= availableTime) {
                availableTime = meeting.endTime;
                count++;
            }
        }

        System.out.println(count);
    }
}