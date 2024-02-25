package com.example.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@TableName("t_order")
@Setter
@Getter
@ToString
public class Order implements Serializable {
    //订单id
    @TableId(type = IdType.AUTO)
    private Long id;
    //用户id
    private Long uid;
    //用户名
    private String username;
    //商品id
    private Long pid;
    //商品名称
    private String productName;
    //商品单价
    private Double productPrice;
    //购买数量
    private Integer number;
}
