package com.jluzh.user.server.repository;

import com.jluzh.user.server.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author EvanHuang
 * @date 2/27/2019 7:28 PM
 * @since
 */
public interface UserRepository extends JpaRepository<UserInfo, String>{

    UserInfo findByOpenid(String openid);
}
