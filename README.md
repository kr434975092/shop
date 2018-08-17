## SSH网上购物商城
### 本网站实现了Struts2、Hibernate和Spring的整合开发
#### 将两组整合放在一起进行开发，就可以进行三者的组合开发。在进行三者整合开发时，一般可以采取由上往下和由下往上的分层开发的原则，多数实际项目开发，往往采用后者的开发模式，即：
(1)从底层开发，先开发领域对象，即一些实体类，这些领域对象会在各层之间进行传递，利用Hibernate做好领域对象和数据库表的映射关系。<br>
(2)DAO层的开发。它是专门独立出来对数据进行持久化，即处理数据的CRUD操作，也是利用Spring对Hibernate提供的DAO支持类HibernateDaoSupport来实现的。每个DAO组件对应一个数据库表。<br>
(3)Service层的开发。这层主要是具体业务组件开发，主要用于处理各类业务逻辑，并且能隔离事务和对其他资源调度。<br>
(4)Action层开发。主要是处理Web请求，由Spring进行管理。<br>

#### 界面：
首页<br>
![Image text](https://github.com/kr434975092/shop/blob/master/WebRoot/images/%E7%88%B1%E5%A5%87%E8%89%BA20180817205723.png)
登录界面<br>
![Image text](https://github.com/kr434975092/shop/blob/master/WebRoot/images/2018-08-17_205154_%E7%88%B1%E5%A5%87%E8%89%BA.jpg)
商品分类界面<br>
![Image text](https://github.com/kr434975092/shop/blob/master/WebRoot/images/2018-08-17_205358.png)
商品详细界面<br>
![Image text](https://github.com/kr434975092/shop/blob/master/WebRoot/images/2018-08-17_205306.png)
