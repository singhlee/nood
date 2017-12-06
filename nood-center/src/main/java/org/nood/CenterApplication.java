package org.nood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Title:
 * Description:
 * Date: 2017/7/5 0005
 *
 * @author: LX
 */
@SpringBootApplication
@EnableEurekaServer
public class CenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }
}
