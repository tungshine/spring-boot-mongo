package com.tungshine.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: TangShine
 * @Description:
 * @Date: Create in 1:30 2018/7/19
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
public class MongoApp {
    public static void main(String args[]) {
        SpringApplication.run(MongoApp.class, args);
    }
}
