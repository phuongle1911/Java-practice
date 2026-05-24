package homework2;

public class homework2_4 {
  public int singleNumber(int[] nums) {
    int single = 0;
    for (int num : nums) {
      single = single ^ num;
    }
    return single;

  }
  
}
