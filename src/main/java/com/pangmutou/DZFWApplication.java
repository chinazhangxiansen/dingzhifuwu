package com.pangmutou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@MapperScan("com.pangmutou.**.mapper")
@SpringBootApplication
public class DZFWApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DZFWApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DZFWApplication.class);
    }
}
