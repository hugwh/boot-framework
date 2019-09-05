package cn.hug.boot.service.demo;

import cn.hug.boot.api.service.demo.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-05 15:07
 */
@Slf4j
@Service
public class DemoService implements IDemoService {
    @Override
    public void demo() {
        log.info("测试接口实现类成功！");
    }
}
