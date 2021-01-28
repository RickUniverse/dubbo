package com.order;

import com.gmall.service.OrderService;
import com.gmall.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lijichen
 * @date 2021/1/27 - 17:36
 */
// 扫描消费者的包
//@ComponentScan(basePackages = "com.order.service.impl")
public class MainOrderApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        OrderService demoService = (OrderService)context.getBean(OrderService.class); // 获取远程服务代理

        demoService.initOrder("1");

        System.out.println("执行完成！");
        System.in.read();
    }
}
