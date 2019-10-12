package com.jdw.switchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SwitchlistApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SwitchlistApplication.class, args);
    }

}
