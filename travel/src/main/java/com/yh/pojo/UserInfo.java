package com.yh.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 9:11
 * @Description: com.yh.pojo
 * @version: 1.0
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;

    private List<Role> roles;
}