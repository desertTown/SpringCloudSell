package com.jluzh.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductList(@RequestParam("number") Integer number) {
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
