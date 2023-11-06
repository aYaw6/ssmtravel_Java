package com.yh.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/4 - 11 - 04 - 12:03
 * @Description: com.yh.mapper
 * @version: 1.0
 */
public interface OrderAndTravellerMapper {
    //中间表order_traveller 添加   参数1：订单id   参数2：旅客ids;[1,2]
    void add(@Param("orderId") Integer orderId, @Param("travellerId") List<Integer> travellerId );
    //不加参数;
//    void add(Integer orderId,List<Integer> travellerId);
}
