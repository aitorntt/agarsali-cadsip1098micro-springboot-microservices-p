package com.dedalow.cad.micro;

import com.dedalow.cad.micro.commons.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.dedalow.cad.micro"})
@Import({SwaggerConfig.class})
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }
}
