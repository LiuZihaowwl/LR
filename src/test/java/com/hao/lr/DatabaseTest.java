package com.hao.lr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

/**
 * @ClassName DatabaseTest
 * @Description
 * @Author Administrator
 * @Date 2020/5/30 11:06
 * @Version 1.0
 **/
@SpringBootTest
public class DatabaseTest {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception {
        System.out.println("获取的数据库连接为:" + dataSource.getConnection());
    }
}


