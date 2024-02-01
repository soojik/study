class Solution {
  public String intToRoman(int num) {
    StringBuilder ans = new StringBuilder();
    char[] roman = new char[1001];
    roman[1] = 'I';
    roman[10] = 'X';
    roman[100] = 'C';
    roman[1000] = 'M';
    roman[5] = 'V';
    roman[50] = 'L';
    roman[500] = 'D';

    int 자릿수 = 0;
    int len = Integer.toString(num).length();
    while (자릿수 < len) {
      StringBuilder curr = new StringBuilder();
      int n = num % 10;
      if (n == 4) {
        if (자릿수 == 2) curr.append("DC");
        else if (자릿수 == 1) curr.append("LX");
        else if (자릿수 == 0) curr.append("VI");
        else curr.append("MMMM");
      }
      else if (n == 9) {
        if (자릿수 == 2) curr.append("MC");
        else if (자릿수 == 1) curr.append("CX");
        else curr.append("XI");
      }
      else {
        for (int i=0;i<n%5;i++) {
          curr.append(roman[(int)Math.pow(10, 자릿수)]);
        }
        for (int i=0;i<n/5;i++) {
          curr.append(roman[(int)Math.pow(10, 자릿수) * 5]);
        }
      }
      ++자릿수;
      num /= 10;
      ans = ans.reverse().append(curr).reverse();
    }

    return ans.toString();
  }
}