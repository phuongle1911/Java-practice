package algorithm_hw;

import java.util.Arrays;
import java.util.HashSet;

public class remove_dup {
  public static Integer[] remove_dup(int[] numbers) {
    HashSet<Integer> uniqueNum = new HashSet<Integer>();
    for (int i=0; i<numbers.length; i++) {

      if (!uniqueNum.contains(numbers[i])) {
        uniqueNum.add(numbers[i]);
      }
    }
    Integer[] uniqueArr = new Integer[uniqueNum.size()];
    uniqueArr = uniqueNum.toArray(uniqueArr);
    return uniqueArr;
  }
  public static void main(String[] args) {
    int[] A = {1,1,2,4,5,6,6,7,7,7,8};
    System.out.println(Arrays.toString(remove_dup(A)));
  }
}
