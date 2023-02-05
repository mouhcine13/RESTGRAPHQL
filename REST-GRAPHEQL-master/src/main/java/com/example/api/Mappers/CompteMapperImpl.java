package com.example.api.Mappers;

import com.example.api.DTO.RequestCompteDTO;
import com.example.api.DTO.ResponseCompteDTO;
import com.example.api.Entity.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapperImpl implements CompteMapper{
    @Override
    public Compte deRequestCompteACompte(RequestCompteDTO requestCompteDTO) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(requestCompteDTO,compte);
        return compte;
    }

    @Override
    public ResponseCompteDTO deCompteAResponseCompte(Compte compte) {

        ResponseCompteDTO responseCompteDTO = new ResponseCompteDTO();
        BeanUtils.copyProperties(compte,responseCompteDTO);
        return responseCompteDTO;
    }
}
