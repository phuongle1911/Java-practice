package homework3;
import java.util.ArrayList;

class Solution {
  public static int solution(int N) {
    String binary = Integer.toBinaryString(N);
    System.out.println("binary of num: " + binary);
    int maxGap = 0;
    ArrayList<Integer> positionOf1 = new ArrayList<Integer>();

    for (int i=0; i<binary.length();i++) {
      if (binary.charAt(i) == '1') {
        positionOf1.add(i);
      };
    };

    System.out.println("position of 1: " + positionOf1);

    if (positionOf1.size() >=2) {
      for (int i=0; i<(positionOf1.size()-1); i++) {
        if (positionOf1.get(i+1) - positionOf1.get(i) - 1 > maxGap) {
          maxGap = positionOf1.get(i+1) - positionOf1.get(i) - 1;
        }
      }
    } else {
      maxGap = 0;
    };

    return maxGap;
  }

  public static void main(String[] args) {
    int num = 7;
    System.out.println(solution(num));
  }

}


