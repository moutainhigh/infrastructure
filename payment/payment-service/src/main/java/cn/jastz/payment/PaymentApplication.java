package cn.jastz.payment;

import com.github.wxpay.sdk.WXPayConfig;
import me.jastz.common.wx.WxTemplates;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@Configuration
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication(scanBasePackages = {"cn.jastz.payment", "cn.jastz.common"})
@MapperScan(basePackages = "cn.jastz.*.mapper")
@EnableFeignClients("cn.jastz.*.client")
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public WxTemplates wxTemplates(WXPayConfig wxPayConfig) {
        return new WxTemplates(wxPayConfig);
    }
}
