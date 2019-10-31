package cn.hug.boot.wechat.controller;

import cn.hug.boot.wechat.model.dto.WechatAuthDto;
import cn.hug.boot.wechat.service.base.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: huangwh
 * @date: 2019/10/31 14:30
 */
@Controller
@RequestMapping("/wechat")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping(value = "/auth")
    public void authServer(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr)
            throws IOException {
        WechatAuthDto wechatAuthVO = new WechatAuthDto(signature, timestamp, nonce, echostr);
        authService.authServer(response, wechatAuthVO);
    }
}
