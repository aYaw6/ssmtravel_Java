package com.yh.service;

import com.yh.pojo.Member;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/4 - 11 - 04 - 10:03
 * @Description: com.yh.service
 * @version: 1.0
 */
public interface MemberService {
    List<Member> findAll();
}
