

# 泛型（Generics）



- ==**介绍**==

  - 本质：数据类型参数化
  - 要求：泛型只能表示引用类型
  - 类型擦除：泛型概念只存在于编译之前，编译时，泛型编译成Object类，再强制转换成对应类型。

  

- ==**泛型的定义**==

  泛型标记符可以是任意标记符，一般采用如下几个标记符：

  | 泛型标记符 | 对应单词 | 说明                         |
  | ---------- | -------- | ---------------------------- |
  | E          | Element  | 表示容器元素类型             |
  | T          | Type     | 表示普通Java类型             |
  | K          | Key      | 表示Map中的Key               |
  | V          | Value    | 表示Map中的Value             |
  | N          | Number   | 表示数值类型                 |
  | ?          |          | 表示通配符，不确定的Java类型 |

  

  

  

- ==**泛型类**==

  > 泛型类：把泛型定义在类上。调用该类时，才填入具体类型；调用该类时，不填类型则默认为Object类。

  ```java
  //泛型类
  public class Generic<T>{
      private T name;
      
      public void setName(T name){
          this.name = name;
      }
      
      public T getName(){
          return this.name;
      }
  }
  ```

  ```java
  // 测试类
  
  //1. 使用泛型
  public class TestGeneric{
      public static void main(String[] args){
          //实例化Generic对象，Generic类修饰对象引用
          Generic<String> generic = new Generic<>();
          generic.setName("zhangsan");
          String str = generic.getName();
          
          System.out.println(str);
      }
  }
  
  //2. 不使用泛型，默认类型为Object类
  public class TestGeneric{
      public static void main(String[] args){
          //实例化Generic对象，Generic类修饰对象引用
          Generic generic = new Generic();
          generic.setName("zhangsan");
          String str = generic.getName();  //编译器报错
      }
  }
  ```

  ```
  终端：
  zhangsan
  ```

  

- ==**泛型接口**==

  > 泛型接口：把泛型定义在接口上。实现接口时，才将类型确定下来；若用该接口修饰对象引用时，再次将类型确定下来。

  ```java
  //泛型接口
  public interface Igeneric<T>{
      public abstract T getName(T name);
  }
  
  
  ```

  ```java
  //实现类
  public class ImplementIgeneric implements Igeneric<String>{
      @Override
      public String getName(String name){
          return name;
      }
  }
  ```

  ```java
  // 测试类
  
  //1. 
  public class Test{
      public static void main(String[] args){
  		//1. 实例化对象,ImplementIgeneric类修饰对象引用
          ImplementIgeneric implementigeneric1 = new ImplementIgeneric();
          String name1 = implementigeneric1.getName("lisi");
          System.out.println(name1);
  
          //2. 实例化对象,Igeneric接口修饰对象引用
          Igeneric<String> implementigeneric2 = new ImplementIgeneric();
          String name2 = implementigeneric2.getName("lisi2");
          System.out.println(name2); 
      }
      
  }
  ```

  ```
  终端：
  lisi
  lisi2
  ```

  

- ==**泛型方法**==

  > 泛型方法：把泛型定义在方法上。调用该方法时，不需要填入具体类型，编译器自动推断出类型

  > 1. 非静态方法：可以自己定义泛型（非静态泛型方法），也可以使用泛型类中定义的泛型

  ```java
  //非泛型类中的非静态泛型方法；
  
  public class Mgeneric{
      //定义非静态方法
      public <T> void setFlag(T flag){
          System.out.println(flag);
      }
      //定义非静态方法
      public <T> T getFlag(T flag){
          return flag;
      }
          
  }
  
  
  ```

  ```java
  //测试类
  
  public class Test1 {
      public static void main(String[] args){
  		//实例化Mgeneric对象，Mgeneric类修饰对象引用
          Mgeneric mgeneric = new Mgeneric();
          //调用泛型方法时，不需要填入具体数据类型，编译器自动推断出类型
          mgeneric.setFlag("hello!");
          Integer i = mgeneric.getFlag(123);
          System.out.println(i);
  
      }
  
  }
  ```

  ```
  终端：
  hello!
  123
  ```

  

  > 注意区分：**非静态泛型方法** 和 **泛型类中定义的非静态方法** 

  ```java
  //泛型类
  public class Generic<T>{
      private T name;
      
      public void setName(T name){  	//这不算泛型方法，只是泛型类中定义的非静态方法
          this.name = name;
      }
      
      public T getName(){				//这不算泛型方法，只是泛型类中定义的非静态方法
          return this.name;
      }
  }
  ```

  

  > 2. 静态方法：只能自己定义泛型（非静态泛型方法），不能使用泛型类中定义的泛型。

  ```java
  //静态泛型方法：
  
  public class Test2{
      public static void main(String[] args){
          
          setFlag("hello!");
          Integer i = getFlag(123);
          System.out.println(i);
          
      }
      
      //定义静态方法
      public static <T> void setFlag(T flag){
          System.out.println(flag);
      }
      
      //定义静态方法
      public static <T> T getFlag(T flag){
          return flag;
      }
      
  }
  
  ```

  ```
  终端：
  hello!
  123
  ```

  

- ==**通配符和上下限定**==

  - 无界通配符

    > 在调用泛型类或泛型方法作为参数时，且不确定填入具体的数据类型，一般使用**通配符<?>**

    ```java
    //类1：
    
    public class Generic01<T> {
        public T flag;							//用public修饰，而不能用private修饰，类2方法需要调用该成员变量
    
        public Generic01(T flag){
            this.flag = flag;
        }
    }
    ```
    
    ```java
    //类2：方法调用类1对象
    
    public class Generic02 {
        public void getFlag(Generic01<?> g){	//1. 调用泛型类时，<>应填入具体数据类型;
            									//2. 调用泛型类作为参数时，不确定具体数据类型，<>一般填入通配符?
            System.out.println(g.flag);			
        }
    }
    ```
    
    ```java
    //测试类
    public class Test2 {
        public static void main(String[] args) {
            //实例化Generic02对象
            Generic02 generic02 = new Generic02();
    
            //实例化Generic01对象
            Generic01<String> g = new Generic01<>("zhangsan");
            generic02.getFlag(g);
    
            //实例化Generic01对象
            Generic01<Integer> g2 = new Generic01<>(123);
            generic02.getFlag(g2);				
        }
    
    
    }
    ```
    
    ```
    终端：
    zhangsan
    123
    ```
  
  
  
  
  
  - 通配符的上限限定
  
    > 在调用泛型类或泛型方法作为参数时，且只确定T类和T的子类或者T接口或者T的子接口时，一般使用 **<? extend Number>**
  
    ```java
    //类1：
    
    public class Generic01<T> {
        public T flag;							//用public修饰，而不能用private修饰，类2方法需要调用该成员变量
    
        public Generic01(T flag){
            this.flag = flag;
        }
    }
    ```
  
    ```java
    //类2：方法调用类1对象
    
    public class Generic02 {
        public void getFlag(Generic01<? extend Number> g){	//1. 调用泛型类时，<>应填入具体数据类型;
            												//2. 调用泛型类作为参数，只确定上限具体数据类型，
            												//   填入<? extend Number>;
            System.out.println(g.flag);			
        }
    }
    ```
  
    ```java
    //测试类
    public class Test2 {
        public static void main(String[] args) {
            //实例化Generic02对象
            Generic02 generic02 = new Generic02();
    
            //实例化Generic01对象
            Generic01<String> g = new Generic01<>("zhangsan");
            generic02.getFlag(g);							//编译报错
    
            //实例化Generic01对象
            Generic01<Integer> g2 = new Generic01<>(123);
            generic02.getFlag(g2);				
        }
    
    
    }
    ```
  
    
  
    
  
  - 通配符的下限限定
  
    > 在调用泛型类或泛型方法作为参数时，且只确定T类和T的父类或者T接口或者T的父接口时，一般使用 **<? super Number>**
  
    ```java
    //类1：
    
    public class Generic01<T> {
        public T flag;							//用public修饰，而不能用private修饰，类2方法需要调用该成员变量
    
        public Generic01(T flag){
            this.flag = flag;
        }
    }
    ```
    
    ```java
    //类2：方法调用类1对象
    
    public class Generic02 {
        public void getFlag(Generic01<? super Integer> g){	//1. 调用泛型类时，<>应填入具体数据类型;
            												//2. 调用泛型类作为参数，只确定下限具体数据类型，
            												//   填入<? super Integer>;
            System.out.println(g.flag);			
        }
    }
    ```
    
    ```java
    //测试类
    public class Test2 {
        public static void main(String[] args) {
            //实例化Generic02对象
            Generic02 generic02 = new Generic02();
    
            //实例化Generic01对象
            Generic01<String> g = new Generic01<>("zhangsan");
            generic02.getFlag(g);							//编译报错
    
            //实例化Generic01对象
            Generic01<Integer> g2 = new Generic01<>(123);
            generic02.getFlag(g2);				
        }
    
    
    }
    ```
    
    
    
    