package org.hdj.AlgorithmPractice.DSJD2E.StringAndArray;

/**
 * @Auther: h_dj
 * @Date: 2019/3/26 16:37
 * @Description: 串的抽象接口
 */
public interface IString {
    void clear();//置空
    boolean isEmpty();//判空
    int length();//长度
    char charAt(int index);//获取指定下标的字符
    IString substring(int begin,int end);//截取子串
    IString insert(int offset,IString str);//插入
    IString delete(int begin,int end);//删除
    IString concat(IString str);//串连接
    int compareTo(IString str) ;//比较
    int indexOf(IString str,int begin);//子串定位
}
