package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.ProductMapper;
import com.example.server.service.ProductService;
import org.example.pojo.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
