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

    int i = 0;
    int maxS;
    int sumOdd = 0;
    int sumEven = 0;
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    while (i < A.length) {
      if (i % 2 == 0) {   // number at even index
        if (A[i] <= A[i+1]) {
          i += 1;

        } else {
          newArr.add(A[i]);
          sumEven += A[i];
          i += 1;
          
        }
      } else {  // number of odd index
        if (A[i] >= A[i+1]) {
          // remove A[i]
        } else {
          i += 1;
        }
      }
    }

    for (int x=0; x < A.length; x+2) {
      sumEven += A[x];
      sumOdd += A[x+1];

      maxS = sumEven - sumOdd;
    }
    return maxS;
  }

  public static void main(String[] args) {
    A = {}
  }

}
