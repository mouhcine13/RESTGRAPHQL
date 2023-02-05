package com.example.api.Entity;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;

@Projection(types = Compte.class, name = "P1")
public interface CompteProjection {

    public Date getCreation_compte();
    public Double getSolde_compte();

}
