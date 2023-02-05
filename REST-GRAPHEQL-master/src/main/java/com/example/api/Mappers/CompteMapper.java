package com.example.api.Mappers;


import com.example.api.DTO.RequestCompteDTO;
import com.example.api.DTO.ResponseCompteDTO;
import com.example.api.Entity.Compte;

public interface CompteMapper{

    Compte deRequestCompteACompte(RequestCompteDTO requestCompteDTO);
    ResponseCompteDTO deCompteAResponseCompte(Compte compte);
}
