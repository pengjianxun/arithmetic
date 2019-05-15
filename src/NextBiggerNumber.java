/**
 *
 * Created by pengjianxun on 2019/5/15.
 */
public class NextBiggerNumber {
  public static void main(String[] args) {
    System.out.println(getBiggerNext(236654433));
  }

  /**
   * 给定任意一个自然数后，获取它重新排列后，下一个比他大的自然数，要求时间复杂度O(n)，例如： <br/>
   * 给定1233，它的下一个是1323 <br/>
   * 给定1323，它的下一个是1332 <br/>
   * 给定9876，它的下一个不存在
   * 
   * @param src
   * @return
   */
  private static int getBiggerNext(int src) {
    if (src < 10)
      return -1;
    char[] cs = String.valueOf(src).toCharArray();// 转换成数组
    int maxIndex = cs.length - 1;
    for (int i = maxIndex; i > 0; i--) {// 从右向左遍历，找到要被替换的最小位
      if (cs[i] > cs[i - 1]) {
        for (int j = i; j < maxIndex; j++) {// 从左向右，找到可以替换的合适的数字，完成替换
          if (cs[j] > cs[i - 1] && cs[j + 1] <= cs[i - 1]) {
            swap(cs, j, i - 1);
          }
        }
        int k = maxIndex;
        while (i < k) {// 将原来的顺序倒过来
          swap(cs, i, k);
          i++;
          k--;
        }
        break;
      }
    }
    int res = Integer.valueOf(String.valueOf(cs));
    if (res == src)
      return -1;
    else
      return res;
  }

  private static void swap(char[] src, int i, int j) {
    char k = src[i];
    src[i] = src[j];
    src[j] = k;
  }
}
