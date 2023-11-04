package com.yh.service.impl;

import com.yh.mapper.MemberMapper;
import com.yh.pojo.Member;
import com.yh.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/4 - 11 - 04 - 10:04
 * @Description: com.yh.service.impl
 * @version: 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }
}
