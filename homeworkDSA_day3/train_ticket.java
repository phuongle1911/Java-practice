package homeworkDSA_day3;

import java.util.Arrays;

public class train_ticket {
  public static int solution(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    int[] dp = new int[A.length];
    Arrays.fill(dp, 30);
    int[]  ticket = {1,7};
    int[] cost = {2,7};
    return minMoneyR(0, dp, A, ticket, cost);
  };

  public static int minMoneyR(int i, int[] dp, int[] days, int[] ticket, int[] cost) {

    if (i == days.length) {
      return 0;
    }
    if (dp[i] != 30) {
      return dp[i];
    }

    int j=i;
    for (int k=0; k< ticket.length; k++) { 
      while (j<days.length && days[j] - days[i] < ticket[k]) {
        j++;
      }
      dp[i] = Math.min(dp[i], Math.min((cost[k] + minMoneyR(j, dp, days, ticket, cost)),25));
    }
    return dp[i];
  }

  public static void main(String[] args) {
    int[] A = {1,2,4,5,7,29,30};
    System.out.println(solution(A));
  }

}



