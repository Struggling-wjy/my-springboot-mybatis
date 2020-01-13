package com.example.myspringbootmybatis;

import jdk.nashorn.internal.objects.NativeDebug;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class MySpringbootMybatisApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println("class: " + dataSource.getClass());
        System.out.println("connection: " + dataSource.getConnection());
    }
}
