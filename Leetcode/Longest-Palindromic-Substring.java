class Solution {
  String ans = "";
  public String longestPalindrome(String s) {

    for (int center=0;center<s.length();center++) {
      String odd = getLongestPalindromicString(center, s, false);
      String even = getLongestPalindromicString(center, s, true);

      if (ans.length() < odd.length()) ans = odd;
      if (ans.length() < even.length()) ans = even;
    }

    return ans;
  }

  String getLongestPalindromicString(int center, String s, boolean isEven) {
    int start, end;
    if (isEven) {
      start = center;
      end = center + 1;
    }
    else {
      start = end = center;
    }

    int width = 0;
    while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)) {
      --start;
      ++end;
    }

    return s.substring(start+1, end);
  }
}