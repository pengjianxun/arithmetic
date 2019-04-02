/**
 * Created by pengjianxun on 2019/4/2.
 */
public class 相亲广告 {
  /**
   * 题目来源于网上流传的一张图，见同名jpg文件，原文如下：
   * 本人杭州土生土长，浙大理科也算个学霸，今征婚。家里属于平凡的拆迁户....6套房，非沉鱼落雁也非倾国倾城，但绝对算个漂亮的女孩。
   * 希望找一男生能够通过下面的测试。 题目一：我的微信ID是我的姓Lin后面跟两个质数，小的在前面，这两个质数乘积是7140229933.
   * 能够find微信号的，我愿意真诚的和你谈恋爱。唯一的非智力限制条件为，身高必须1.6米以上，体重不能超过180斤。
   * 如果下面升级版的题目，你也能够计算出来的话，第一次聚会的时候我来BG。
   * 题目二：还是一个10位数，不过我把最后三个换成三个star:6541367***, 还是两个质数的乘积， 把这两个质数答案私聊我， curious
   * and expecting我的白马王子
   */
  public static void main(String[] args) {
    long l = 7140229933L;
    long start1 = System.currentTimeMillis();
    getFactors1(l);
    long end1 = System.currentTimeMillis();
    System.out.println("getFactors1耗时：" + (end1 - start1) + " ms");

    long start2 = System.currentTimeMillis();
    getFactors2(l);
    long end2 = System.currentTimeMillis();
    System.out.println("getFactors2耗时：" + (end2 - start2) + " ms");
  }

  /**
   * 题目一 解法一
   * 基本思路：遍历找到第一个质数，能被l整除且相除之后的数也是质数 时间复杂度是O（logN）
   */
  private static void getFactors1(long l) {
    for (long i = 3; i <= Math.sqrt(l); i = i + 2) {
      if (isPrime(i)) {
        long j = l / i;
        if (i * j == l && isPrime(j)) {
          System.out.println("小因数=" + i + ",大因数=" + j);// i = 83777,j = 85229
          break;
        }
      }
    }
  }

  // 判断是否为质数
  private static boolean isPrime(long n) {
    if (n == 1)
      return false;

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  /**
   * 题目一 解法二
   * 理论基础：(a+b)*(a-b)=a^2-b^2
   * 基本思路：给l累加，直到加到它成为一个整数的平方并且和l原来的值之差也是一个整数的平方，然后利用上面公式计算出结果
   * 不足之处：如果传入的l两个因数奇偶性不相同，则该方法无解，但在此处适用
   */
  private static void getFactors2(long l) {
    long mixSquare = l;
    long i = (long) Math.sqrt(mixSquare);
    long sub = 0L;
    while (i * i != mixSquare || sub * sub != (mixSquare - l)) {
      mixSquare++;
      i = (long) Math.sqrt(mixSquare);
      sub = (long) Math.sqrt(mixSquare - l);
    }
    long square = (long) Math.sqrt(mixSquare);
    System.out.println("小因数=" + (square - sub) + ",大因数=" + (square + sub));// i = 83777,j = 85229
  }
}
