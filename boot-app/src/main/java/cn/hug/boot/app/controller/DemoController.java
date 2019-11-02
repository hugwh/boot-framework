package cn.hug.boot.app.controller;

import cn.hug.boot.api.model.dto.result.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 11:47
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/rest")
    public String rest(@RequestBody @Valid TestDto testDto) {
        return "rest";
    }

    @RequestMapping(value = "/index")
    public String index() {
        log.debug("记录debug日志");
        log.info("记录index方法");
        log.error("记录error日志");
        return "index";
    }
}
