package cn.hug.boot.api.model.dto.result;

import cn.hug.boot.api.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-23 22:42
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDto extends ResultBase {
    private Object data;

    public ResultDto(Object data) {
        super(ResultEnum.OK);
        this.data = data;
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
