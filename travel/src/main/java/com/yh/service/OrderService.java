package com.yh.service;

import com.yh.pojo.Orders;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/3 - 11 - 03 - 15:38
 * @Description: com.yh.service
 * @version: 1.0
 */
public interface OrderService {
    List<Orders> findAll();
    Orders findById(Integer oid);
    //该方法，可以同时，增加订单表，和操作 游客旅游中间表；
    void save(Orders orders,List<Integer>travellerId);
}
