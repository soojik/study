class Solution {
  int[] dr = {1, -1};
  int[] dc = {0, 1};
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    char[][] grid = new char[numRows][s.length()];
    int r, c;
    r = c = 0;
    int idx = 0;
    while (idx < s.length()) {
      for (int j=0;j<2;j++) {
        for (int k=0;k<numRows-1 && idx < s.length();k++) {
          grid[r][c] = s.charAt(idx++);
          r += dr[j];
          c += dc[j];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0;i<numRows;i++) {
      for (int j=0;j<s.length();j++) {
        if (grid[i][j] != '\u0000') sb.append(grid[i][j]);
      }
    }

    return sb.toString();
  }
}