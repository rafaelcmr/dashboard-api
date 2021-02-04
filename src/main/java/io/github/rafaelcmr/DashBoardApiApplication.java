package io.github.rafaelcmr;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DashBoardApiApplication {
    @Bean
    public CommandLineRunner init(@Autowired ClientRepository repository){
        return args -> {
            repository.save(Client.builder().name("Rafael").cellphone("999999999").build());
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(DashBoardApiApplication.class, args);
    }
}
