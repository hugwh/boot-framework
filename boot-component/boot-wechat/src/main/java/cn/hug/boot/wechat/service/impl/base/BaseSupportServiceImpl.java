package cn.hug.boot.wechat.service.impl.base;

import cn.hug.boot.api.util.HttpUtils;
import cn.hug.boot.wechat.constant.WechatConstants;
import cn.hug.boot.wechat.model.dto.FetchTokenDto;
import cn.hug.boot.wechat.service.base.BaseSupportService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author: huangwh
 * @date: 2019/10/31 12:47
 */
@Service
public class BaseSupportServiceImpl implements BaseSupportService {

    /**
     * 获取token
     * @return
     */
    @Override
    public FetchTokenDto fetchToken() {
        String url = StrUtil.format(WechatConstants.FETCH_TOKEN_URL, WechatConstants.GRANT_TYPE, WechatConstants.APP_ID,
                WechatConstants.APP_SECRET);

        return HttpUtils.get(url, FetchTokenDto.class);
    }
}
