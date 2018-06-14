package com.haley.spring0to1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfiguration {

    @Bean
    @Profile("dev")
    public Runnable test1() {

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("开发环境使用的 Bean");
            }
        };
    }
    @Bean
    @Profile("test")
    public Runnable test2() {

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("测试环境使用的 Bean");
            }
        };
    }

    @Bean
    @Profile("pro")
    public Runnable test3() {

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("生成环境使用的 Bean");
            }
        };
    }

}
