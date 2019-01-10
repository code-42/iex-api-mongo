package net.ed.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "net.ed.api.*" })
@PropertySource("classpath:application.properties")
public class AppConfig {}
