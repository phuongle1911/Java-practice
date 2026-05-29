package homework3;

import java.util.ArrayList;

class arrayDeletion {
  public static int solution(int[] A) {
    // number of num at even index = number of num at odd index + 1
    // num at even index need to be highest, num at odd index need to be lowest
    // compare each number in array with number next to it
    // if even index number <= odd index number next to it --> delete even index number
    // else: --> no change
    // if odd index number < even index number next to it --> no change
    // else: delete odd index number

    int S = 0;
    boolean peak = true;

    for (int i = 0; i<A.length-1; i++) {
      if (peak) {
        if (A[i] > A[i+1]) {
          S += A[i];
          peak = false;
        }
      } else {
        if (A[i+1] < A[i+2]) {
          S = S - A[i+1];
          peak = true;
        }
      }
    }

    return S % 1000000000;
  }

  public static void main(String[] args) {
    int[] A = {1,2,3,3,2,1,5};
    // 6 - (-5) + 3= 14
    // 1 - 0 
    System.out.println(solution(A));
  }

}
