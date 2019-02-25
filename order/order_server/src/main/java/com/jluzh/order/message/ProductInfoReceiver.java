package com.jluzh.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jluzh.order.utils.JsonUtil;
import com.jluzh.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author EvanHuang
 * @date 2/25/2019 9:58 PM
 * @since
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutputList);

    }

}
