package com.example.api.Service;


import com.example.api.DTO.RequestCompteDTO;
import com.example.api.DTO.ResponseCompteDTO;
import com.example.api.Entity.Compte;

import java.util.List;

public interface CompteService{

    ResponseCompteDTO save(RequestCompteDTO requestCompteDTO);
    ResponseCompteDTO update(String id, Compte compte);
    void delete(String id);
    ResponseCompteDTO findById(String id);
    List<ResponseCompteDTO> findAll();
}
