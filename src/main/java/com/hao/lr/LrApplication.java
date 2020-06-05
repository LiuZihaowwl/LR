package com.hao.lr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hao.lr.mapper") //直接在这里扫描就不用每个mapper类上添加@Mapper
public class LrApplication {

    public static void main(String[] args) {
        SpringApplication.run(LrApplication.class, args);
    }

}
