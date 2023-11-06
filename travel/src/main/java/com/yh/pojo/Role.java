package com.yh.pojo;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 9:11
 * @Description: com.yh.pojo
 * @version: 1.0
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;

    private List<Permission> permissions;
    private List<UserInfo> users;
}
