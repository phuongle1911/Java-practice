package homework2;

public class homework2_4 {
  public static int singleNumber(int[] nums) {
    int single = 0;
    for (int num : nums) {
      single = single ^ num;
    }
    return single;

  }

  public static void main(String[] args) {
    int[] nums = {1,2,5,5,2};
    System.out.println(singleNumber(nums));
  }
  
}
