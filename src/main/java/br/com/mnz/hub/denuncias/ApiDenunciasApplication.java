package br.com.mnz.hub.denuncias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiDenunciasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDenunciasApplication.class, args);
    }

}
