package com.example.empl4sem2CRUD;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.empl4sem2CRUD.model")
public class Empl4sem2CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Empl4sem2CrudApplication.class, args);
    }

}
