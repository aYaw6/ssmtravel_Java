package com.yh.mapper;

import com.yh.pojo.Orders;
import org.junit.jupiter.api.Order;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/3 - 11 - 03 - 11:51
 * @Description: com.yh.mapper
 * @version: 1.0
 */
public interface OrderMapper {
    void updateById(Integer pid);
    List<Orders> findAll();
    Orders findById(Integer oid);
    void save(Orders orders);
}
