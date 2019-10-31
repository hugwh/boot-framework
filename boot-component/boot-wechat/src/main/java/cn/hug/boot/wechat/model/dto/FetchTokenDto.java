package cn.hug.boot.wechat.model.dto;

import cn.hug.boot.api.model.base.BaseDto;
import lombok.Data;

/**
 * @author: huangwh
 * @date: 2019/10/31 12:45
 */
@Data
public class FetchTokenDto extends BaseDto {
    private String access_token;
    private String expires_in;
}
