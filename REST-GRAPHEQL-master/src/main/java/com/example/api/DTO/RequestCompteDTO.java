package com.example.api.DTO;


import com.example.api.Enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RequestCompteDTO {

    private Double solde_compte;
    private String devise_compte;
    private TypeCompte typeCompte;
}
