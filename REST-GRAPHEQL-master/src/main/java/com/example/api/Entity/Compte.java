package com.example.api.Entity;


import com.example.api.Enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    @Id
    private String id;
    private Date creation_compte;
    private Double solde_compte;
    private String devise_compte;

    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
}
