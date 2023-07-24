# 反射和注解（Reflection & Annotation）

**主要内容**

- 反射
- Class类型
- Field
- Method
- 注解
- 元注解
- 自定义注解



 ## 一. 反射

### 1. 介绍

- ==**介绍：**==

  - 为什么使用反射

    平时用不到反射，后期学框架时才用到，用来降低耦合性。

    当前实例化对象的方式都是**new方式创建对象**，优点：简单明了；缺点：耦合性高

    Spring框架可以解决这一缺点：Spring创建对象通过`.xml`文件配置

    

  - Spring底层如何通过这样配置来创建对象

    1. 使用DOM解析来获得节点属性，可以获得id/class

    2. class的值是一个String字符串

    3. 如何通过一个字符串来创建对象？使用反射

       ```java
       //
       
       String str = "com.bjsxt.demo01.Student";
       
       ```

        