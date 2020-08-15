package com.pangmutou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@MapperScan("com.pangmutou.**.mapper")
@SpringBootApplication
public class DZFWApplication {

    public static void main(String[] args) {
        SpringApplication.run(DZFWApplication.class, args);
    }

}
