package cn.hug.boot.wechat.constant;

/**
 * 常量类
 * @author: huangwh
 * @date: 2019/10/31 12:49
 */
public interface WechatConstants {
    //微信号信息
    String APP_ID = "wxe4782be5853a0fea";
    String APP_SECRET = "d0a83887d88da9b4c3fdb5118217afe3";

    String CONFIG_TOKEN = "hugwh";

    //获取token
    String FETCH_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type={}&appid={}&secret={}";
    String GRANT_TYPE = "client_credential";
}
