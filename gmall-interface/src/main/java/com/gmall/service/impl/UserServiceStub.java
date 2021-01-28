package com.gmall.service.impl;

import com.gmall.bean.UserAddress;
import com.gmall.service.UserService;

import java.util.List;

/**
 * 本地存根类，可以在调用远程方法前做验证
 * @author lijichen
 * @date 2021/1/27 - 20:50
 */
public class UserServiceStub implements UserService {

    public final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) throws InterruptedException {
        if (!userId.isEmpty()){
            System.out.println("本地存根判断成功！");
            List<UserAddress> userAddressList = userService.getUserAddressList(userId);
            return userAddressList;
        }
        return null;
    }
}
