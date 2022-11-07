package org.hdj.AlgorithmPractice.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/11/7 14:27
 */
public class TransformTree {


    public static void main(String[] args) {
        //请把下列数据处理成树状结构，例如：1-1跟1-2的父节点为1，2-1、2-2的父节点则为2
        // 结果示例:{1=[1-1, 1-2], 2=[2-1, 2-2], 2-2=[2-2-1]}

        String[] testArr = {"1", "1-1", "1-2", "2", "2-1", "2-2", "2-2-1"};
        Map<String, List<String>> tree = new HashMap<>();
        for (String s : testArr) {
            int i = s.lastIndexOf("-");
            if(i<=0){
                i = s.length();
            }
            String parentKey = s.substring(0,i);
            tree.putIfAbsent(parentKey,new ArrayList<>());
            if(i != s.length()){
                tree.get(parentKey).add(s);
            }
        }
        System.out.println(tree);
    }
}
