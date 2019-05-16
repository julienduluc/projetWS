package com.springboot.example.demo.services;

import java.util.List;

import com.springboot.example.demo.entities.Vente;

public interface VenteService {
    Vente getVenteById(int id);
    List<Vente> findAllVentes();
    Vente saveVente(Vente vente);
    
}