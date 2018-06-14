package com.haley.spring0to1;

import com.haley.spring0to1.domain.model.DataSourceProperties;
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
public class SpringbootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(SpringbootApplication.class, args);
        context.getBean(DataSourceProperties.class).show();
    }
}
