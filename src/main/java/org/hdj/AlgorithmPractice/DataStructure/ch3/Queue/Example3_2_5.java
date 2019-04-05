package org.hdj.AlgorithmPractice.DataStructure.ch3.Queue;


import org.hdj.AlgorithmPractice.DataStructure.List.SqList.SqList;
import org.hdj.AlgorithmPractice.DataStructure.Queue.LinkQueue;

/**
 * 队列的应用
 * <p>
 * 求素数环问题
 * <p>
 * 什么是素数： 在大于1的自然数中，除了1和它本身以外不再有其他因数。（也称为质数）
 * <p>
 * 判断：对正整数n，如果用2到根号n之间的所有整数去除，均无法整除，则n为质数。
 */
public class Example3_2_5 {


    /**
     * 判断是否为素数
     *
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        if (n == 1) return false;
        Double num = Math.sqrt(n);
        for (int i = 2; i <= num.intValue(); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * 创建一个素数圈
     *
     * @param n
     * @return
     */
    public SqList makePrimeRing(int n) {
        //如果n 为奇数，则素数环不存在
        if (n % 2 != 0) throw new RuntimeException("素数环不存在！");
        //用于存储素数环中的素数
        SqList<Integer> sqList = new SqList<>();
        //素数环，第一个数总是1
        sqList.insert(1);
        //用于存储2~n的自然数
        LinkQueue<Integer> linkQueue = new LinkQueue<>();
        //构造2~n 的自然数队列
        for (int i = 2; i <= n; i++) {
            linkQueue.offer(i);
        }
        //返回素数环
        return insertPrimeRing(sqList, linkQueue, 2, n);


    }

    //添加素数环
    private SqList insertPrimeRing(SqList<Integer> sqList, LinkQueue<Integer> linkQueue, int m, int n) {
        //记录队列中的数据元素个数，防止在一次循环中重复遍历
        int count = 0;
        while (!linkQueue.isEmpty() && count <= n - m) {
            //获取队首元素
            Integer p = linkQueue.poll();
            //获取素数环最后一个元素
            Integer q = sqList.get(sqList.size() - 1);
            //判断是否为队尾元素, 是则还需要与素数环第一个元素和为素数
            if (m == n) {
                if (isPrime((p + q)) && isPrime(p + sqList.get(0))) {
                    //如果是素数，添加到素数环
                    sqList.insert(p);
                    //返回素数环
                    return sqList;
                } else {
                    //不满足条件，重新加入队列
                    linkQueue.offer(p);
                }
            } else if (isPrime(p + q)) {
                //不是队尾元素，则只需要判断队素数环最后一个元素的和是否为素数
                sqList.insert(p);

                //判断是否已找到素数环
                if (insertPrimeRing(sqList, linkQueue, m + 1, n) != null) {
                    return sqList;
                }

                //移除顺序表表尾元素
                sqList.remove(sqList.size() - 1);
                linkQueue.offer(p);
            } else {
                linkQueue.offer(p);
            }

            ++count;
        }

        return null;
    }

    public static void main(String[] args) {
        Example3_2_5 example3_2_5 = new Example3_2_5();
        SqList sqList = example3_2_5.makePrimeRing(6);

        sqList.display();

    }
}
