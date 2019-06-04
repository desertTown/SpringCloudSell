package com.jluzh.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**服务降级， 消息熔断
 * @author EvanHuang
 * @date 2/28/2019 6:45 PM
 * @since
 */
@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")   // 这个是指定使用默认的降级方法， 需要将具体方法上的fallbackMethod参数去掉
public class HystrixController {
    //超时配置  因为默认如果1秒类没有拿到值，  该服务就会进行降级处理，  可以进行超时配置，@HystrixProperty 里面的属性值可以从HystrixCommandProperties中找到
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//	})

    /**
     * 当断路器打开，对主逻辑进行熔断之后，Hystrix会启动一个休眠时间窗， 这个时间窗内， 降级逻辑回成为主逻辑， 当休眠时间窗到期，
     * 断路器会进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么断路器将继续闭合。主逻辑恢复，如果这次请求
     * 依然有问题，断路器将继续进入打开状态，休眠时间窗重新计时
     * @param number
     * @return
     */
//    @HystrixCommand(commandProperties = {
//        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  				//设置熔断
//        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//请求数达到后才计算
//        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
//        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//错误率
//        //  ①localhost:8864/getProductInfoList?number=1 （会熔断）
//        //  ②localhost:8864/getProductInfoList?number=2  （不会熔断）
//        //  如果一段时间内访问①的次数（即会熔断的次数）超过60%，访问②也会出现熔断， 断路器会被打开
//            // 例如在10秒内， 访问10次， 超过7次出现熔断， 那么这时候断路器会被设置成打开状态， 其他任何接口去访问都会熔断，无法访问， 之后再访问一次正常的接口， 熔断器又会闭合
//	})

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductList(@RequestParam("number") Integer number) {
        if (number % 2 ==0) {
            return "success";
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8762/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);

    // 触发降级不一定是无法调用其他服务时做的事， 也可以在自己服务中出现异常是进行服务降级
//        throw new RuntimeException();
    }

    public String fallback(Integer number) {
        return "太拥挤了, 请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了, 请稍后再试~~";
    }
}
