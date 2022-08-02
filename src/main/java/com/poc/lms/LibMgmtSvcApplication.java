package com.poc.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.poc.lms.model")
public class LibMgmtSvcApplication{

    public static void main(String[] args){
        SpringApplication.run(LibMgmtSvcApplication.class, args);
    }

}
