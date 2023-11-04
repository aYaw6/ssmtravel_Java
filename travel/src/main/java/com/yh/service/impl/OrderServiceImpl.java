package com.yh.service.impl;

import com.yh.mapper.OrderMapper;
import com.yh.pojo.Orders;
import com.yh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/3 - 11 - 03 - 15:39
 * @Description: com.yh.service.impl
 * @version: 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Orders findById(Integer oid) {
        return orderMapper.findById(oid);
    }
}
