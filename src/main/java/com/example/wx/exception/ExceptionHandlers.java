package com.example.wx.exception;

import com.example.wx.enums.ResponseEnum;
import com.example.wx.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
//	@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVO handle(RuntimeException e) {
        e.printStackTrace();
        return ResponseVO.error(ResponseEnum.ERROR, e.getMessage());
    }

}
