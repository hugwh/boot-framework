package cn.hug.boot.app.wechat;

import cn.hug.boot.wechat.model.dto.FetchTokenDto;
import cn.hug.boot.wechat.service.base.BaseSupportService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangwh
 * @date: 2019/10/31 13:56
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSupportServiceTest {
    @Autowired
    private BaseSupportService baseSupportService;

    @Test
    public void fetchToken() {
        FetchTokenDto fetchTokenDto = baseSupportService.fetchToken();
        log.info(fetchTokenDto.toString());
    }
}
