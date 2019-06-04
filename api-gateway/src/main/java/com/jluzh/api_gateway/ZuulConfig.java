package com.jluzh.api_gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @author EvanHuang
 * @date 2/26/2019 8:13 PM
 * @since
 */
@Component
public class ZuulConfig {

    // 配置的动态注入
    @ConfigurationProperties(prefix = "zuul")
    @RefreshScope
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
