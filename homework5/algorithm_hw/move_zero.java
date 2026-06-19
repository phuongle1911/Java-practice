package algorithm_hw;
import java.util.ArrayList;
import java.util.Arrays;

public class move_zero {
  public static Integer[] move_zero(int[] A) {
    ArrayList<Integer> nums = new ArrayList<Integer>();
    int numberOf0 = 0;
    for (int i=0; i<A.length; i++) {
      if (A[i] == 0) {
        numberOf0 += 1;
      } else {
        nums.add(A[i]);
      }
    }
    for (int x =1; x<=numberOf0; x++) {
      nums.add(0);
    }
    Integer[] arr = new Integer[nums.size()];
    arr = nums.toArray(arr);
    return arr;

  }

  public static void main(String[] args) {
    int[] A = {0,1,2,5,6,0,4,5,3,0,4,10};
    System.out.println(Arrays.toString(move_zero(A)));
  }
}
