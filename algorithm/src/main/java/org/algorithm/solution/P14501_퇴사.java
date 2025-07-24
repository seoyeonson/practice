package org.algorithm.solution;

import java.io.*;
import java.util.*;

public class P14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 금액
        int[] dp = new int[N + 2]; // 최대 수익 저장 (N+1일까지)

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        for(int i = N; i > 0; i--){
            if(i + T[i] > N+1){
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i+T[i]]+P[i]);
            }
        }

        System.out.println(dp[1]);

/* 방법 2.
        for (int i = 1; i <= N; i++) {
            // 현재까지의 이익을 다음 날로 넘김 (상담을 하지 않는 경우)
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 상담 가능한 경우만 처리
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }


        // 최댓값 계산 (N+1까지 중 가장 큰 값)
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
 */
    }
}
