package cn.hug.boot.service.demo;

import cn.hug.boot.api.model.entity.User;
import cn.hug.boot.api.service.demo.IUserService;
import cn.hug.boot.repository.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-05 15:35
 */
@Slf4j
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
