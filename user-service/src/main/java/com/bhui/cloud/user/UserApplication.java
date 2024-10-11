package com.bhui.cloud.user;

import com.bhui.cloud.common.handler.FeignConfig;
import com.bhui.cloud.common.handler.SentinelConfig;
import com.bhui.cloud.common.mybatis.MyBatisConfig;
import com.bhui.cloud.common.properties.JwtProperties;
import com.bhui.cloud.common.properties.SsyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@Import({MyBatisConfig.class, FeignConfig.class , SentinelConfig.class})
@EnableConfigurationProperties({SsyProperties.class, JwtProperties.class})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
