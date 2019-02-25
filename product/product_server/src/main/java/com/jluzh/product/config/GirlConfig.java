package com.jluzh.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author EvanHuang
 * @date 2/25/2019 9:29 PM
 * @since
 */
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {
    private String name;

    private Integer age;
}
