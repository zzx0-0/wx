package com.example.wx.utils;

import com.example.wx.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Util {

    public static ResponseVO ff(int row) {
        if (row == 0)
            throw new RuntimeException("数据库操作不成功");
        return ResponseVO.success();
    }

}
