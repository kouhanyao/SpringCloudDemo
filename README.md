# SpringCloudDemo
spring cloud 自己测试工程


注册中心控制面板一些名词解释:
Eureka server和client之间每隔30秒会进行一次心跳通信，告诉server，client还活着。由此引出两个名词：
Renews threshold：server期望在每分钟中收到的心跳次数
Renews (last min)：上一分钟内收到的心跳次数。

hystrix控制面板首页:
Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，我们可以通过配置该属性来降低客户端的网络和CPU消耗。
Title：该参数对应了上图头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，我们可以通过配置该信息来展示更合适的标题。
实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，如下图所示，它的健康度从绿色、黄色、橙色、红色递减。该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，我们就可以在大量的实例中快速的发现故障实例和高压力实例。
曲线：用来记录2分钟内流量的相对变化，我们可以通过它来观察到流量的上升和下降趋势。
