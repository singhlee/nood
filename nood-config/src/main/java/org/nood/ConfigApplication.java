package org.nood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication
{
    public static void main( String[] args )

    {
        SpringApplication application = new SpringApplication(ConfigApplication.class);
        ApplicationContext applicationContext = application.run(args);
        System.out.println(applicationContext.getClass());
    }
}
