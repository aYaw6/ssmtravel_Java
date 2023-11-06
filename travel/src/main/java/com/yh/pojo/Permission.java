package com.yh.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 9:12
 * @Description: com.yh.pojo
 * @version: 1.0
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;

    private List<Role> roles;
}
