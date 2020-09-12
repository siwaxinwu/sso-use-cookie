package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 * author：dingyawu
 * date：created in 10:54 2020/9/12
 * history:
 */
@SpringBootApplication
public class CARTAPP {
    public static void main(String[] args) {
        SpringApplication.run(CARTAPP.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
