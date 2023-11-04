package com.yh.mapper;

import com.yh.pojo.Member;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/4 - 11 - 04 - 9:57
 * @Description: com.yh.mapper
 * @version: 1.0
 */
public interface MemberMapper {
    List<Member> findAll();
}
