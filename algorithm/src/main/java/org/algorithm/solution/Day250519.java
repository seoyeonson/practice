package org.algorithm.solution;

import java.util.Scanner;

public class Day250519 {
    public static void main(String[] args) {
        // 데이터(n), 줄(m) 입력
        int n = 0;
        int m = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("데이터 배열 크기, 줄 입력: ");
        n = sc.nextInt();
        m = sc.nextInt();

        int[] data = new int[n+1];


        // 데이터 입력 및 구간합
        for (int i = 1; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        for (int i = 1; i < data.length; i++) {
            data[i] += data[i-1];
        }

        // 입력 받은 결과 도출
        for (int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(data[end] - data[start-1]);
        }
    }
}
