package com.haley.spring0to1;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class BeanConfiguration {

    //可以通过@Value直接读取properties里面的键值
    @Value("${ds.userName}")
    private String userName;

    @Autowired
    private Environment environment;

    @Bean
    @Profile("dev")
    public Runnable test1() {

        return new Runnable() {
            @Override
            public void run() {
              LoggerFactory.getLogger(BeanConfiguration.class).warn("开发环境使用的 Bean");
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
                LoggerFactory.getLogger(BeanConfiguration.class).warn("测试环境使用的 Bean");
                System.out.println("测试环境使用的 Bean");
                System.out.print("userName:"+userName);
                System.out.print("userPassword:"+environment.getProperty("ds.password"));
            }
        };
    }

    @Bean
    @Profile("pro")
    public Runnable test3() {

        return new Runnable() {
            @Override
            public void run() {
                LoggerFactory.getLogger(BeanConfiguration.class).warn("生成环境使用的 Bean");
                System.out.println("生成环境使用的 Bean");
            }
        };
    }

}
