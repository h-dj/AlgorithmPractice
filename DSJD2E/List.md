### 线性表的学习

> 学习目标

- 线性表的定义
- 线性表的存储方式和表达方式
- 基本实现
- 基本操作实现
- 双向链表插入和删除实现
- 循环单链表和循环双向链表的结构特点

##### 1. 线性表：
- 定义：零个或多个数据元素所构成的有限序列
- 存储方式：顺序存储结构和链式存储结构
- 抽象数据类型描述
```java
public interface IList<E>{
    void clear();//线性表清空操作
    boolean isEmpty();// 判空
    int size(); //长度
    E get(int i);//通过下标获取元素
    void insert(int i,E t);// 插入元素到特定位置
    void remove(int i);// 移除元素
    int indexOf(E t);// 查找元素
    void display();//打印元素
}
```
##### 2. 线性表顺序存储结构：
- 定义： 用顺序存储方法存储的线性表简称为顺序表（Sequential List）。
- 节点存储地址的计算：
    - 假设每个节点占用c个存储单元
    - 其中第一个单元的存储地址则是该结点的存储地址; 并设表中开始结点a1的存储地址（简称为基地址）是LOC（a1）
    - 所以结点ai的存储地址LOC（ai）： LOC（ai）= LOC（a1）+（i-1）*c   1≤i≤n
- 顺序表的特点
    1. 逻辑上相邻的结点其物理位置亦相邻。
    2. 存储密度高； 存储密度= 数据元素所需的存储空间/该数据元素实际所占空间；需要预先分配"足够应用"的空间，可能会造成存储空间浪费
    3. 便于随机存储
    4. 不便于随机插入删除
   
##### 3. 顺序表基本实现和分析

1. 删除操作实现及分析
- 代码实现
```

    public T remove(int i) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i > this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);
        //获取删除的元素
        T removeObj = (T) objects[i];
        //把下标为i及其后的元素，往前移移一位
        for (int j = i; j < this.lenght - 1; j++) {
            objects[j] = objects[j + 1];
        }
        //把最后一个元素置空，帮助垃圾回收
        objects[lenght - 1] = null;
        //当前线性表长度减一
        --lenght;
        return removeObj;
    }
```
- 时间复杂度分析
    - 在n个元素的顺序表中，删除第i各元素，则0<=i<=n-1
    - 假设删除的概率相同，则p = 1/n
    - 删除第i个元素后，需要移动 n-i-1个元素
    - 平均移动的次数为 (1/n) * (n-i-1)求和 
    - 所以时间复杂度为：O(n)


2. 插入操作及分析
- 代码实现
```
 public void insert(int i, T t) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i > this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);

        //判断是否超出顺序表的容量
        if (this.lenght >= this.objects.length)
            throw new ArrayIndexOutOfBoundsException("length = " + this.lenght + " Capacity" + this.initCapacity);

        //把下标为i及其后的元素，往后移移一位
        for (int j = this.lenght - 1; j >= i; --j) {
            objects[j + 1] = objects[j];
        }
        //插入元素
        objects[i] = t;
        lenght++;
    }
```
- 时间复杂度分析
    - 在长度为 n 的顺序表中，在第i个位置插入一个元素， 0<= i <= n
    - 插入元素前需要将第i个元素开始往后移动，需要移动n-i个元素
    - 假设插入每个位置的概率相同，则p = 1/(n+1)
    - 所以，平均移动次数为 (1/(n+1)) * (n-i) 求和 （0<= i <= n）
    - 则，平均时间复杂度为: O(n)
    
3. 查找元素操作及其分析
- 代码实现
```
public int indexOf(E e) {
    //先判断 元素是否为空，可防止空指针的出现
    if (t == null) {
        //为空则，返回顺序表中空元素的下标
        for (int i = 0; i < this.lenght; i++)
            if (objects[i] == null)
                return i;
    } else {
        //不为空，则返回与之匹配的元素下标
        for (int i = 0; i < this.lenght; i++)
            if (t.equals(objects[i]))
                return i;
    }
    return -1;
    }
```
- 时间复复杂度分析
    - 假设在n个元素的顺序表中，第i个元素为查找的元素x
    - 那么，比较的次数为i+1次，如果没有找到，则需要比较n次
    - 假设查找每个元素的概率相同，p= (1/n)
    - 所以，平均比较次数为 (1/n)*(i+1)求和 （0<=i<=n-1）
    - 时间复杂度为：O(n)
 
4. [SqList](https://github.com/h-dj/AlgorithmPractice/blob/master/src/main/java/org/hdj/AlgorithmPractice/DSJD2E/List/SqList/SqList.java)


##### 4. 链表的概念

1. 定义：
- 　链接方式存储的线性表简称为链表（Linked List）。
2. 存储结构定义：
- 用一组任意的存储单元来存放线性表的结点
- 链表中结点的逻辑次序和物理次序不一定相同
- 每个结点由：数据域（存放数据信息）和指针域（存放直接后继节点地址）两部分组成
- 注意：
    - 链式存储是最常用的存储方式之一
    - 它不仅可用来表示线性表，而且可用来表示各种非线性的数据结构

3.  链表的结点结构

![链表的结点结构](/images/DSJD2E/2.9Node.png?raw=true)

- data域--存放结点值的数据域
- next域--存放结点的直接后继的地址（位置）的指针域（链域）
- 注意：
    - 链表通过每个结点的链域将线性表的n个结点按其逻辑顺序链接在一起的。
    - 每个结点只有一个链域的链表称为单链表（Single Linked List）。


4. 单链表的表示

![存储示意图](/images/DSJD2E/2.7LinkListStoreStructure.png?raw=true)
    - 头节点和头指针的区别
        1. 链表中的第一个节点的储存位置叫做头指针
        2. 链表中的第一个节点前预设的一个节点叫做头节点
        3. 头指针是链表必要元素
        4. 头节点不一定是链表的必要元素
        
![带头结点的链表存储示意图](/images/DSJD2E/2.8 LinkListStoreStructureWithHead.png)
    
##### 5. 链表的实现及分析

1. 结点类
```java
public class LNode<T> {
    //数据域
    public T data;
    //指针域
    public LNode<T> next;
    //...略
}
```
2.  查找操作
- 代码实现
```
//按序号查找
 public T get(int i) {
        //获取第一个节点元素
        LNode node = head.next;
        //计数器
        int pos = 0;
        //遍历节点，直到节点为空 或者 指向第 i 个节点退出循环
        while (node != null && pos < i) {
            node = node.next; //指向后继节点
            ++pos;//计数器加一
        }
        //判断是否找到节点
        if (node == null || pos > i)
            throw new RuntimeException("第 " + i + " 个元素不存在！");

        return (T) node.data;
    }
  
  
  //按元素值查找
   public int indexOf(T t) {
          //获取第一个节点元素
          LNode node = head.next;
          //计数器
          int pos = 0;
  
          //判断查询的值是否为空
          if (t == null) {
              //遍历节点，直到节点为空 或者 节点的数据域为空，退出循环
              while (node != null) {
                  if (node.data == null) {
                      return pos;
                  }
                  node = node.next; //指向后继节点
                  ++pos;//计数器加一
              }
          } else {
              //遍历节点，直到节点为空 或者 指向值为 t的 节点退出循环
              while (node != null) {
                  if (t.equals(node.data)) {
                      return pos;
                  }
                  node = node.next; //指向后继节点
                  ++pos;//计数器加一
              }
          }
          return -1;
      }
```
- 时间复杂度：每次查找都是表头开始遍历查找，所以时间复杂度为：O(n)


3. 插入操作

![插入元素示意图](/images/DSJD2E/2.10 LinkListInsertAction.png)

- 代码实现
```
//带头结点链表插入操作
    public void insert(int i, T t) {
            LNode p = head;
            int pos = -1;
            //1. 找到第 (i-1)个节点(位置 i 的前驱节点)
            while (p.next != null && pos < i - 1) {
                p = p.next;
                pos++;
            }
            //判断插入位置的合法性
            if (p == null || pos > i - 1)
                throw new RuntimeException("插入节点的位置不合法！");
    
            //2. 创建一个新的节点
            LNode newNode = new LNode(t);
            //3.1 新节点的后继指针指向 原先第 i个节点
            newNode.next = p.next;
            //3.2  第（i-1）节点 p 的后继指针指向新节点
            p.next = newNode;
        }
        
    
    //不带头结点
    public void insert(int i, T t) {
        LNode p = head;
        int pos = 0;
    
        while (p.next != null && pos < i - 1) {
            p = p.next;
            pos++;
        }
        //判断插入位置的合法性
        if (p == null || pos > i)
            throw new RuntimeException("插入节点的位置不合法！");

        //2. 创建一个新的节点
        LNode newNode = new LNode(t);
        if(i==0){
        //插入表头时
            newNode.next = head;
            head = newNode;
        }else{
             newNode.next = p.next;
              p.next = newNode;
        }
    }
```
- 时间复杂度：在第i个元素插入结点，需要找到第(i-1)个结点，时间复杂度：O(n)

4. 删除操作

![链表删除操作](/images/DSJD2E/2.12LinkListDel.png)

- 代码实现
```
 public T remove(int i) {
        LNode p = head;
        int pos = -1;
        //找到待删除节点的前驱节点
        while (p.next != null && pos < i - 1) {
            p = p.next;
            ++pos;
        }
        if (pos > i - 1 || p == null)
            throw new RuntimeException("删除节点的位置不合法！");
        //待删除节点
        LNode remove = p.next;
        //3. 第 （i-1) 节点的指针指向 (i+1)节点
        p.next = remove.next;
        return (T) remove.data;
    }
```
- 时间复杂度：O(n)

5. 单链表的创建

- 示意图

![单链表头插法](/images/DSJD2E/2.13LinkListInsertHead.png)

![单链表尾插入法](/images/DSJD2E/2.14 LinkListInsertTail.png)

- 头插入法
```
 public void insertAtHead(T t) {
        //构建新插入的节点
        LNode newNode = new LNode(t);
        //新节点的后继指针指向头结点的头指针
        newNode.next = head.next;
        //头指针指向新节点
        head.next = newNode;
    }
```
- 尾插法
```
public void insertTail(T t) {
    //获取到最后的节点
    LNode tail = this.head;
    while (tail.next != null) {
        tail = tail.next;
    }
    //构造新的节点
    LNode newNode = new LNode(t);
    //新节点指针指向 尾节点指针
    newNode.next = tail.next;
    //尾节点指针指向新节点
    tail.next = newNode;
}
```

6. [单链表实现源码](https://github.com/h-dj/AlgorithmPractice/blob/master/src/main/java/org/hdj/AlgorithmPractice/DSJD2E/List/LinkedList/LinkedList.java)

##### 6. 循环链表

![存储示意图](/images/DSJD2E/2.18ReCycleLinkList.png)

1. 实现循环链表的方式
- 使用头指针的方式
- 使用尾指针的方式
- 使用头尾指针的方法

##### 7. 双向链表

![空双向链表]()

1. 结点类
```java
public class DuLNode<E> {

    public E data;//数据域
    public DuLNode<E> prior;//前驱指针
    public DuLNode<E> next;//后驱指针
    public DuLNode() {
        this(null);
    }
    public DuLNode(E data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}
```