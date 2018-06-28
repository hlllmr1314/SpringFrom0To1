package com.haley;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
//@ImportResource({"classpath:some-context.xml"})// 使用xml配置
public class Spring0to1Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Spring0to1Application.class);

//        application.setBannerMode(Banner.Mode.OFF);// 关闭启动Banner
        application.setBannerMode(Banner.Mode.CONSOLE);// 输出Banner到控制台
//        application.setBannerMode(Banner.Mode.LOG);// 输出Banner到日志中

        ConfigurableApplicationContext context = application.run(args);

    }
}
