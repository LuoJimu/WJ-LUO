package com.evan.sanhei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "com.evan.sanhei")
@MapperScan("com.evan.snahei.Mapper")
@EnableTransactionManagement


public class SanheiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanheiApplication.class, args);

    }

}
