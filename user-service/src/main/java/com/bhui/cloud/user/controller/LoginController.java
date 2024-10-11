package com.bhui.cloud.user.controller;

import com.bhui.cloud.api.facade.LoginFacade;
import com.bhui.cloud.api.pojo.query.LoginQuery;
import com.bhui.cloud.common.pojo.ResponseData;
import com.bhui.cloud.common.properties.JwtProperties;
import com.bhui.cloud.common.utils.JwtUtils;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController implements LoginFacade {

    @Resource
    private  JwtProperties jwtProperties;

    @PostMapping("/login")
    @Override
    public ResponseData<String> login(@RequestBody LoginQuery loginQuery) {
        log.info("用户开始登录:[{}]",loginQuery);
        String secretKey = jwtProperties.getSecretKey();
        Map<String,Object> claims = new HashMap<>();
        claims.put("uid","10001");
        claims.put("username",loginQuery.getUsername());
        Date expireDate = DateUtils.addHours(new Date(),24);

        // 生成 Token 并返回
        String token = JwtUtils.createToken(secretKey, null, claims, expireDate);
        if (StringUtils.isNotBlank(token)) {
            return ResponseData.succeed(token);
        } else {
            return ResponseData.failed();
        }
    }
}
