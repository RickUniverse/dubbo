package com.gmall.service;


import com.gmall.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressList(String userId) throws InterruptedException;
}
