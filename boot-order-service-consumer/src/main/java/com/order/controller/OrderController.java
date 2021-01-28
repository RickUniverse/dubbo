package com.order.controller;

import com.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/27 - 18:42
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("initOrder")
    public Object initOrder() throws InterruptedException {
        return orderService.initOrder("1");
    }
}
