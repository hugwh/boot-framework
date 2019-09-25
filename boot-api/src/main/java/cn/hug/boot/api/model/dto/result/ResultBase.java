package cn.hug.boot.api.model.dto.result;

import cn.hug.boot.api.enums.ResultEnum;
import cn.hug.boot.api.model.base.BaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * rest 统一返回格式
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-23 22:19
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ResultBase extends BaseDto {
    protected Integer status;
    protected String message;

    public ResultBase(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }

    public String toString() {
        return new StringBuffer()
                .append("{")
                .append("status").append(":").append(status)
                .append(",")
                .append("message").append(":").append(message)
                .append("}")
                .toString();
    }
}
