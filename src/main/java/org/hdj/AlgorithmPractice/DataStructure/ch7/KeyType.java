package org.hdj.AlgorithmPractice.DataStructure.ch7;

/**
 * @Auther: h_dj
 * @Date: 2019/2/9 22:31
 * @Description: 排序关键字类型
 */
public class KeyType implements Comparable<KeyType> {

    //关键字
    public int key;

    public KeyType() {
    }

    @Override
    public String toString() {
        return "KeyType{" +
                "key=" + key +
                '}';
    }

    @Override
    public int compareTo(KeyType another) {
        int thisKey = this.key;
        int anotherKey = another.key;
        return (thisKey < anotherKey ? -1 : (thisKey == anotherKey ? 0 : 1));
    }
}

