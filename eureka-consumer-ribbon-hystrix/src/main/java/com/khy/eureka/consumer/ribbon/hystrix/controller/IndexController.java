package com.khy.eureka.consumer.ribbon.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 寇含尧 on 2018/1/2.
 */
@Controller
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 因为Spring Cloud Ribbon有一个拦截器，能在实际调用的时候自动的选择服务实例,
     * 通过服务实例的IP和端口号替换这里的服务名
     * <p/>
     * <p/>
     * 在为具体执行逻辑的函数上增加@HystrixCommand注解来指定服务降级方法
     *(依赖隔离、服务降级在使用时候都是一体化实现)
     * 默认超时时间是1000毫秒。
     *
     *
     * 出发断路器的三个重要参数：快照时间窗、请求总数下限、错误百分比下限:
     *     快照时间窗：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒。
           请求总数下限：在快照时间窗内，必须满足请求总数下限才有资格根据熔断。默认为20，意味着在10秒内，如果该hystrix命令的调用此时不足20次，即时所有的请求都超时或其他原因失败，断路器都不会打开。
           错误百分比下限：当请求总数在快照时间窗内超过了下限，比如发生了30次调用，如果在这30次调用中，有16次发生了超时异常，也就是超过50%的错误百分比，在默认设定50%下限情况下，这时候就会将断路器打开。
     *
     * 断路器打开后会产生一个休眠时间窗,在休眠时间窗内,主服务断开,降级服务临时成为主服务;休眠时间到点后,断路器成
     * 半开状态,释放一次请求到主服务,主服务返回正常的话断路器关闭,否则再次刷新休眠时间窗
     * @return
     */
    @GetMapping("/index0")
    @HystrixCommand(fallbackMethod = "fallback")
    @ResponseBody
    public String i0() throws InterruptedException {
        Thread.sleep(5000);
        String url = "http://eureka-client" + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/index1")
    @HystrixCommand(fallbackMethod = "fallback")
    @ResponseBody
    public String i1() throws InterruptedException {
        Thread.sleep(5000);
        String url = "http://eureka-client" + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/index2")
    @HystrixCommand(fallbackMethod = "fallback")
    @ResponseBody
    public String i2() throws InterruptedException {
        String url = "http://eureka-client" + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/index3")
    @HystrixCommand(fallbackMethod = "fallback")
    @ResponseBody
    public String i3() throws InterruptedException {
        String url = "http://eureka-client" + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback() {
        return "fallback-error";
    }

}
