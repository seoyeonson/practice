package org.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] result = solution.solution(1,2,3,4);
        Arrays.stream(result).forEach(System.out::println);
    }
}

class Solution {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1*denom2;
        int max = 1;

        for(int i = 1; i<=numer && i<=denom; i++){
            if(numer%i==0 && denom%i==0){
                max = i;
            }
        }

        numer /= max;
        denom /= max;

        int[] answer = {numer,denom};

        return answer;
    }
}