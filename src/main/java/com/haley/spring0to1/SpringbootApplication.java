package com.haley.spring0to1;

import com.haley.spring0to1.domain.model.DataSourceProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringbootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootApplication.class);

//        application.setBannerMode(Banner.Mode.OFF);// 关闭启动Banner
        application.setBannerMode(Banner.Mode.CONSOLE);// 输出Banner到控制台
//        application.setBannerMode(Banner.Mode.LOG);// 输出Banner到日志中

        ApplicationContext context = application.run(args);
        context.getBean(DataSourceProperties.class).show();

    }
}
