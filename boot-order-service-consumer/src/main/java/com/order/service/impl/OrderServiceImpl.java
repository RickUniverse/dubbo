package com.order.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.UserAddress;
import com.gmall.service.OrderService;
import com.gmall.service.UserService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/27 - 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    // Reference 使用dubbo的自动发现注解！！会直接从注册中心找 ,(check = false) 不检查provider服务是否启动
    //(url = "127.0.0.1:2181")// 直连dubbo，不经过注册中心
    //(loadbalance = "random") 负载均衡策略
    @Reference(loadbalance = "random",timeout = 3000)
    private UserService userService;


//    @HystrixCommand(fallbackMethod = "errorMethod")
    @Override
    public List<UserAddress> initOrder(String orderId) throws InterruptedException {
        List<UserAddress> userAddressList = userService.getUserAddressList(orderId);
        return userAddressList;
    }

    public List<UserAddress> errorMethod() {
        return Arrays.asList(new UserAddress("出现错误！！！！"));
    }
}
