package homework2;

public class homework2_4 {
  public int singleNumber(int[] nums) {
    int counter = 0;
    for (int n=1; n<= nums.length; n++) {
      for (int i=0; i<nums.length; i++) {
        if (nums[i] == n) {
          counter += 1;
        }
      };

      if (counter == 1) {
        return n;
      }
    };
  }
  
}
