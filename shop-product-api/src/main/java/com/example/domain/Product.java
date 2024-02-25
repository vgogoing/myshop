package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
@TableName("t_product")
public class Product implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Double price;
    //库存
    private Integer stock;
}
