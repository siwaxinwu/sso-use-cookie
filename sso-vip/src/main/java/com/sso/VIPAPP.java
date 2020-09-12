package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 * author：dingyawu
 * date：created in 10:51 2020/9/12
 * history:
 */
@SpringBootApplication
public class VIPAPP {
    public static void main(String[] args) {
        SpringApplication.run(VIPAPP.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
