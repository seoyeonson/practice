package org.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution(10);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int n) {
        int answer = 1;
        int r = 6;

        while(r%n != 0){
            answer++;
            r = (r%n) + 6;
        }
        return answer;
    }
}