# 数组（array）

- 介绍

  **数组**本质上是**对象**，但又与对象有些差别。



- ==**创建数组**==

  - 第一步：声明变量（又叫，定义数组）：

    ```java
    //int[] a;(推荐)
    
    //int a[];
    
    //数组类型可以是基本数据类型，也可以是引用数据类型
    //数组变量类型只能是引用数据类型
    ```

  - 第二步：分配空间：

    ```java
    //a = new int[3];
    //与给对象分配空间有些差异，构造器
    ```

    

    两步可以一步到位：

    ```java
    //int[] a = new int[3];
    ```



- ==**初始化数组**==

  

  - 静态初始化：

    ```java
    //int[] a = {10,20,30};
    ```

  - 动态初始化：

    ```java
    //int[] a = new int[3];
    //a[0] = 10;
    //a[1] = 20;
    //a[2] = 30; 
    ```

  - 默认初始化：

    ```java
    //int[] a = new int[3];  {0,0,0}
    
    //boolean[] b = new boolean[3];  {false,false,false}
    
    //Person[] p = new boolean[3];  {null,null,null}
    ```

    

- ==**数组的遍历**==

  - 普通遍历-for循环

    ```java
    int[] a = {10,20,30};
    for(int i = 0;i < a.length;i++){
        system.out.println(a[i]);
    }
    ```

    ```
    10
    20
    30
    ```

  

   - 加强遍历-for-earch循环

     ```java
     int[] a = {10,20,30};
     for(int tem:a){
         system.out.println(tem)
     }
     ```

     ```
     10
     20
     30
     ```




- ==**数组的拷贝**==

  - ```java
    //System.arraycopy(@NotNULL Object src, int srcPos, @NotNull Object dest,int destPos, int length)
    //该函数从原数组src中索引为srcPos开始，往下拷贝（length-1）个，粘贴到目的数组dest以索引为dextPos开头的地方
    
    int[] alist = new int[3];
    int[] blist = new int[4];
    alist[0] = 10;
    alist[1] = 20;
    alist[2] = 30;
    System.out.println(Arrays.toString(alist));
    System.out.println(Arrays.toString(blist));
    
    System.arraycopy(alist, 0, blist, 0, 3);
    
    System.out.println(Arrays.toString(alist));
    System.out.println(Arrays.toString(blist));
    ```
  
  - ```
    终端：
    [10, 20, 30]
    [0, 0, 0, 0]
    [10, 20, 30]
    [10, 20, 30, 0]
    ```
  
    
  
- ==**二维数组的创建**==


  - 第一步：声明变量

    ```java
    //int[][] a;
    ```

    

  - 第二步：分配空间

    ```java
    //a = new int[3][];
    ```

    

    两步一步到位

    ```java
    //int[][] a = new int[3][];
    ```

    1

    

- ==**二维数组的初始化**==

  - 静态初始化

    ```java
    //int[][] a = {{10,20},{10,30},{10,20,30}};
    ```

    1

  - 动态初始化

    ```java
    //int[][]  a = new int[3][];
    
    //错误
    //a[0] = {10,20};
    //a[1] = {10,30};
    //a[2] = {10,20,30};
    
    //正确：a[i]变量？？？
    //a[0] = new int[]{10,20};
    //a[1] = new int[]{10,30};
    //a[2] = new int[]{10,20,30}
    ```

    

  - 默认初始化

    ```java
    //int[][] a = new int[3][]; {null,null,null}
    ```

    

- ==**表格信息的存储**==

  

  
  
  - |  id  | name | avgScore | rank |
    | :--: | :--: | :------: | :--: |
    |  1   | 张三 |    88    |  3   |
    |  2   | 李四 |    92    |  1   |
    |  3   | 王五 |    89    |  2   |

  - 

  - 第一种：二维数组存储
  
    ```java
    import java.util.Arrays
        
    public class Test{
        public static void main(String[] args){
            // ------------创建二维数组并初始化-----------
            Object[][] info = new Object[3][];
            info[0] = new Object[]{1,"张三",88,3};
            info[1] = new Object[]{2,"李四",92,1};
            info[2] = new Object[]{3,"王五",89,2};
            // ---------------打印数组引用的值--------------------
            System.in.println(info);  //等于System.in.println(info.toString());
            // ---------------打印数组元素的值--------------------
            System.in.println(Arrays.toString(info))
            // ----------二维数组的遍历:1-----------
            for(int i = 0;i < info.length;i++){
                for(int j = 0;j < info[i].length;j++){
                    System.out.print(info[i][j] + "\t");
                }
                System.out.println();
            }
            //----------二维数组的遍历:2(推荐)-----------
            for(int i = 0;i < info.length;i++){
                System.out.println(Arrays.toString(info[i]));
            }
            
        }
    }
    ```
    
    ```
    终端：
    [[Ljava.lang.Object;@4554617c
    [[Ljava.lang.Object;@14ae5a5, [Ljava.lang.Object;@7f31245a, [Ljava.lang.Object;@6d6f6e28]
    1	张三	88	3	
    2	李四	92	1	
    3	王五	89	2	
    [1, 张三, 88, 3]
    [2, 李四, 92, 1]
    [3, 王五, 89, 2]
    ```
    
    
    
  - 第二种：一维数组+bean类存储
  
    ```java
    public class Test{
        public static void main(String[] args){
            // ------------创建一维数组并初始化-----------
            Info[] info1 = new Info[3];
            Info a = new Info(1,"张三",88,3);
            Info b = new Info(2,"李四",92,1);
            Info c = new Info(3,"王五",89,2);
            info1[0] = a;
            info1[1] = b;
            info1[2] = c;
            //---------------打印数组引用的值--------------------
            System.out.println(info1);
            //----------一维数组的遍历-----------
            for(int i = 0;i < info1.length;i++){
                System.out.println(info1[i]);//在打印对象引用时，对象引用会自动调用对象中重写的toString()方法
            }
        }
    }
    
    // 创建bean类
    class Info{
        private int id;
        private String name;
        private int avgScore;
        private int rank;
        
        public Info(){ 
        }
        
        public Info(int id,String name,int avgScore,int rank){
            this.id = id;
            this.name = name;
            this.avgScore = avgScore;
            this.rank = rank;
        }
        
        @Override
        public String toString() {
            return "Info{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", avgScore=" + avgScore +
                    ", rank=" + rank +
                    '}';
        }
        
        public void setId(int id){
            this.id = id;
        }
        
        public int getId(){
            return id;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public String getName(){
            return name;
        }
        
        public void setAvgScore(int avgScore){
            this.avgScore = avgScore;
        }
        
        public int getAvgScore(){
            return avgScore;
        }
        
        public void setRank(int rank){
            this.rank = rank;
        }
        
        public int getRank(){
            return rank;
        }  
        
    }
    
    ```
  
    ```
    终端：
    [Lgogogo.Info;@74a14482
    Info{id=1, name='张三', avgScore=88, rank=3}
    Info{id=2, name='李四', avgScore=92, rank=1}
    Info{id=3, name='王五', avgScore=89, rank=2}
    
    ```
  
    ```
    java.util.Arrays类中有数组操作的方法：
    Arrays.toString()是Arrays类中的静态方法
    
    类中也有：
    Object类的方法toString()
    
    ```
  
    
  
- ==**Java.util.Arrays类**==

  - 介绍：

    Arrays类中有许多操作数组的方法，比如：排序、打印数组元素值等

  - 学习：

    [jdk1.8 API文档](D:/jdk-8u361-docs-all/docs/api/index.html)

  - 方法：

    - ```java
      public static String toString(Object[] a)
          
      //1. Returns a string representation of the contents of the specified array. 
      //该方法返回指定数组的内容的字符串形式。
          
      //2.If the array contains other arrays as elements, they are converted to strings by the Object.toString() method inherited from Object, which describes their identities rather than their contents.
      //如果该数组包含其他数组作为元素，该方法将返回元素数组的引用而非内容的字符串形式。
          
      //相似：Object.toString()
      public String toString()
      //Returns:a string representation of the object.
      //该方法返回该对象的字符串形式
      ```

    - ```java
      public static void sort(int[] a)
          
      //Sorts the specified array into ascending numerical order.
      //该方法将指定数组以升序序列排序。
          
      public static void sort(Object[] a)
      //1. Sorts the specified array of objects into ascending order, according to the natural ordering of its elements. 
      //该方法将数组以升序序列排序。
          
      //2. All elements in the array must implement the Comparable interface.
      //该数组的所有元素必须实现Comparable接口
      ```



- ==**comparable接口**==

  - 介绍：

    java.lang.Comparable
    
    Comparable接口中的compareTo()方法定义了**排序规则/比较规则**，
    
    该接口只有这一种方法：`public abstract int compareTo(T o);`
    
    
    
    ```java
    //实现类内方法的重写：
    @Override
        public int compareTo(Object o) {
            if(this.avgScore > ((Info)o).avgScore){
                return 1;
            }else if(this.avgScore < ((Info)o).avgScore){
                return -1;
            }else{
                return 0;
            }
        }
    
    //实现类内方法的重写：(推荐)
    @Override
        public int compareTo(Object o) {
            Info inf = (Info)o; 
            if(this.avgScore > (inf.avgScore){
                return 1;
            }else if(this.avgScore < (inf.avgScore){
                return -1;
            }else{
                return 0;
            }
        }
    ```
  
  
  
  - 意义：
  
    数组元素必须本身实现Comparable接口，该数组才能作为参数传入`Arrays.sort(Object o)方法`中。