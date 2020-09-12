package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 * author：dingyawu
 * date：created in 10:24 2020/9/12
 * history:
 */
@SpringBootApplication
public class MainAPP {
    public static void main(String[] args) {
        SpringApplication.run(MainAPP.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
