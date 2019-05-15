import java.util.Arrays;
import java.util.Random;

/**
 * Created by pengjianxun on 2019/5/15.
 */
public class Zero2Right {
  public static void main(String[] args) {
    Random random = new Random();
    int[] arr = new int[50];

    for (int i = 0; i < 50; i++) {
      arr[i] = random.nextInt(10);
    }
    System.out.println(Arrays.toString(arr));
    move(arr);
    System.out.println(Arrays.toString(arr));
  }

  // 将一个整型数组中的0值都移到最右边，要求时间复杂度O(n)
  private static void move(int[] arr) {
    if (arr == null) {
      throw new NullPointerException();
    }
    int i = 0, j = arr.length - 1;// 定义前后两个临界值
    while (i < j) {// 终止条件
      if (arr[i] == 0) {// 前面的等于零
        for (; j > i; j--) {// 从最后向前遍历，找到第一个不为0的数据，交换
          if (arr[j] != 0) {
            int k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
            j--;// 交换成功，最大下标向前移
            break;
          }
        }
      }
      i++;// 进行一下一次循环准备
    }
  }
}
