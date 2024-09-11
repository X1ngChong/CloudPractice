package com.bhui.cloud.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping("/orders/{userId}")
    List<String> getUserOrders(@PathVariable("userId") String userId);
}
