package cn.hug.boot.repository.mapper;


import cn.hug.boot.api.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return user
     */
    User findByUserName(@Param("username") String username);
}
