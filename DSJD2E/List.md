### 线性表的学习 《数据结构自学网》

#### 一、概念
1. 定义:  
- 线性表：零个或多个数据元素的有限序列

2. 逻辑结构定义
- 线性表（Linear org.hdj.AlgorithmPractice.List）是由n（n≥0）个数据元素（结点）a1，a2，…，an组成的有限序列。
- 数据元素的个数n定义为表的长度（n=0时称为空表）。
- 将非空的线性表（n＞0）记作：（a1，a2，…，an）

3.  顺序表的定义 
- 顺序存储方法： 即把线性表的结点按逻辑次序依次存放在一组地址连续的存储单元里的方法。
- 顺序表（Sequential org.hdj.AlgorithmPractice.List）：用顺序存储方法存储的线性表简称为顺序表（Sequential org.hdj.AlgorithmPractice.List）。

4. 结点ai 的存储地址
- 假设每个节点占用c个存储单元
- 其中第一个单元的存储地址则是该结点的存储地址; 并设表中开始结点a1的存储地址（简称为基地址）是LOC（a1）
- 所以结点ai的存储地址LOC（ai）： LOC（ai）= LOC（a1）+（i-1）*c   1≤i≤n

![image](https://note.youdao.com/favicon.ico)

- 注意： 这种存储结构称为随机存储结构，时间复杂度为O(1)
