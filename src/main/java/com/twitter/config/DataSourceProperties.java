package com.twitter.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Data
@PropertySource(value= {"classpath:application.properties"})
public class DataSourceProperties {
    @Value("${spring.datasource.URL}")
    private String URL;
    @Value("${spring.datasource.USERNAME}")
    private String USERNAME;
    @Value("${spring.datasource.PASSWORD}")
    private String PASSWORD;
}