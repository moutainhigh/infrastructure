package cn.jastz.mall.api;

import me.jastz.swagger.spring.boot.autoconfig.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author zhiwen
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"cn.jastz.mall.api"})
@EnableOAuth2Client
@EnableSwagger
public class MallApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication.class, args);
    }

}