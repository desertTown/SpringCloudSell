package com.jluzh.order.exception.handler;

import com.jluzh.order.VO.ResultVO;
import com.jluzh.order.enums.ResultEnum;
import com.jluzh.order.exception.OrderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResultVO<String> r = new ResultVO<>();
        r.setData(null);
        r.setCode(500);
        r.setMsg(e.getMessage());
        return r;
    }
}
