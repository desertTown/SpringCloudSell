package com.jluzh.api_gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.jluzh.api_gateway.exeption.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @author EvanHuang
 * @date 2/26/2019 9:46 PM
 * @since
 */
//限流拦截器，  令牌桶实现
@Component
public class RateLimiterFilter extends ZuulFilter{

    // 每秒钟从桶里以释放100个令牌的速度释放，  在同一秒时刻超过100个的令牌会被令牌桶抛弃
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 在FilterConstant 中找到最低的排序， 限流的拦截顺序需要比最高的还要高,  优先级最高

        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 如果从桶里没有拿到令牌,逻辑根据业务情况处理
        if (!RATE_LIMITER.tryAcquire()) {
            throw  new RateLimitException();
        }
        return null;
    }
}
