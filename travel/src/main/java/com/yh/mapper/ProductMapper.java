package com.yh.mapper;

import com.yh.pojo.Product;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 14:23
 * @Description: com.yh.mapper
 * @version: 1.0
 */
public interface ProductMapper {
    List<Product> findAll();
    void save(Product product);
    Product findById(int pid);
    void edit(Product product);
    void deleteById(Integer pid);
}
