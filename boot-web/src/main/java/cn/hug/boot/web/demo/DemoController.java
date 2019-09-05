package cn.hug.boot.web.demo;

import cn.hug.boot.api.service.demo.IDemoService;
import cn.hug.boot.api.service.demo.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-05 15:09
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService demoService;
    @Autowired
    private IUserService userService;

    @GetMapping
    public void demo() {
        demoService.demo();
        userService.selectById(1l);
    }
}
