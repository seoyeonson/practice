package org.algorithm;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    static int check = 0;

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0, 0};

        answer[0] = numer1 * denom2 + numer2 * denom1;
        answer[1] = denom1 * denom2;

        while (true) {
            IntStream.range(2, answer[1]).forEach(i->{
                if(answer[0]%i == 0 && answer[1]%i == 0){
                    answer[0] = answer[0]/i;
                    answer[1] = answer[1]/i;
                } else {
                    check++;
                }
            });

            if(check != 0) {break;}
        }

        return answer;
    }
}