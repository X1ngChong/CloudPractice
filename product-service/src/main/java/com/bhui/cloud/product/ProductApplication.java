package com.bhui.cloud.product;

import com.bhui.cloud.common.handler.FeignConfig;
import com.bhui.cloud.common.handler.SentinelConfig;
import com.bhui.cloud.common.mybatis.MyBatisConfig;
import com.bhui.cloud.common.properties.SsyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({SsyProperties.class})
@Import({MyBatisConfig.class, FeignConfig.class, SentinelConfig.class})
@MapperScan(basePackages = {"com.bhui.cloud.product.mapper"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
