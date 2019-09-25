package cn.hug.boot.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 11:47
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/rest")
    public String rest() {
        return "rest";
    }
}
