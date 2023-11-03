package com.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 10:38
 * @Description: com.yh
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.yh.mapper")//扫描mapper接口
public class SSMApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSMApplication.class);
    }
}
