package cn.hug.boot.app.controller;

import cn.hug.boot.api.exception.AuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 14:23
 */
@RestController
public class ExceptionController {

    @GetMapping("/bex")
    public void businessException() {
        throw new AuthException("认证异常");
    }
}
