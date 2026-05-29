package homework4;

import java.util.Arrays;

public class triangular {
  public static int solution(int[] A) {
    // for ex, max (P,Q, R) = P => Q + R > P
    // solution: sort , then compare last number with next 2 numbers throughout the array

    if (A.length < 3) {
      return 0;
    };

    Arrays.sort(A);

    for (int x = A.length-1; x>1; x--) {
      if (A[x] < (A[x-1] + A[x-2])) {
        return 1;
      } 
    };

    return 0;

  }

  public static void main(String[] args) {
   int[] A = {10,50,5,1,12};
   System.out.println(solution(A));
  }
}
