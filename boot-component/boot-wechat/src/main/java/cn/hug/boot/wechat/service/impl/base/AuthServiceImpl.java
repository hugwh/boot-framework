package cn.hug.boot.wechat.service.impl.base;

import cn.hug.boot.wechat.model.dto.WechatAuthDto;
import cn.hug.boot.wechat.service.base.AuthService;
import cn.hug.boot.wechat.util.WechatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器认证实现类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:09
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void authServer(HttpServletResponse response, WechatAuthDto wechatAuthDto) throws IOException {
        log.info("params:{}", wechatAuthDto.toString());
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        PrintWriter out = response.getWriter();
        if(WechatUtils.checkSignature(wechatAuthDto.getSignature(), wechatAuthDto.getTimestamp(), wechatAuthDto.getNonce())){
            System.out.println("=======请求校验成功======" + wechatAuthDto.getEchostr());
            out.print(wechatAuthDto.getEchostr());
        }
        out.close();
        out = null;
    }
}
