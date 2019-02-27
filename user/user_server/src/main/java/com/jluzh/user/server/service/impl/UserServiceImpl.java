package com.jluzh.user.server.service.impl;

import com.jluzh.user.server.dataobject.UserInfo;
import com.jluzh.user.server.repository.UserRepository;
import com.jluzh.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author EvanHuang
 * @date 2/27/2019 7:32 PM
 * @since
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
