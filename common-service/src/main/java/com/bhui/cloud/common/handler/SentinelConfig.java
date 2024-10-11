package com.bhui.cloud.common.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentinelConfig {

    @Bean
    public BlockExceptionHandler blockExceptionHandler(){
        return new SentinelExceptionHandler();
    }

    @Bean
    public SentinelRequestOriginParser requestOriginParser(){
        return  new SentinelRequestOriginParser();
    }
}
