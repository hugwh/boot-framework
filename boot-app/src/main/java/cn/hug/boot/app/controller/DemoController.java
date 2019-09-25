package cn.hug.boot.app.controller;

import cn.hug.boot.api.model.dto.result.TestDto;
import cn.hug.boot.token.annotation.AuthToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 11:47
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @AuthToken
    @GetMapping("/rest")
    public String rest(@RequestBody @Valid TestDto testDto) {
        return "rest";
    }
}
