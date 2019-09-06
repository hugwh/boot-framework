package cn.hug.boot.api.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-06 11:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Model {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>();
}
