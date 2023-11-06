package com.yh.service.impl;

import com.yh.mapper.OrderAndTravellerMapper;
import com.yh.mapper.OrderMapper;
import com.yh.pojo.Orders;
import com.yh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    OrderAndTravellerMapper orderAndTravellerMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Orders findById(Integer oid) {
        return orderMapper.findById(oid);
    }

    @Transactional
    @Override
    public void save(Orders orders, List<Integer> travellerId) {
        //1.增加订单信息;insert
        orderMapper.save(orders);
        //2.增加中间表的信息; 第一个参数：新增加订单的id；是自增的；
        //                 第二个参数：游客有哪些，游客id;
        //insert
        orderAndTravellerMapper.add(orders.getId(),travellerId);
    }
}
