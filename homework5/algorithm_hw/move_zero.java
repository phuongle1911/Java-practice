package algorithm_hw;

import java.util.Arrays;

public class move_zero {
  public static int[] move_zero(int[] A) {
    int[] nums = new int[A.length];
    int x = 0;
    for (int i=0; i<A.length; i++) {
      if (A[i] != 0) {
        nums[x] = A[i];
        x++;
      }
    }

    return nums;
  }

  public static void main(String[] args) {
    int[] A = {0,1,2,5,6,0,4,5,3,0,4,10};
    System.out.println(Arrays.toString(move_zero(A)));
  }
}
