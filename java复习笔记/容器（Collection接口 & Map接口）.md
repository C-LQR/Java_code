# 容器（Collection接口 & Map接口）



 ## 一. Collection接口

- ==**介绍：**==

  java.util.Collection

  是单例集合的根接口

  两个子接口：

  - List接口
  - Set接口

  结构图：

  

- ==**抽象方法：**==

  > 增：boolean add(E e);
  >
  > ​		boolean addAll(Collection c);

  > 删：boolean remove(Object o);
  >
  > ​        boolean removeAll(Collection c);
  >
  > ​		void clear();

  > 改：无

  > 查：无

  > 判断是否为空：boolean isEmpty();

  > 判断是否包含：boolean contains(Object o);
  >
  > ​						   boolean containsAll(Collection c);

  > 容器元素个数：int size();

  > 转成泛型数组：T[] toArray();
  >
  > 转成Object数组：Object[] toArray();

  > 获取迭代器：Iterator iterator();

  > 并集：boolean addAll(Collection c);

  > 交集：boolean retainAll(Collection c);		**对于不可重复的set容器，好理解；对于可重复的list容器，不好理解**
  
  > 差集：boolean removeAll(Collection c);	**对于不可重复的set容器，好理解；对于可重复的list容器，不好理解**
  
  > 补集：无
  
  



## 二. List接口

- ==**介绍:**==

  Java.util.List

  是Collection的子接口

  特点：

  - 有序
  - 可重复

  常用实现类：

  - ArrayList类

  - Vector类

  - LinkedList类

    

- ==**抽象方法：**==

  

  继承了Collection接口的抽象方法

  

  新增了与**索引**有关的专门抽象方法（**方法重载**[^01]）

  > 增：void add(int index, Object o);

  > 删：E remove(int index);

  > 改：Object set(int index, Object o);

  > 查：Object get(int index);
  >
  > ​        int indexOf(Object o);
  >
  > ​        int lastIndexOf(Object o);

   

## 三. ArrayList类

- ==**介绍：**==

  Java.util.ArrayList

  是List接口的实现类

  底层用**数组**来实现

  特点：

  - 查询效率高
  - 增删效率低
  - 线程不安全

  对象引用：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**List接口**修饰对象引用，实现多态

  - 可用**ArrayList类**修饰对象引用

  

- ==**常用方法：**==

  List接口方法：

  > 添加元素：boolean add(Object o); 
  >
  > ​					void add(int index, Object o);

  > 删除元素：boolean remove(Object o); 
  >
  > ​					E remove(int index); 
  >
  > ​					void clear();

  > 改变元素：E set (int index, Object o);

  > 查找：按位查找：Object get(int index); 
  >
  > ​			按值查找：int indexOf(Object o); 
  >
  > ​							   int lastIndexOf(Object o);

  > 判断是否为空：boolean isEmpty(); 

  > 判断是否包含：boolean contains(Object o);

  > 转为Object数组：Object[] toArray(); 
  >
  > 转为泛型数组：	T[] toArray();

  > 并集(union)：boolean addAll(Collection c);

  > 交集(intersection)：boolean retainAll(Collection c);

  > 差集(difference)：boolean removeAll(Collection c);

  > 补集(complement)：无

  > 剩下的方法涉及到“函数式编程”

  

- ==**ArrayList类源码分析：**==



## 四. Vector类

- ==**介绍：**==

  Java.util.Vector

  是List接口的实现类

  底层用**数组**实现

  特点：

  - 查询效率高
  - 增删效率低
  - 线程安全

  对象引用：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**List接口**修饰对象引用，实现多态

  - 可用**Vector类**修饰对象引用

  

- ==**常用方法：**==

  与ArrayList类方法一样



## 五. Stack类

- ==**介绍：**==

  Java.util.Stack

  是Vector类的子类

  底层用**数组**实现

  栈容器特点

  - 后进先出

  对象引用：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**List接口**修饰对象引用，实现多态

  - 可用**Vector类**修饰对象引用，实现多态

  - 可用**Stack类**修饰对象引用

  

- ==**常用方法：**==

  

  与Vector类方法一样

  

  栈容器特有方法

  > 增：E push(E e);

  > 删：E pop();

  > 改：无

  > 查：查找栈顶元素：E peek();
  >
  > ​		查找元素索引：int search(Object o); 			（索引以1开始）

  > 判断是否为空：boolean empty()

  

- ==**练习：括号匹配**==





## 六. LinkedList类

- ==**介绍：**==

  Java.util.LinkedList

  是List接口的实现类

  底层用**双向链表**实现

  特点

  - 查询效率低
  - 增删效率高

  对象引用修饰：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**List接口**修饰对象引用，实现多态

  - 可用**LinkedList类**修饰对象引用



- ==**常用方法：**==

  

  List接口方法（List标准）

  

  链表专用方法（非List标准）

  > 增：头插法：void addFirst(E e);
  >
  > ​					   void push(E e);
  >
  > ​		尾插法：void addLast(E e);

  > 删：头删法：void removeFirst();
  >
  > ​					   void pop();
  >
  > ​		尾删法：void removeLast();

  > 改：无

  > 查：查询第一个元素：E getFirst();
  >
  > ​		查询最后的元素：E getLast();

  

  

## 七. Set接口

-  ==**介绍：**==

  Java.util.Set

  是Collection接口的子接口

  特点：

  - 无序：Set中的元素没有索引
  - 不可重复：不允许加入重复的元素

  常用实现类：

  - HashSet类
  - TreeSet类

- ==**常用方法：**==

  继承了Collection接口的抽象方法

  无新增方法



## 八. HashSet类

- ==**介绍：**==

  Java.util.HashSet

  是Set接口的实现类

  底层用**HashMap**实现，HashMap底层用**数组+单向链表**实现

  特点：

  - 查询效率较高
  - 增删效率较高

  - 无序：不保证元素的顺序
  - 不可重复 ：没有重复的元素
  - 线程不安全
  - 允许存在null元素

  对象引用修饰：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**Set接口**修饰对象引用，实现多态

    ```java
    //实例化HashSet对象，调用泛型类时填入String类型为例
    Set<String> set = new HashSet<>();
    ```

  - 可用**HashSet类**修饰对象引用

    

- ==**常用方法：**==

   

  > 

  

- ==**如何保证无序：**==

  HashSet添加元素时，

  不会顺序存储，也不会随机存储，

  而是将元素哈希值进行取模运算后，将该元素存储到数组的索引为模运算值的地方的单向链表上。

  

- ==**如何保证不重复：**==

  首先，将哈希值进行取模运算结果相同的元素对象进行equals()方法比较；

  其次，属性相同则不插入到对应的链表上，属性不同则尾插入到对应的单向链表上。



- ==**HashSet存储自定义对象**==

  

  ```java
  //自定义Users类
  public class Users {
      
      //成员变量
      private String name;
      private int age;
  	
      //有参构造器
      public Users(String name, int age) {
          this.name = name;
          this.age = age;
      }
      
  	//无参构造器
      public Users() {
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      //重写Object类中的toString()方法
      @Override
      public String toString() {
          return "Users{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  
      //重写Object类中的equals()方法
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
  
          Users users = (Users) o;
  
          if (age != users.age) return false;
          return name != null ? name.equals(users.name) : users.name == null;
      }
  
      //重写Object类中的hashCode()方法
      @Override
      public int hashCode() {
          int result = name != null ? name.hashCode() : 0;
          result = 31 * result + age;
          return result;
      }
  }
  ```

  ```java
  //测试类
  
  public class HashSetTest {
      public static void main(String[] args) {
          //实例化HashSet对象
          Set<Users> set = new HashSet<>();
          //实例化Users对象
          Users u1 = new Users("oldlu",18);
          Users u2 = new Users("oldlu",18);
  
          set.add(u1);
          set.add(u2);
  
          System.out.println(u1.hashCode());
          System.out.println(u2.hashCode());
  
          for(Users user:set){
              System.out.println(user);
          }
   
  
      }
  }
  ```

  ```
  终端：
  -1014304734
  -1014304734
  Users{name='oldlu', age=18}
  ```

  

- ==**底层源码分析：**==

  



## 九. TreeSet类

- ==**介绍：**==

  Java.util.TreeSet

  是Set接口的实现类

  底层用**TreeMap**实现，TreeMap底层用**红黑树**实现

  特点：

  - 排序：对元素进行排序
  - 不可重复：没有重复的元素

  对象引用修饰：

  - 可用**Collection接口**修饰对象引用，实现多态

  - 可用**Set接口**修饰对象引用，实现多态

  - 可用**TreeSet类**修饰对象引用

    

- ==**常用方法：**==

  

  set接口的方法

  > 无对应的查询方法，可以利用for-each循环来查询。

  

- ==**如何排序：**==

  给定排序规则/比较规则，

  排序规则/比较规则的实现方式：

  - 通过**元素自身**实现比较规则

    > Comparable接口中的compareTo()方法定义比较规则；(Java.lang.Comparable)
    >
    > 元素对象需要实现Comparable接口，来实现了比较规则；
    >
    > TreeSet通过调用该方法完成对元素的排序处理。

    

    ```java
    // 自定义类(注：与HashSet中的自定义类相比，多了compareTo()方法，用来排序)
    
    public class Users implements Comparable<Users> {
        
        //成员变量
        private String name;
        private int age;
    	
        //有参构造器
        public Users(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
    	//无参构造器
        public Users() {
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        //重写Object类中的toString()方法
        @Override
        public String toString() {
            return "Users{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        //重写Object类中的equals()方法
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
    
            Users users = (Users) o;
    
            if (age != users.age) return false;
            return name != null ? name.equals(users.name) : users.name == null;
        }
    
        //重写Object类中的hashCode()方法
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        
        //定义比较规则
        //重写Comparable接口中的compareTo()方法
        @Override
        public int compareTo(Users o) {
            if(this.age > o.getAge()) {
                return 1;
            }
            if(this.age == o.getAge()){
                return this.getName().compareTo(o.getName());
            }
            return -1;
            
        }
            
    }
    ```

    ```java
    // 测试类
    
    public class TreeSetTest{
        public static void main(String[] args){
            //实例化TreeSet对象
            Set<Users> set = new TreeSet<>();
            //实例化Users对象
            Users u1 = new Users("oldlu",18);
            Users u2 = new Users("admin",22);
            Users u3 = new Users("sxt",22);
            //增加元素
            set.add(u3);
            set.add(u2);
            set.add(u1);
            
            for(Users user:set){
                System.out.println(user);
            }
            
        }
    }
    ```

    ```
    终端：
    Users{name='oldlu', age=18}
    Users{name='admin', age=22}
    Users{name='sxt', age=22}
    ```

    

    > String类，Integer类等这些类已经实现了Comparable接口
    >
    > ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/String.JPG)
    >
    > ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Integer1.JPG)

    ```java
    // 测试类
    public class TreeSetTest{
        public static void main(String[] args){
            //实例化TreeSet对象
            Set<String> set = new TreeSet<>();
            //增加元素
            set.add("a");
            set.add("c");
            set.add("b");
            
            for(String str:set){
                System.out.println(str);
            }
            
        }
    }
    ```

    ```
    终端：
    a
    b
    c
    ```

    

  - 通过**比较器**实现比较规则

    > Comparator接口中的compare()方法定义了比较规则；(Java.util.Comparator)
    >
    > 比较器需要实现Comparator接口中的compare()方法，来实现比较规则；
    >
    > 在实例化TreeSet对象时，将比较器通过构造器传入TreeSet中，TreeSet通过比较器完成对元素的排序处理；
    >
    > 元素自身不需要实现比较规则。
    
    
    
    ```java
    // 自定义类
    
    public class Students {
    
        private String name;
        private  int age;
    
        //有参构造器
        public Students(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        //无参构造器
        public Students() {
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        //重写Object类的toString()方法
        @Override
        public String toString() {
            return "Students{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        //重写Object类的equals()方法
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
    
            Students students = (Students) o;
    
            if (age != students.age) return false;
            return name != null ? name.equals(students.name) : students.name == null;
        }
    
        //重写Object类的hashCode()方法
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        
    }
    ```
    
    ```java
    //比较器
    
    public class StudentsComparator implements Comparator<Students> {
    
        //定义比较规则
        //重写Comparator接口的compare()方法
        @Override
        public int compare(Students o1, Students o2) {
            if(o1.getAge() > o2.getAge()){
                return 1;
            }
            if(o1.getAge() == o2.getAge()){
                return o1.getName().compareTo(o2.getName());
            }
            return -1;
        }
    }
    ```
    
    ```java
    // 测试类
    
    public class TreeSetTest {
        public static void main(String[] args){
            //实例化TreeSet对象，需要将比较器通过构造器传入TreeSet中
            Set<Students> set = new TreeSet<>(new StudentsComparator());
            //实例化Students对象
            Students s1 = new Students("oldlu",18);
            Students s2 = new Students("admin",22);
            Students s3 = new Students("sxt",22);
            //增加元素
            set.add(s3);
            set.add(s2);
            set.add(s1);
    
            for(Students student:set){
                System.out.println(student);
            }
        }
    }
    ```
    
    ```
    终端：
    Students{name='oldlu', age=18}
    Students{name='admin', age=22}
    Students{name='sxt', age=22}
    ```
    
    

- ==**底层源码分析：**==

  

## 十. Map接口

- ==**介绍：**==

  Java.util

  定义了双例集合的存储特征，

  即以key与value结构为单位进行存储。

  是双例集合的接口
  
  两个实现类：
  
  - HashMap类
  - TreeMap类



- ==**常用方法：**==

  > 增/改：v put(k key,v value);
  >
  > ​			 void putAll(Map m);

  > 删：v remove(Object key);
  >
  > ​		void clear();
  
  > 查：v get(Object key);
  
  > 判断是否有指定key：boolean containsKey(Object key);
  
  > 判断是否有指定value：boolean containsValue(Object value);
  
  > 获得所有key：Set<k> keySet();
  
  > 获得所有键值对：Set<Map.Entry<k,v>> entrySet();





## 十一. HashMap类

- ==**介绍：**==

  Java.util

  是Map接口的实现类

  底层用**哈希表**来实现

  特点：

  - 查询效率较高
  - 增删效率较高

  对象引用修饰：

  - 可用**Map接口**修饰对象引用，实现多态

  - 可用**HashMap类**修饰对象引用

    

- ==**常用方法：**==

  

  Map接口的方法

  

  查询所有键值对的值：

  `v get(Object key); //如果键存在，返回对应的值；否则返回null `

  弊端1：如何知道HashMap中的所有key   弊端2：已知所有key，需要多次调用方法

  

  - Set<k> keySet() + v get(Object key)

    ```java
    // 测试类
    
    public class HashMapTest{
        public static void main(String[] args){
            
            //实例化HashMap对象
            Map<String,String> map = new HashMap<>();
            
            //增加键值对
            map.put("b","B");
            map.put("a","A");
    		map.put("d","D");
            map.put("c","C");
            
            //获得所有的key
            Set<String> keyset = map.keySet();
            
            //for-each循环遍历
            for(String key:keyset){
                System.out.println(key+"----"+map.get(key));
            }
            
        }
    }
    ```

    ```
    终端：
    a----A
    b----B
    c----C
    d----D
    ```

    > 思考：HashMap容器不会对键排序，那为何遍历时键有序？

    

  - Set<Map.Entry<k,v>> entrySet() + getKey() + getValue()
  
    ```java
    // 测试类
    
    public class HashMapTest{
        public static void main(String[] args){
            
            //实例化HashMap对象
            Map<String,String> map = new HashMap<>();
            
            //增加键值对
            map.put("a","A");
            map.put("b","B");
            map.put("c","C");
            map.put("d","D");
            
            //获得所有的键值对
            Set<Map.Entry<String,String>> entryset = map.entrySet();
            
            //for-each循环
            for(Map.Entry<String,String> entry:entryset){
                String key = entry.getKey();
                String val = entry.getValue();
                System.out.println(key + "----" + val);
            }
            
        }
    }
    ```
  
    ```
    终端：
    a----A
    b----B
    c----C
    d----D
    ```
  
    
    
    

- ==**底层源码：**==



## 十二. TreeMap类

- ==**介绍：**==

  Java.util

  是Map接口的实现类

  底层用**红黑树**实现

  特点：

  -  HashMap的效率高于TreeMap
  -  对键进行排序

  对象引用修饰：

  - 可用**Map接口**修饰对象引用，实现多态
  - 可用**TreeMap类**修饰对象引用



- ==**常用方法：**==

  Map接口的方法

  

- ==**如何排序：**==

  给定排序规则/比较规则，

  排序规则/比较规则的实现方式：

  - 元素自身实现比较规则

    ```java
    // 自定义类（实现了比较规则）
    //由于TreeMap底层用红黑树实现，我不知道重写Object类中的hashCode()方法和equals()方法有什么意义
    
    public class Users implements Comparable<Users> {
        
        //成员变量
        private String name;
        private int age;
    	
        //有参构造器
        public Users(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
    	//无参构造器
        public Users() {
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        //重写Object类中的toString()方法
        @Override
        public String toString() {
            return "Users{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        //重写Object类中的equals()方法
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
    
            Users users = (Users) o;
    
            if (age != users.age) return false;
            return name != null ? name.equals(users.name) : users.name == null;
        }
    
        //重写Object类中的hashCode()方法
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        
        //定义比较规则
        //重写Comparable接口中的compareTo()方法
        @Override
        public int compareTo(Users o) {
            if(this.age > o.getAge()) {
                return 1;
            }
            if(this.age == o.getAge()){
                return this.getName().compareTo(o.getName());
            }
            return -1;
            
        }
            
    }
    ```

    ```java
    // 测试类
    
    public class TreeMapTest{
        public static void main(String[] args) {
    
            //实例化TreeMap对象
            Map<Users,String> map = new TreeMap<>();
    
            //实例化Users对象
            Users u1 = new Users("oldlu",18);
            Users u2 = new Users("admin",22);
            Users u3 = new Users("sxt",22);
    
            //增加键值对
            map.put(u1,"oldlu");
            map.put(u2,"admin");
            map.put(u3,"sxt");
    
            //获取所有key
            Set<Users> keyset = map.keySet();
    
            //for-each遍历
            for(Users user:keyset){
                System.out.println(user+"----"+map.get(user));
            }
            
        }
    }
    ```

    ```
    终端：
    Users{name='oldlu', age=18}----oldlu
    Users{name='admin', age=22}----admin
    Users{name='sxt', age=22}----sxt
    ```

    

  - 比较器实现比较规则

    ```java
    // 自定义类（没有实现比较规则）
    //由于TreeMap底层用红黑树实现，我不知道重写Object类中的hashCode()方法和equals()方法有什么意义
    
    public class Students {
    
        private String name;
        private  int age;
    
        //有参构造器
        public Students(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        //无参构造器
        public Students() {
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        //重写Object类的toString()方法
        @Override
        public String toString() {
            return "Students{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        //重写Object类的equals()方法
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
    
            Students students = (Students) o;
    
            if (age != students.age) return false;
            return name != null ? name.equals(students.name) : students.name == null;
        }
    
        //重写Object类的hashCode()方法
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        
    }
    ```

    ```java
    // 比较器
    
    public class StudentsComparator implements Comparator<Students> {
    
        //定义比较规则
        //重写Comparator接口的compare()方法
        @Override
        public int compare(Students o1, Students o2) {
            if(o1.getAge() > o2.getAge()){
                return 1;
            }
            if(o1.getAge() == o2.getAge()){
                return o1.getName().compareTo(o2.getName());
            }
            return -1;
        }
    }
    ```

    ```java
    // 测试类
    
    public class TreeMapTest {
        public static void main(String[] args) {
    
            //实例化TreeMap对象,通过构造器传入比较器到TreeMap中
            Map<Students,String> map = new TreeMap<>(new StudentsComparator());
    
            //实例化Students对象
            Students s1 = new Students("oldlu",18);
            Students s2 = new Students("admin",22);
            Students s3 = new Students("sxt",22);
    
            //增加键值对
            map.put(s1,"oldlu");
            map.put(s2,"admin");
            map.put(s3,"sxt");
    
            //获得所有key
            Set<Students> keys = map.keySet();
    
            //for-each循环
            for(Students student:keys){
                System.out.println(student+"----"+map.get(student));
            }
    
        }
    }
    ```

    ```
    终端：
    Students{name='oldlu', age=18}----oldlu
    Students{name='admin', age=22}----admin
    Students{name='sxt', age=22}----sxt
    ```

    





## 十三. Iterator迭代器接口

- ==**介绍：**==

  







[^01]:方法重载(Override)：方法名相同，而形参列表不同。本质上是不同的方法。

