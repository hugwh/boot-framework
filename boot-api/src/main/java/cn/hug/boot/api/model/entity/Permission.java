package cn.hug.boot.api.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限表实体类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-06 11:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends Model {
    private Integer pid;
    private String name;
    private String url;
}
