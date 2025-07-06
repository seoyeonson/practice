package org.algorithm.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_구간합구하기{
    public static void main(String[] args) throws IOException {
        // Scanner은 BufferedReader에 비해서 사용하기 용이한 메서드들을 클래스에서 많이 제공하여
        // 자료형을 처리하거나 간단하게 입력을 처리하기에 용이하다.
        // 하지만 데이터를 파싱하기 위해서 내부적으로 정규 표현식 등을 사용하여
        // BufferedReader에 비해 내부적으로 복잡한 과정을 거쳐 처리시간이 더 오래 걸린다.

        // 입력량이 고정되어 있고, 그 양이 많지 않은 경우에는
        // Scanner를 사용

        // 입력량이 정해져 있지 않거나, 많은 경우에는
        // BufferedReader의 사용

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        // 입력을 받아온다.
        // 구분자 지정을 생략하면 공백이나 탭이 기본 구분자
        StringTokenizer stringTokenizer
                = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        // 합이나 곱 등의 연산 후 데이터가 크면 문제가 생길 수 있기 때문에 long을 사용
        long[] S = new long[suNo + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= suNo; i++){
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
