package cn.hug.boot.api.service.user;

import cn.hug.boot.api.model.entity.User;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-06 11:43
 */
public interface IUserService {
    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return user
     */
    User findByUserName(String username);
}
