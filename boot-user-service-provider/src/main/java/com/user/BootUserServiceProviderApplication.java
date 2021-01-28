package com.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo// 开启基于dubbo的服务发现
//@ImportResource(locations = "classpath:provider.xml")// 使用保留配置文件的方式配置dubbo , 不知道为什么就是不能用！
@EnableDubbo(scanBasePackages = "com.user") // 这个版本跟老师的必须一致：<version>0.2.0</version>
//@EnableHystrix// 开启服务容错
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
