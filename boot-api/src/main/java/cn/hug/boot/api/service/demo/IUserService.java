package cn.hug.boot.api.service.demo;

import cn.hug.boot.api.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-05 15:34
 */
public interface IUserService extends IService<User> {
    User selectById(Long id);
}
