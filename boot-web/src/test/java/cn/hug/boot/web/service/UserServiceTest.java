package cn.hug.boot.web.service;

import cn.hug.boot.api.model.entity.User;
import cn.hug.boot.api.service.demo.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-05 15:37
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        User user = userService.selectById(1l);
        log.info("查询结果：{}", user);
    }
}
