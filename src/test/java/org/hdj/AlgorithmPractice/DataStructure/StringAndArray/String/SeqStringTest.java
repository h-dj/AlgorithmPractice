package org.hdj.AlgorithmPractice.DataStructure.StringAndArray.String;

import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/3/28 14:40
 * @Description:
 */
public class SeqStringTest {

    SeqString seqString = new SeqString("ABCDMXYT ABABCDABD ABCDABD");


    @Test
    public void clear() throws Exception {
        System.out.println(seqString.length());
        seqString.clear();

        System.out.println(seqString.toString());
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(seqString.isEmpty());
    }

    @Test
    public void length() throws Exception {
    }

    @Test
    public void charAt() throws Exception {
        System.out.println(seqString.charAt(1));
    }


    @Test
    public void substring() throws Exception {
        System.out.println(seqString.substring(0, 26));
    }

    @Test
    public void insert() throws Exception {
        seqString.insert(0, new SeqString("123"));
        System.out.println(seqString);
    }

    @Test
    public void delete() throws Exception {
        System.out.println(seqString);
        seqString.delete(2, 4);
        System.out.println(seqString);
    }

    @Test
    public void concat() throws Exception {
        System.out.println(seqString);

        seqString.concat(new SeqString("777"));

        System.out.println(seqString);
    }

    @Test
    public void compareTo() throws Exception {
        SeqString s1 = new SeqString("ABC");
        SeqString s2 = new SeqString("ABD");
        System.out.println(s1.compareTo(s2));
    }

    @Test
    public void indexOf() throws Exception {
    }

    @Test
    public void indexOf_BF() throws Exception {
    }

    @Test
    public void index_KMP() throws Exception {
       // int i = seqString.index_KMP(new SeqString("ABCDMXYT ABABCDABD ABCDABD"), new SeqString("ABCDABD"));
        int i = seqString.index_KMP(new SeqString("AAAAABAAABA"), new SeqString("AAAA"));
        System.out.println(i);
    }

}