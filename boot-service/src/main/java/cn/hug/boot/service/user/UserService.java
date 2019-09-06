package cn.hug.boot.service.user;

import cn.hug.boot.api.model.entity.User;
import cn.hug.boot.repository.mapper.UserMapper;
import cn.hug.boot.api.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-06 11:43
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }
}
