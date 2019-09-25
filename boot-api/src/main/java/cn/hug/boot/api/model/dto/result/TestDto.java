package cn.hug.boot.api.model.dto.result;

import cn.hug.boot.api.model.base.BaseDto;

import javax.validation.constraints.NotNull;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 15:21
 */
public class TestDto extends BaseDto {

    @NotNull(message = "字段不能为空")
    public String test;
}
