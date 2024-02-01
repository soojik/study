class Solution {
  public int maxArea(int[] height) {
    int ans = 0;

    int start = 0;
    int end = height.length - 1;

    int curr;
    while (start < end) {
      curr = Math.min(height[start], height[end]) * (end - start);
      ans = Math.max(ans, curr);

      if (height[start] < height[end]) {
        ++start;
        continue;
      }

      --end;
    }

    return ans;
  }
}