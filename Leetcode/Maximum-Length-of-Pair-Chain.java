class Maximum-Length-of-Pair-Chain {
  public int findLongestChain(int[][] pairs) {
    int answer = 0;
    Arrays.sort(pairs, (int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);

    int lastR = -1001;
    for (int[] p : pairs) {
      // 전 right(lastR)가 현재 left보다 같거나 크다면 다음으로
      if (p[0] <= lastR) continue;
      lastR = p[1];
      ++answer;
    }

    return answer;
  }
}