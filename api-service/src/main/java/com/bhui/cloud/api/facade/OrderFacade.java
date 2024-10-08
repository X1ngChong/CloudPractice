package com.bhui.cloud.api.facade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bhui.cloud.api.pojo.dto.OrderDTO;
import com.bhui.cloud.api.pojo.query.OrderCreateQuery;

import java.util.List;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderFacade
 **/
public interface OrderFacade {

    @PostMapping("/order/product")
    OrderDTO order(@RequestBody OrderCreateQuery orderCreateQuery);

    @GetMapping("/orders/{uid}")
    List<OrderDTO> orders(@PathVariable("uid") Integer uid);

}