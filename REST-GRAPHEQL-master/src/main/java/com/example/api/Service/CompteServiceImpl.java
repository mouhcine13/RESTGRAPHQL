package com.example.api.Service;


import com.example.api.DTO.RequestCompteDTO;
import com.example.api.DTO.ResponseCompteDTO;
import com.example.api.Entity.Compte;
import com.example.api.Mappers.CompteMapper;
import com.example.api.Repository.CompteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService{


    private CompteRepository compteRepository;
    private CompteMapper compteMapper;

    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }


    @Override
    public ResponseCompteDTO save(RequestCompteDTO requestCompteDTO) {
        Compte compte = compteMapper.deRequestCompteACompte(requestCompteDTO);
        compte.setId(UUID.randomUUID().toString());
        compte.setCreation_compte(new Date());

        Compte compte_saved = compteRepository.save(compte);


        return compteMapper.deCompteAResponseCompte(compte_saved);
    }

    @Override
    public ResponseCompteDTO update(String id, Compte compte) {

        Compte compte_updated = compteRepository.findById(id).orElseThrow();

        if(compte.getDevise_compte() != null) compte_updated.setDevise_compte(compte.getDevise_compte());
        if(compte.getSolde_compte() != null) compte_updated.setSolde_compte(compte.getSolde_compte());
        if(compte.getTypeCompte() != null) compte_updated.setTypeCompte(compte.getTypeCompte());

        Compte new_compte = compteRepository.save(compte_updated);



        return compteMapper.deCompteAResponseCompte(new_compte);
    }

    @Override
    public void delete(String id) {
        compteRepository.deleteById(id);
    }

    @Override
    public ResponseCompteDTO findById(String id) {

        Compte compte = compteRepository.findById(id).get();
        return compteMapper.deCompteAResponseCompte(compte);
    }

    @Override
    public List<ResponseCompteDTO> findAll() {

        List<Compte> comptes = compteRepository.findAll();
        List<ResponseCompteDTO> responseCompteDTOS = new ArrayList<>();

        for (Compte index : comptes){
            responseCompteDTOS.add(compteMapper.deCompteAResponseCompte(index));
        }

        return responseCompteDTOS;
    }
}
