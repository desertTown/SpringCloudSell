package com.jluzh.order.VO;

import lombok.Data;


@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}