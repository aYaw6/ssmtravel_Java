package com.yh.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 12:17
 * @Description: com.yh.pojo
 * @version: 1.0
 */
@Data
public class Orders {
    private String id;
    private String orderNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
    //用于添加订单时，添加产品，会员
    private Integer productId;
    private Integer memberId;

    public String getOrderTimeStr() {
        // 对日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        orderTimeStr =  dateFormat.format(orderTime);

        return orderTimeStr;
    }

    public String getPayTypeStr() {
        if (payType == 0){
            payTypeStr = "支付宝";
        } else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其他";
        }

        return payTypeStr;
    }


    public String getOrderStatusStr() {
        if (orderStatus == 0){
            orderStatusStr = "未支付";
        } else if(orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }
}
