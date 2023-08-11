# Markdown、Typora、图床和PicGo的关系



## ==Markdown==

![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/80cb39dbb6fd5266d0162fdb3654802bd40734fa98e2.jpg)

- 介绍
  
  Markdown是一种**轻量级标记语言**，易读易写，并且对图片、图表、数学式都有支持。
  
  Markdown ⽂档格式：xxx.md
  
  



## ==Typora==

![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/10001.png)

- 介绍

  Typora是众多**Markdown编辑器**中比较受欢迎的一款付费软件。



- 问题

  因为 Markdown 编辑器的⽂档⽆法内嵌图⽚，所有图⽚都以 `![](图⽚链接) `的 形式写在 Markdown ⽂档内，如果这⾥的「图⽚链接」使⽤的是本地图⽚的链接，则当你分享这⼀个 Markdown ⽂档或者你⾃⼰在别的地⽅打开这个 Markdown ⽂档时又或者本地图片存放位置发生改变时，⽂档⾥的图⽚就⽆法正常显示了



- 解决方法
  - 将 Markdown 编辑器的⽂档**导出为PDF文件**，图片将内嵌入PDF文件中
  - 将**图⽚上传到图床**，⽣成⼀个在线的图⽚链接后，在任意地⽅分享、打开这个 Markdown ⽂件，所有的图⽚就都能正常显示
    
    

- 下载方式

  [Typora官方中文站](https://typoraio.cn)

  ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Typora-buy.JPG)







- 激活

  在激活前，Typora会有15天的体验期。

  激活步骤：

  1. typora—文件—偏好设置—通用—Typora服务器—勾选**Typora服务使用国内服务器**

     ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Typora-set.JPG)

     

  2. 进入[Typora官方中文站](https://typoraio.cn)，购买方式二选一：

     1. [2Checkout - Your online payment solution](https://secure.2checkout.com/order/checkout.php?PRODS=37673796&QTY=1&CART=1&SHORT_FORM=1&ORDERSTYLE=nLWw4pa5hHU%3D&CARD=2&CURRENCY=CNY&LANGUAGES=en&PAY_TYPE=ALIPAY&__c=1)

     2. [Typora - 跨平台 Markdown 编辑器 所见即所得 支持 Latex 公式 - 荔枝软件商店 (lizhi.io)](https://store.lizhi.io/site/products/id/520?cid=lpuwt9hw)

        ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/Typora-buy.JPG)

        

  3. 购买后，Typora通过你的邮箱发送邮件，邮件内有激活密钥；或者返回购买界面，购买界面有激活密钥。

     ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/typora%E8%B4%AD%E4%B9%B01.png)

  

  

## ==图床==

- 介绍

  简单讲，所谓的图床就是⽤来**在线存放图⽚的地⽅**，同时允许你把图片对外连接的网上空间。你可以先简单粗暴地理解为图床就是专⻔⽤来存放图⽚的⽹盘。图床上的每⼀张图⽚都能够⽣成⼀个唯⼀的访问链接，使⽤这个链接，任何⼈都能够访问你的这张图⽚。



- 如何搭建

  使用**腾讯云对象存储（COS）**搭建图床，当然也可以使用其他方式搭建图床。

  使用**腾讯云对象存储（COS）**+ **PicGo软件** 可以搭建自动化图床，将图片通过PicGo上传到图床中。

  

- 步骤：
  - 注册腾讯云账号 [腾讯云](https://cloud.tencent.com/)，登陆微信扫码。
  - 开通并配置腾讯云对象存储（COS）[腾讯云对象存储](https://console.cloud.tencent.com/cos)
  - 安装PicGo软件，将腾讯云对象存储（COS）的相关参数配置到PicGo中
    
    

## ==PicGo==

![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/PicGo-icon.png)

- 介绍

  PicGo是一个用于快速**上传本地图片到图床并获取图片在图床内的URL链接的工具**，目前支持微博图床、七牛图床、腾讯云、又拍云、GitHub、阿里云、Imgur等图床

  ![](https://lqr-1317479009.cos.ap-shanghai.myqcloud.com/v2-f220590559e8ab43e2feac88daaf0282_720w.png)



- 下载

  [PicGo官网](https://molunerfinn.com/PicGo/)



