package homework2;

public class homework2_2 {
  public static boolean isPalindrome(int[] number) {
    for (int i=0; i<= number.length/2; i++) {
      if (number[i] != number[number.length-1-i]) {
        return false;
      };
    };
    return true;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 4, 3, 2, 41};
    boolean result1 = isPalindrome(nums1);
    System.out.println(result1);
  }

};

