package cn.hug.boot.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model {
    @TableId
    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
