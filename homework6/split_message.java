public class split_message {
  public static int solution(String S, int K) {
    if (!S.contains(" ") && S.length()<=K) {
      return 1;
    } else if(!S.contains(" ") && S.length()>K) {
      return -1;
    }
    int count = 1;
    String[] words = S.split(" ");
    int sum = 0;

    for (int i=0; i<words.length; i++) {
      if (words[i].length()>K) {
        return -1;
      }
      sum += words[i].length()+1;
      if (sum-1 > K) {
        count += 1;
        sum = words[i].length();
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String S = "sms messages are reallyg short hgwe shge";
    System.out.println(solution(S,12));
  }
}
