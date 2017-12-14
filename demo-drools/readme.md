### 一 Drools 研究背景(痛点):

## 1.可维护差
	对于一些充斥着大量的if-else逻辑的后台逻辑代码，其业务会随着逻辑规则复杂度越来越高，代码可读性和维护性越来越差
	 期望：业务规则与稳定系统逻辑分离
     
## 2.对业务响应慢
	随着产品设计的定制化需求提升，发布新的理赔规则便需要重启整个业务线
	期望：快速定义规则,实时生效


demo待实现目标：
1.简单演示：读取规则文件，执行规则，计算返回结果:
   com.myron.drools.test.OrderTest main()
2.与spring整合

3.生产环境可实现
相关业务线将规则逻辑隔离出来，新建drools工程编drl文件，算法class文件，封装打包成规则jar包，上传至maven私服，Dools规则引擎会定时轮询更新私服内的规则包，
根据版本号更新至最新版本的规则jar包。Dools规则引擎则对规则文件进行解析，并对外提供规则调用接口，在相应业务调用时，输入Factor参数，返回规则执行结果。



学习drools收集的参考资料 
drools6入门例子(二) http://blog.csdn.net/mn960mn/article/details/47778423
drools 6.5 决策表使用 http://blog.csdn.net/u012373815/article/details/53821502?locationNum=1&fps=1
