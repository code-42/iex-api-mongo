package net.ed.api;

/*
 * Copyright 2019 Edward Dupre 
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "net.ed.api.*" })
@PropertySource("classpath:application.properties")
public class AppConfig {}

// @PropertySource allows hiding passwords, connection strings and other information
// we dont want exposed to hackers
