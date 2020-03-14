package org.nood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: nood
 * @description: 认证服务启动类
 * @author: singhlee
 * @create: 2020-03-11 15:42
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication  {
    public static void main( String[] args )
    {
        SpringApplication.run(AuthApplication.class, args);

    }
}
