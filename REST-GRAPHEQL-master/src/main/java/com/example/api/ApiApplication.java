package com.example.api;

import com.example.api.DTO.RequestCompteDTO;
import com.example.api.Entity.Compte;
import com.example.api.Enums.TypeCompte;
import com.example.api.Service.CompteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteService compteService){
        return args -> {

            for (int i=0 ; i<3 ; i++){
                compteService.save(new RequestCompteDTO(Math.random()*1000,"DHS", TypeCompte.COURANT));
            }
            for (int i=0 ; i<3 ; i++){
                compteService.save(new RequestCompteDTO(Math.random()*1000,"DHS", TypeCompte.EPARGNE));
            }

        };
    }
}
