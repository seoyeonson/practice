package org.algorithm.solution;

import java.util.Scanner;

public class Day250513 {
    public static void main(String[] args) {
        // n값 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.println("성적의 개수를 입력하세요: ");
        int num = sc.nextInt();

        // 시험성적 입력 받기
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("성적을 입력하세요. (" + num + "개 입력) =>" +  (i+1) + "번째: ");
            arr[i] = sc.nextInt();
        }

        // 최대 성적 저장, 총합
        int max = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            sum += arr[i];
        }

        // 평균값 계산 (a+b+c .. )*100/M/N
        System.out.println(Float.valueOf(sum*100/max/num));
    }
}
