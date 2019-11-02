package cn.hug.boot.app.token;

import cn.hug.boot.token.service.ISignatureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureServiceTests {
    @Autowired
    private ISignatureService signatureService;

    @Test
    public void testSign() {
        String token = "abc";
        String timestamp = new Date().getTime() + "";
        Map<String, Object> param = new HashMap<>();
        param.put("abc", "abc");
        param.put("Abc", "abc");
        param.put("aBc", "abc");
        param.put("abC", "abc");
        param.put("ABC", "abc");
        param.put("aBC", "abc");
        param.put("AbC", "abc");
        String sign = signatureService.signature(param, token, timestamp);

        log.info("签名：{}", sign);

        signatureService.authSignature(param, token, timestamp, sign);

        log.info("验签：{}", "right");
    }

    @Test
    public void testSign2() {
        String token = "abc";
        String timestamp = new Date().getTime() + "";
        log.info("timestamp:{}", timestamp);
        Map<String, Object> param = new HashMap<>();
        param.put("test", "abc");
        String sign = signatureService.signature(param, token, timestamp);

        log.info("签名：{}", sign);

        signatureService.authSignature(param, token, timestamp, sign);

        log.info("验签：{}", "right");
    }
}
