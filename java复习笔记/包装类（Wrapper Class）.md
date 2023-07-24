# 包装类（Wrapper Class）



- ==**介绍**==

  Java 不是纯面对对象语言，有8种基本数据类型不是对象。而这8种基本数据类型可以通过各自的包装类，打包成对象。这8种基本数据类型对应的打包类如下图：

  | 基本数据类型 | 包装类    |
  | ------------ | --------- |
  | byte         | Byte      |
  | short        | Short     |
  | int          | Integer   |
  | long         | Long      |
  | float        | Float     |
  | double       | Double    |
  | boolean      | Boolean   |
  | char         | Character |

  
  
  > 这8个类是Number类的子类，而Number类是Object类的子类。
  
  
  
  图一：IDEA中快捷键：**ctrl+H** 查看当前类的层级关系
  
  ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Integer.JPG)
  
  ​									（图一）
  
  
  
  
  
  Number类是抽象类，规定了`intValue()、longValue()、floatValue()、doubleValue()、byteValue()、shortValue()`等抽象方法，Number类的子类负责实现上述方法。
  
  ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Integer2.JPG)

​		8种包装类用法一样，下面以较为常用的Integer类为例：



- **==创建对象==**

  ```java
  //Integer i = new Integer(10);9版本之后废弃
  
  //Integer i = Integer.valueOf(10);(推荐)
  
  ```

  ```java
  //推荐使用：Integer i = Integer.valueOf(10)的原因：使用了缓存
  
  //源代码：Integer.java中：
  public static Integer valueOf(int i) {
      if (i >= IntegerCache.low && i <= IntegerCache.high)
          return IntegerCache.cache[i + (-IntegerCache.low)];
      return new Integer(i);
  }
  ```

  

- **==自动装箱&自动拆箱==**

  自动装箱和自动拆箱是**Java编译器自动完成的**，并不是出现了新语法。

  ```java
  //自动装箱
  Integer x = 10;    //编译器自动转化成：Integer x = Integer.valueOf(10);
  
  //自动拆箱
  int y = x;         //编译器自动转化成：int y = x.intValue();   不是：int y = x.value;
  ```

  

- **==Integer类成员简介==**

  - 属性

    ```java
    //1. value
    //private final int value
    
    //2. MAX_VALUE
    //@Native public static final int  MAX_VALUE
    System.out.println(Integer.MAX_VALUE);
    
    //3. MIN_VALUE
    //@Native public static final int  MIN_VALUE
    System.out.println(Integer.MIN_VALUE);
    ```
  
    ```
    终端：
    2147483647
    -2147483648
    ```
  
    
  
  - 方法
  
    ```java
    //1. valueOf()方法：
    //public static Integer valueOf(int i)
    //1. Returns an Integer instance representing the specified int value
    //返回表示指定int值的Integer实例
    
    //2. If a new Integer instance is not required, this method should generally be used in preference to the constructor Integer(int), as this method is likely to yield significantly better space and time performance by caching frequently requested values.
    //如果不需要新的整数实例，应该优先使用此方法而不是构造函数Integer(int)，因为此方法很可能通过缓存经常请求的值而产生显着更好的空间和时间性能。
    
    //3. This method will always cache values in the range -128 to 127, inclusive, and may cache other values outside of this range.
    //此方法将始终缓存范围在-128到127之间（含）的值，并且可能缓存此范围之外的其他值
    
    //该方法返回value为i的Integer对象的地址，如果i为[-128,127]则返回Integer内部类IntegerCache中已经创建好的对象地址。
    public static Integer valueOf(int i){
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    
    //2. intValue()方法：
    //public int intValue()
    //Returns the value of this Integer as an int
    //该方法将此Integer的值作为int返回
    
    public int intValue(){
        return value;
    }
    ```
  
    
  
  - 构造器
  
    ```java
    //public Integer(int value)
    public Integer(int value) {
        this.value = value;
    }
    
    //public Integer(String s) throws NumberFormatException
    ```
  
  
  
  - 内部类（目前还不清楚其本质）
  
    ```java
    //源代码：Integer.java中
    
    private static class IntegerCache {
            static final int low = -128;
            static final int high;
            static final Integer cache[];
    
            static {
                // high value may be configured by property
                int h = 127;
                String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
                if (integerCacheHighPropValue != null) {
                    try {
                        int i = parseInt(integerCacheHighPropValue);
                        i = Math.max(i, 127);
                        // Maximum array size is Integer.MAX_VALUE
                        h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                    } catch( NumberFormatException nfe) {
                        // If the property cannot be parsed into an int, ignore it.
                    }
                }
                high = h;
    
                cache = new Integer[(high - low) + 1];
                int j = low;
                for(int k = 0; k < cache.length; k++)
                    cache[k] = new Integer(j++);
    
                // range [-128, 127] must be interned (JLS7 5.1.7)
                assert IntegerCache.high >= 127;
            }
    
            private IntegerCache() {}
        }
    ```
    
    

- ==**练习：自定义MyInteger类**==

  - field: value  cache  LOW  HIGH

  - constructor: MyInteger()

  - method: valueOf()  intValue()

    ```java
    //
    
    import java.util.Arrays;
    
    public class MyInteger{
        //核心属性
        private final int value;					//要 + final,final修饰的成员变量不支持默认初始化
        											//在“构造器MyInteger()”初始化
        
        //缓存数组
        private static final MyInteger[] cache;  	// 要 + static,可以在“静态初始化块”初始化；
        										 	// final修饰的成员变量不支持默认初始化
        
        private static final int LOW = -128;		// 要 + static，否则在“静态初始化块”引用会报编译错
        private static final int HIGH = 127;		// ：非静态字段’HIGH’无法从静态上下文引用
        
        //静态初始化块
        static{
            cache = new MyInteger[HIGH-LOW+1];		// 要 + static，否则在“静态初始化块”引用会报编译错
            for(int i = 0;i < HIGH-LOW+1;i++){		// ：非静态字段’HIGH’无法从静态上下文引用
                cache[i] = new MyInteger(i + LOW);
            }
        }
        
        //构造器
        public MyInteger(int value){
            this.value = value;
        }
        
        //valueOf()方法
        public static MyInteger valueOf(int value){
            if(value >= LOW && value <= HIGH){
                return cache[value-LOW];
            }else{
                return new MyInteger(value);
            }
            
        }
        
        //intValue()方法
        public int intValue(){
            return this.value;
        }
        
        //重写Object类的toString()方法
        @Override
        public String toString(){
            return value+"";
        }
        
        public static void main(String[] args){
            
            System.out.println(Arrays.toString(cache));
            
            MyInteger x = MyInteger.valueOf(100);
            MyInteger y = MyInteger.valueOf(100);
            MyInteger a1 = MyInteger.valueOf(1000);
            MyInteger a2 = MyInteger.valueOf(1000);
            
            System.out.println(x == y);
            System.out.println(a1 == a2);
        }
    }
    ```

    ```
    终端：
    [-128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -117, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -99, -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83, -82, -81, -80, -79, -78, -77, -76, -75, -74, -73, -72, -71, -70, -69, -68, -67, -66, -65, -64, -63, -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127]
    true
    false
    ```

    
