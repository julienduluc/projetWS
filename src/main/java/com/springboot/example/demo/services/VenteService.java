package com.springboot.example.demo.services;

import java.util.Collection;

import com.springboot.example.demo.entities.Vente;

public interface VenteService {
    Vente getVenteById(int id);
    Collection<Vente> findAllVentes();
    Vente saveVente(Vente vente);
    Collection<Vente> getVentesByMarque(String marque);
    Collection<Vente> getVentesByAnnee(Integer annee);
    double getTotalCAByAnnee(Integer annee);
    Collection<Vente> rechercheVentes(String marque, String annee);
    
}