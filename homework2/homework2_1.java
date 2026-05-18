// Exercise: fining max and min number, average of all elements in array

package homework2;

public class homework2_1 {
  public static void main(int[] nums) {
    // Integer[] nums = {1,4,6,2,40,5,4};
    int sum = nums[0];
    int minNum = nums[0];
    int maxNum = nums[0];
    for (int i=1; i< nums.length; i++) {
      minNum = Math.min(minNum,nums[i]);
      maxNum = Math.max(maxNum,nums[i]);
      sum += nums[i];
    }
    System.out.println("Min number is:" + minNum);
    System.out.println("Max number is:" + maxNum);
    System.out.println("Sum is:" + sum);
  }
  
}
