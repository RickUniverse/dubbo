package com.gmall.service;

import com.gmall.bean.UserAddress;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/27 - 16:43
 */
public interface OrderService {
    List<UserAddress> initOrder(String orderId) throws InterruptedException;
}
