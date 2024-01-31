class Solution {
  public int reverse(int x) {
    long answer = 0;
    boolean isNegative = (x < 0);
    if (isNegative) x *= -1;
    while (0 < x) {
      answer *= 10;
      answer += x % 10;
      x /= 10;
    }

    if (answer != (int) answer) return 0;

    if (isNegative) return (int)answer * -1;
    return (int)answer;
  }
}