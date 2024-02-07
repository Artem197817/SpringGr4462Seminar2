package com.example.empl4sem2CRUD.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "sql")
public class PropertiesSqlRequest {

    private String findAll;
    private String save;
    private String update;
    private String deleteById;
}
