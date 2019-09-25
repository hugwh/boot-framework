package cn.hug.boot.app.controller;

import cn.hug.boot.api.model.dto.result.ResultDto;
import cn.hug.boot.token.service.ITokenService;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * token 控制类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 11:02
 */
@RestController
public class TokenController {
    @Autowired
    private ITokenService tokenService;

    @GetMapping("/token/{id}")
    public ResultDto getToken(@PathVariable String id) {
        String token = tokenService.create(id);
        JSONObject data = new JSONObject();
        data.put("token", token);

        return new ResultDto(data);
    }
}
