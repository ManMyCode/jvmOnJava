package com.wangzhen.springx.demo.service.impl;

import com.wangzhen.springx.demo.entity.User;
import com.wangzhen.springx.demo.service.IUserService;

/**
 * Description:
 * Datetime:    2020/10/25   4:56 下午
 * Author:   王震
 */
public class UserService implements IUserService {

    @Override
    public void sayName(User usre) {
        System.out.println(usre.toString());
    }
}
