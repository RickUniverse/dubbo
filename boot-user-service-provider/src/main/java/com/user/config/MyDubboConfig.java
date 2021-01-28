package com.user.config;

import com.alibaba.dubbo.config.*;
import com.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/27 - 21:56
 */
@Configuration
public class MyDubboConfig {

    //<dubbo:application name="boot-user-service-provider" />
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    // <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    //<dubbo:protocol name="dubbo" port="20880" />
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /*
    <dubbo:service interface="com.gmall.service.UserService" ref="userService">
<!--        <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>-->
    </dubbo:service>
    * */
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        // method
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
//        methodConfig.setTimeout(2000);

        serviceConfig.setMethods(Arrays.asList(methodConfig));

        return serviceConfig;
    }

    //<dubbo:monitor address="127.0.0.1:7070"/>

    //<dubbo:provider timeout="5000"></dubbo:provider>-->
}
