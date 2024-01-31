class Solution {
  public int myAtoi(String s) {
    int ans = 0;
    // step 1
    s = s.trim();
    if (s.length() == 0) return 0;
    String[] str_arr = s.split(" ");

    // step 2
    for (String str : str_arr) {
      int idx = 0;
      boolean isNegative = false;
      if (str.charAt(idx) == '-' || str.charAt(idx) == '+') {
        isNegative = (str.charAt(idx) == '-');
        ++idx;
      }

      // step 3
      StringBuilder sb = new StringBuilder();
      while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
        sb.append(str.charAt(idx++));
      }

      // step 4
      sb = deleteLeadingZero(sb);
      if (sb.length() == 0) break;

      if (!isInRange(sb.toString())) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      ans = Integer.parseInt(sb.toString());

      return isNegative ? ans * -1 : ans;
    }

    return ans;
  }

  StringBuilder deleteLeadingZero (StringBuilder sb) {
    while (0 < sb.length() && sb.charAt(0) == '0') sb.deleteCharAt(0);

    return sb;
  }

  boolean isInRange(String str) {
    long num;
    try {
      num = Long.parseLong(str);
    } catch (NumberFormatException e) {
      return false;
    }

    if (Integer.MIN_VALUE <= num && num <= Integer.MAX_VALUE) return true;
    return false;
  }
}