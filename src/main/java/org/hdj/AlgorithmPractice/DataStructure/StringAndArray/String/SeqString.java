package org.hdj.AlgorithmPractice.DataStructure.StringAndArray.String;

import org.hdj.AlgorithmPractice.DataStructure.StringAndArray.IString;

import java.util.Arrays;


/**
 * @Auther: h_dj
 * @Date: 2019/3/26 17:10
 * @Description: 顺序串
 */
public class SeqString implements IString {
    //字符数组
    private char[] values;
    //串的长度
    private int length;

    public SeqString() {
        values = new char[0];
        this.length = 0;
    }

    public SeqString(SeqString string) {
        values = string.values;
        this.length = string.length;
    }

    /**
     * 以字符串构造串对象
     *
     * @param str
     */
    public SeqString(String str) {
        char[] toCharArray = str.toCharArray();
        values = toCharArray;
        length = toCharArray.length;
    }

    /**
     * 以字符数组构造串对象
     *
     * @param values
     */
    public SeqString(char[] values) {
        this.values = new char[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
        this.length = values.length;
    }

    @Override
    public void clear() {
        this.values = new char[0];
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public char charAt(int index) {
        //先判断索引是否合法
        if (index < 0 || index > this.length - 1)
            throw new StringIndexOutOfBoundsException(index);

        return this.values[index];
    }

    /**
     * 扩充容量
     *
     * @param newCapacity
     */
    private void allocate(int newCapacity) {
        char[] temp = this.values;
        this.values = new char[newCapacity];
        //复制字符数组
        for (int i = 0; i < temp.length; i++) {
            this.values[i] = temp[i];
        }
    }

    /**
     * 截取子串
     *
     * @param begin 开始索引
     * @param end   结束索引
     * @return
     */
    @Override
    public IString substring(int begin, int end) {
        //1 判断开始截取位置是否合法
        if (begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");

        //2 判断结束截取位置是否合法
        if (end > this.length)
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度: end:" + end + "  length:" + length);

        //3. 开始位置不能大于结束位置
        if (begin > end)
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");

        if (begin == 0 && end == this.length) {
            return new SeqString(this);
        } else {
            //创建截取的字符数组
            char[] buffer = new char[end - begin];
            //复制字符
            for (int i = begin; i < end; i++) {
                buffer[i] = this.values[i];
            }
            return new SeqString(buffer);

        }
    }

    /**
     * 插入操作
     *
     * @param offset 偏移量
     * @param str    插入的串
     * @return
     */
    @Override
    public IString insert(int offset, IString str) {
        //判断偏移量是否合法
        if (offset < 0 || offset > this.length)
            throw new StringIndexOutOfBoundsException("插入位置不合法！");

        //获取插入串的长度
        int len = str.length();
        //计算所需的长度
        int newCount = this.length + len;
        //如果所需的长度大于串数组的容量
        if (newCount > this.values.length) {
            //扩充容量
            allocate(newCount);
        }

        //为插入的串腾出位置(往后移动len个位置)
        for (int i = this.length - 1; i >= 0; i--) {
            this.values[len + i] = this.values[i];
        }
        //复制
        for (int i = 0; i < len; i++) {
            this.values[offset + i] = str.charAt(i);
        }
        this.length = newCount;
        return this;
    }

    /**
     * 删除操作
     *
     * @param begin
     * @param end
     * @return
     */
    @Override
    public IString delete(int begin, int end) {
        //1 判断开始截取位置是否合法
        if (begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");

        //2 判断结束截取位置是否合法
        if (end > this.length)
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度: end:" + end + "  length:" + length);

        //3. 开始位置不能大于结束位置
        if (begin > end)
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");

        for (int i = 0; i < this.length - end; i++) {
            this.values[begin + i] = this.values[end + i];
        }
        this.length = this.length - (end - begin);
        return this;
    }

    /**
     * 连接串
     *
     * @param str
     * @return
     */
    @Override
    public IString concat(IString str) {
        //如果连接的串长度为0，返回本身
        int len = str.length();
        if (len == 0) {
            return this;
        }
        IString newStr = insert(this.length, str);
        return newStr;
    }

    /**
     * 比较
     *
     * @param str
     * @return
     */
    @Override
    public int compareTo(IString str) {
        //获取两个串的长度，取最小的
        int len1 = this.length;
        int len2 = str.length();
        int n = Math.min(len1, len2);

        char[] s1 = this.values;
        char[] s2 = ((SeqString) str).values;

        //比较串的字符
        int k = 0;
        while (k < n) {
            char c1 = s1[k];
            char c2 = s2[k];

            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }

        return len1 - len2;
    }

    @Override
    public int indexOf(IString str, int begin) {
        return indexOf_BF(this, (SeqString) str, begin);
    }


    /**
     * 模式匹配算法
     * Brute force
     *
     * @param text  主串
     * @param p     子串
     * @param begin 开始位置
     * @return
     */
    public int indexOf_BF(SeqString text, SeqString p, int begin) {
        //判断开始匹配的位置是否合法
        if (begin < 0 || begin > text.length - 1)
            throw new StringIndexOutOfBoundsException("判断开始匹配的位置错误： begin=" + begin);

        //标识主串text中的位置
        int i = begin;
        //标识子串p中的位置
        int j = 0;

        //主串的长度
        int textLen = text.length;
        //子串长度
        int pLen = p.length;

        while (i < textLen && j < pLen) {
            //匹配字符
            //如果匹配，则继续下一个字符
            if (text.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
            } else {
                //如果匹配不成功，则退回上次匹配首位的下一位
                i = i - j + 1;
                j = 0;
            }
        }

        //如果匹配成功，返回子串序号
        if (j >= pLen) {
            return i - pLen;
        }
        return -1;
    }


    /**
     * 构建部分匹配表
     *
     * @param p
     * @return
     */
    private int[] getNext(SeqString p) {
        //匹配串的长度
        int patternLength = p.length;
        //匹配表；用于匹配过程中，跳过不需要再进行匹配的字符
        int partial_match[] = new int[patternLength];
        //部分匹配表中的第一个赋值为0，
        //因为只有一个已匹配字符，它没有前缀和后缀
        partial_match[0] = 0;
        //前后缀共有元素的长度（即前缀字符的最后一个下标）
        int length = 0;
        //已匹配字符最后的下标（后缀字符的最后一个下标）
        int currentIndex = 1;

        while (currentIndex < patternLength) {
            if (p.charAt(currentIndex) == p.charAt(length)) {
                //发现匹配
                //共有长度加一
                length = length + 1;
                //记录跳过字符数
                partial_match[currentIndex] = length;
                currentIndex = currentIndex + 1;
            } else {
                //没有匹配
                if (length != 0) {
                    //以AAACAAAA为例子
                    //假设当前匹配的字符串为 AAAC ， 前缀为AAA,AA,A  后缀为 AAC,AC,C
                    //则length = 2 (是当串为AAA时得到的最长前后缀公共字符长度)， currentIndex = 3, 所以前缀AAA != AAC
                    //那么length = partial_match[1] = 1, AA != AC
                    //length = partial_match[0] = 0, A!=C
                    length = partial_match[length - 1];
                } else {
                    //length ==0 ,表示串AAAC没有最长前后缀公共字符
                    //赋值为0
                    partial_match[currentIndex] = 0;
                    //继续匹配下一个串 AAACA
                    currentIndex = currentIndex + 1;
                }
            }
        }
        return partial_match;
    }


    /**
     * 模式匹配KMP算法实现
     *
     * @param text
     * @param p
     * @return
     */
    public int index_KMP(SeqString text, SeqString p) {

        int textLength = text.length;
        int patternLength = p.length;

        //计算部分匹配表
        int partial_match[] = getNext(p);

        int currentIndexText = 0;
        int currentIndexPattern = 0;

        while (currentIndexText < textLength && currentIndexPattern < patternLength) {
            if (text.charAt(currentIndexText) == p.charAt(currentIndexPattern)) {
                //匹配
                //转到下一个字符
                currentIndexPattern = currentIndexPattern + 1;
                currentIndexText = currentIndexText + 1;
            } else {
                if (currentIndexPattern != 0) {
                    // if no match and currentIndexPattern is not zero we will
                    // fallback to values in partial match table
                    // for match of largest common proper suffix and prefix
                    // till currentIndexPattern-1
                    currentIndexPattern = partial_match[currentIndexPattern - 1];
                } else {
                    // if currentIndexPattern is zero
                    // we increment currentIndexText for fresh match
                    currentIndexText = currentIndexText + 1;
                }
            }
        }
        //判断已匹配串的下标currentIndexPattern 是否大于 模式串的长度
        if (currentIndexPattern >= patternLength) {
            //是，则返回匹配模式串的开始位置
            return currentIndexText - patternLength;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "SeqString{" +
                "values=" + Arrays.toString(values) +
                ", length=" + length +
                '}';
    }
}
