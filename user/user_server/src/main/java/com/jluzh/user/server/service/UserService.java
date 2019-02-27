package com.jluzh.user.server.service;

import com.jluzh.user.server.dataobject.UserInfo;

/**
 * @author EvanHuang
 * @date 2/27/2019 7:30 PM
 * @since
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
