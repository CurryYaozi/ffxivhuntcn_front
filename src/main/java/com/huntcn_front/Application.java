package com.huntcn_front;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 启动类
 * @author FanJS
 * @date 2022/04/26 10:11
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.huntcn_front.dao")
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        Environment env = context.getEnvironment();
        log.info("====================================================================");
        log.info("项目版本: {1.0}", env.getProperty("project.version"));
        log.info("启动端口: {10076}", env.getProperty("server.port"));
        log.info("日志Appender: {}", env.getProperty("logback.appender"));
        log.info("Swagger: {}", Boolean.valueOf(env.getProperty("swagger.enabled")) ? "启用" : "禁用");
        log.info("Start up Complete ...");
        log.info("====================================================================");
    }
}
