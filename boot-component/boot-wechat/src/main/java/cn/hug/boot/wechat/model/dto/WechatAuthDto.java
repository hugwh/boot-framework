package cn.hug.boot.wechat.model.dto;

import cn.hug.boot.api.model.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: huangwh
 * @date: 2019/10/31 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatAuthDto extends BaseDto {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
