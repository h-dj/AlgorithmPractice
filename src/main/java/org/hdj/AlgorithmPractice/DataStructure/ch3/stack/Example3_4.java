package org.hdj.AlgorithmPractice.DataStructure.ch3.stack;

/**
 * 栈的应用之
 * <p>
 * 汉洛塔
 */
public class Example3_4 {
    //移动次数
    private int c = 0;

    private void hanoi(int n, char x, char y, char z) {
        if (n == 1) {
            move(x, 1, z); //移动编号为1的圆盘从x移到z
        } else {
            hanoi(n - 1, x, z, y); //将x上编号为1~n-1的圆盘一道y, z作为辅助塔
            move(x, n, z);  //将编号n的盘从x移到z
            hanoi(n - 1, y, x, z); //将y上编号为1~n-1的圆盘一道z, x作为辅助塔
        }
    }

    private void move(char x, int n, char z) {
        System.out.println("第" + (c++) + "次移动：" + n + " 号圆盘" + x + " -> " + z);
    }

    public static void main(String[] args) {
        Example3_4 example3_4 = new Example3_4();
        example3_4.hanoi(3, 'x', 'y', 'z');
    }
}
