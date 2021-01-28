package com.order.service.impl;

import com.gmall.bean.UserAddress;
import com.gmall.service.OrderService;
import com.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/27 - 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String orderId) throws InterruptedException {

        List<UserAddress> userAddressList = userService.getUserAddressList(orderId);
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress);
        }
        return userAddressList;
    }
}
