package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P14469_소가길을건너간이유3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cowCnt = Integer.parseInt(st.nextToken()); // 소의 수

        Cow[] cows = new Cow[cowCnt]; // 도착 시간, 검문 시간

        // 입력받기.
        for(int i = 0; i < cowCnt; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(allEntryTime(cows));
    }

    static public int allEntryTime(Cow[] cows){
        int result = 0;

        // 도착 시간별로 정렬 (먼저 온 소 부터 들어간다.)
        PriorityQueue<Cow> pq = new PriorityQueue<>(
                (c1, c2) -> Integer.compare(c1.arriveTime, c2.arriveTime)
        );

        for (Cow cow : cows) {
            pq.offer(cow);
        }

        while(!pq.isEmpty()){
            Cow cow = pq.poll();
            result = result < cow.arriveTime ? cow.arriveTime + cow.testTime: result + cow.testTime;
        }

        return result;
    }
}

class Cow implements Comparable<Cow> {
    int arriveTime;
    int testTime;

    public Cow(int arriveTime, int testTime){
        this.arriveTime = arriveTime;
        this.testTime = testTime;
    }

    @Override
    public int compareTo(Cow c){
        return Integer.compare(this.arriveTime, c.arriveTime);
    }
}

/* 개선 코드
* import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cowCnt = Integer.parseInt(br.readLine()); // 소의 수
        Cow[] cows = new Cow[cowCnt];

        for (int i = 0; i < cowCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int test = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arrive, test);
        }

        Arrays.sort(cows);  // 도착 시간 기준 정렬, Cow 클래스의 compareTo 사용

        int time = 0;
        for (Cow cow : cows) {
            if (time < cow.arriveTime) {
                time = cow.arriveTime;
            }
            time += cow.testTime;
        }

        System.out.println(time);
    }
}

class Cow implements Comparable<Cow> {
    int arriveTime;
    int testTime;

    public Cow(int arriveTime, int testTime) {
        this.arriveTime = arriveTime;
        this.testTime = testTime;
    }

    @Override
    public int compareTo(Cow c) {
        return Integer.compare(this.arriveTime, c.arriveTime);
    }
}
*/

/* 정렬 방법
Arrays.sort(cows); // Cow 클래스의 compareTo 사용
정렬을 위해 PriorityQueue를 사용했지만, 문제에서 소의 수는 100 이하로 많지 않기 때문에
단순히 Arrays.sort()를 사용하는 게 더 명확하고 직관적이다.
*/

/* 입력 처리
int cowCnt = Integer.parseInt(br.readLine());
한 줄에 하나의 숫자만 들어오기 때문에 StringTokenizer 없이도 충분
*/