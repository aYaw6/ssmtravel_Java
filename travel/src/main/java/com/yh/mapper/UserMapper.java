package com.yh.mapper;

import com.yh.pojo.UserInfo;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 11:47
 * @Description: com.yh.mapper
 * @version: 1.0
 */
public interface UserMapper {
    //这个方法，到查询所有再用
    //List<UserInfo> findAll();

    UserInfo findUserByUserName(String username);
}
