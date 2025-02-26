package org.algorithm.solution;

import java.util.Arrays;

public class Day250226 {
    public double solution(int[] numbers) {
        double answer = 0;

        double result  = Arrays.stream(numbers).average().getAsDouble();

        result = result - (int)result == 0 || result - (int)result == 0.5 ? result : Math.round(result);
        System.out.println("answer" + result);
        return answer;
    }
}
