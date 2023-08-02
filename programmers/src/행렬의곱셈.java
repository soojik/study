public class 행렬의곱셈 {

  public static void main(String[] args) {

  }

  static int[][] solution(int[][] arr1, int[][] arr2) {

    /*
    행렬의 곱은 (m*k) * (k*n) 의 결과가 m*n 으로 고정되어 있다.
    */
    int r = arr1.length;
    int c = arr2[0].length;
    int[][] answer = new int[r][c];

    for (int i=0;i<r;i++) {
      for (int j=0;j<c;j++) {
        answer[i][j] = getSum(i, j, arr1, arr2);
      }
    }

    return answer;
  }

  /*
  getSum 은 주어진 {r, c} 위치의 값을 계산하기 위한 메서드
  */
  static int getSum(int r, int c, int[][] arr1, int[][] arr2) {
    int result = 0;

    /*
    예시 1번을 들어 {1, 1} 위치의 값을 찾을 때는 arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1] 을 계산하는 것처럼
    앞 행렬은 찾고자 하는 행을 왼쪽에서 오른쪽으로, 뒷 행렬은 열을 위에서 아래로 차례로 곱해서 더한다.
    행렬 곱 특성상 두 행렬은 각 열, 행길이가 같기 때문에 이 공식이 성립한다.
     */
    int len = arr2.length;
    for (int i=0;i<len;i++) {
      result += arr1[r][i] * arr2[i][c];
    }

    return result;
  }
}
