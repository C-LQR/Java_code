# Java并发编程



## 1. 线程

- 并发：同一时刻只有1个线程执行，多个线程快速轮换执行。微观上不是同时执行的，但宏观上是同时执行的。

- 并行：同一时刻，多个CPU执行多个线程

  > Java支持多线程，
  >
  > Java.lang.Thread类代表线程的模板，封装了复杂的线程开启等操作。







## 2. 创建线程的三种实现方式



### 2.1 继承Thread类，重写run()方法

> 1. 继承Thread类，重写run()方法
> 2. 子线程对象调用start()方法，开启子线程
> 3. 调用start() ---> 底层调用starts0()方法，底层不是Java书写的 ---> 底层调用run()方法

```java
//测试类

public class MyThread{
    public static void main(String[] args){
        
        //创建子线程对象
        ThreadTest th1 = new ThreadTest();
        th1.setName("兔子"); //设置子线程名字
        th1.start(); //开启子线程
        
        //创建子线程对象
        ThreadTest th2 = new ThreadTest();
        th2.setName("乌龟");//设置子线程名字
        th2.start(); //开启子线程
        
        
    }
}


// 继承Thread类，重写run()方法

class ThreadTest extends Thread{
    @Override
    public void run(){
        for(int i = 1;i <= 100;i++){
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
    }
}

```

```
终端：
乌龟跑了1米
乌龟跑了2米
兔子跑了1米
...
兔子跑了100米
乌龟跑了100米
```





### 2.2 实现Runnable接口，重写run()方法



> 1. 实现Runnable接口，重写run()方法
> 2. Runnable接口实现类的对象不能调用start()方法，需要Thread有参构造器创建子线程对象，再调用start()方法，开启子线程

> ​	优点：一个类如果已经继承了另外的类，还可以实现线程操作



```java
//测试类

public class Test{
    public static void main(String[] args){
        
        //创建Runnable接口实现类的对象
        MyRunnable my1 = new MyRunnable();
        MyRunnable my2 = new MyRunnable();
        
        //创建子线程对象
        Thread th1 = new Thread(my1,"兔子");
        Thread th2 = new Thread(my2,"乌龟");
        
        //开启子线程
        th1.start();
        th2.start();
        
    }
    
}


//实现Runnable接口，重写run()方法

class MyRunnable implements Runnable{
    
    @Override
    public void run(){
        for(int i = 1;i <= 100;i++){
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
        
    }
}
```

```
终端：
乌龟跑了1米
乌龟跑了2米
兔子跑了1米
...
兔子跑了100米
乌龟跑了100米
```



> 思考：有参构造器传入一个Runnable接口实现类的对象
>
> ​		//创建子线程对象
> ​        Thread th1 = new Thread(my1,"兔子");
> ​        Thread th2 = new Thread(my1,"乌龟");





### 2.3 实现Callable接口，结合FutureTask接口



```java
//测试类

public class Test2{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        //创建Callable接口实现类的对象
        MyCallable my1 = new MyCallable();
        
        //创建FutureTask类的对象
        //Callable类型--->FutureTask implements RunnableFuture<v> extends Runnable
        FutureTask<Integer> futureTask1 = new FutureTask<>(my1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(my1);
        
        //创建子线程对象
        Thread th1 = new Thread(futureTask1);
        Thread th2 = new Thread(futureTask2);
        
        //开启子线程
        th1.start();
        th2.start();
        
        //获得当前线程执行结束返回值
        Integer integer1 = futureTask1.get();
        System.out.println(integer1);
        
        //获得当前线程执行结束返回值
        Integer integer2 = futureTask2.get();
        System.out.println(integer2);
        
    }
    
}


//实现Callable接口，重写call()方法

class MyCallable implements Callable<Integer>{
    
    @Override
    public Integer call(){
        int i = new Random().nextInt(10);
        System.out.println(Thread.currentThread().getName()+"-----"+i);
        return i;
    }
}
```

```
终端：
Thread-1-----8
Thread-0-----1
1
8
```



## 3.线程同步



> 优点：保证线程安全
>
> 缺点：由于只有一个线程操作，导致效率下降



### 3.1 线程不安全/线程不同步 介绍

多线程再操作同一资源时，同一时刻只能有一个线程操作，其他线程等待这个线程操作结束后抢占这个资源；

而抢占的这个资源，很可能缺少上个线程对它的必要操作，从而导致错误，造成**线程不安全**，也叫**线程不同步**。

线程不安全案例如下：

```java
//测试类

public class Test3{
    public static void main(String[] args){
        //创建子线程对象
        Thread th1 = new Thread(new MyTicket(),"一号窗口");
        Thread th2 = new Thread(new MyTicket(),"二号窗口");
        
        //开启线程
        th1.start();
        th2.start();
        
    }
    
}


//创建线程的第二种方式

class MyTicket implements Runnable{
    
    //卖出的票数
    static int num = 1;
    
    @Override
    public void run(){
        while(num <= 100){
            System.out.println(Thread.currentThread().getName()+"卖了第"+num+"张票");
            num++;
        }
    }
}
```

```
终端：
一号窗口卖了第1张票
二号窗口卖了第1张票
一号窗口卖了第2张票
一号窗口卖了第3张票
...
一号窗口卖了第99张票
二号窗口卖了第100张票
```

> 问题：一号窗口和二号窗口都卖了第一张票，这不符合事实。
>
> 原因：这是由于“一号窗口”子线程还未对公共资源“num”自增操作，“二号窗口”子线程便开始操作公共资源“num”





### 3.2 如何实现线程同步

实现线程同步的办法：加**锁**

Java中，锁有多种

#### 1. synchronized 同步锁

1. 同步代码块锁

   `synchronized(object){...}`

2. 同步方法锁

   `普通方法：public synchronized void demo1(){...}`

   `静态方法：public static synchronized void demo2(){...}`

#### 2. volatile + CAS 无锁化方案

#### 3. Lock锁

​	ReentrantLock、ReentrantReadWriteLock

### 3.3 synchronized 同步锁

#### 缺点：

1. 造成**死锁**情况，处理不了
2. 不管读操作，还是写操作，都会上锁，线程独占资源。读操作没有必要加锁。
3. 加锁通病：获得该锁的线程由于等待IO或其他原因（如，调用sleep()方法）被阻塞了，但不会释放锁，其他线程只能等待，影响程序执行效率，甚至造成死锁

#### 1. synchronized修饰代码块

- 介绍

  锁是一个Object类型，但要保证多个线程中使用的是同一个锁

  > 在synchronized 同步锁中，这种方式使用频率最高

- object内容

  - 固定值，如："锁"
  - this，被称为对象锁
  - Object.class，被称为类锁

  ```java
  // 测试类
  
  public class Test4{
      public static void main(String[] args){
          //创建子线程对象
          Thread th1 = new Thread(new MyTicket1(),"一号窗口");
          Thread th2 = new Thread(new MyTicket1(),"二号窗口");
          
          //开启线程
          th1.start();
          th2.start();
          
      }
      
  }
  
  
  //创建线程的第二种方式
  //实现Runnable接口，重写run()方法
  
  class MyTicket1 implements Runnable{
      
      //卖出的票数
      static int num = 1;
      
      @Override
      public void run(){
          while(num <= 500){
              
              //synchronized修饰代码块
              //synchronized不能修饰while语句，否则子线程便没有意义
              synchronized("锁"){
                  if(num <= 500){
                      System.out.println(Thread.currentThread().getName()+"卖了第"+num+"张票");
              		num++;
                  }else{
                      System.out.println("票已售罄！")
                  }
                  
              }
              
          }
      }
  }
  ```
  
  ```
  终端：
  一号窗口卖了第1张票
  一号窗口卖了第2张票
  ...
  二号窗口卖了第499张票
  二号窗口卖了第500张票
  票已售罄！
  ```
  



#### 2.synchnorized修饰普通方法

- 介绍

  锁是this，对象锁

  虽然修饰普通方法，但不修饰run()方法，或者子线程无意义

  ```java
  // 测试类
  
  public class Test5{
      public static void main(String[] args){
          
          //创建Runnable接口实现类的对象，有参构造传入的Runnable类型对象必须相同
          MyTicket2 my = new MyTicket2();
  
          //创建子线程对象
          Thread th1 = new Thread(my,"一号窗口");
          Thread th2 = new Thread(my,"二号窗口");
  
          //开启线程
          th1.start();
          th2.start();
          
      }
      
  }
  
  
  
  //创建线程的第二种实现方式
  //实现Runnable接口，重写run()方法
  
  class MyTicket2 implements Runnable{
      
      //迈出的票数
      static int num = 1;
      
      @Override
      public void run(){
          while(num <= 500){
              demo1();
          }
      }
      
      //synchronized修饰普通方法
      public synchronized void demo1(){
          if(num <= 500){
              System.out.println(Thread.currentThread().getName()+"卖了第"+num+"张票");
              num++;
          }else{
              System.out.println("票已售罄！");
          }
      }
  }
  ```

  ```
  终端：
  一号窗口卖了第1张票
  一号窗口卖了第2张票
  ...
  二号窗口卖了第499张票
  二号窗口卖了第500张票
  票已售罄！
  ```



#### 3.synchronized修饰静态方法

- 介绍

  锁是Object.class，类锁

  虽然修饰静态方法，但不修饰run()方法，或者子线程无意义

  ```java
  //测试类
  
  public class Test6{
      public static void main(String[] args){
  
          //创建子线程对象,有参构造传入的Runnable类型对象可以不同，也可以相同
          Thread th1 = new Thread(new MyTicket3(),"一号窗口");
          Thread th2 = new Thread(new MyTicket3(),"二号窗口");
  
          //开启线程
          th1.start();
          th2.start();
          
      }
      
  }
  
  
  //创建线程的第二种实现方式
  //实现Runnable接口，重写run()方法
  
  class MyTicket3 implements Runnable{
      
      //迈出的票数
      static int num = 1;
      
      @Override
      public void run(){
          while(num <= 500){
              demo2();
          }
      }
      
      //synchronized修饰静态方法
      public static synchronized void demo2(){
          if(num <= 500){
              System.out.println(Thread.currentThread().getName()+"卖了第"+num+"张票");
              num++;
          }else{
              System.out.println("票已售罄！");
          }
      }
  }
  ```

  ```
  终端：
  一号窗口卖了第1张票
  一号窗口卖了第2张票
  ...
  二号窗口卖了第499张票
  二号窗口卖了第500张票
  票已售罄！
  ```

  

### 3.4 死锁

#### 产生的原因：加锁后 

1. **多个线程共享多个资源**
2. **多个线程都需要其他线程的资源，每个线程不愿或无法放弃自己的资源**（synchronized同步锁的开关无法人为控制）

死锁案例如下：小明和小红争抢遥控器，遥控器：遥控器壳和电池组成

```java
//测试类

public class Test7{
    public static void main(String[] args){
        
        //创建子线程
        Thread th1 = new Thread(new XiaoMing());
        Thread th2 = new Thread(new XiaoHong());
        
        //开启子线程
        th1.start();
        th2.start();
        
    }
    
}


//创建线程的第二种实现方式
//实现Runnable接口，重写run()方法
//小明
class XiaoMing implements Runnable{
    
    @Override
    public void run(){
        synchronized("遥控器壳"){
            System.out.println("小明抢到了遥控器壳");
            synchronized("电池"){
                System.out.println("小明入手成功，可以看电视了");
            }
        }
    }
}



//创建线程的第二种实现方式
//实现Runnable接口，重写run()方法
//小红
class XiaoHong implements Runnable{
    
    @Override
    public void run(){
        synchronized("电池"){
            System.out.println("小红抢到了电池");
            synchronized("遥控器壳"){
                System.out.println("小红入手成功，可以看电视了");
            }
        }
    }
}
```



大概率造成死锁：小明抢到了遥控器壳，而小红抢到了电池

```
终端：
小明抢到了遥控器壳
小红抢到了电池
(程序未执行完)
```



小概念不会造成死锁

```
终端：
小明抢到了遥控器壳
小明入手成功，可以看电视了
小红抢到了电池
小红入手成功，可以看电视了
```



<font style='color:red'>123</font>







​     
