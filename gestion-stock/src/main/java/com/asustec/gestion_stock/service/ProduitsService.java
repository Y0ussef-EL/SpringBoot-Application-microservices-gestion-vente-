package com.asustec.gestion_stock.service;

import com.asustec.gestion_stock.model.Produits;
import com.asustec.gestion_stock.repository.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitsService {
    @Autowired
    ProduitsRepository produitsRepository;

    public List<Produits> getAllProduits() {
        return produitsRepository.findAll();
    }

    public String removeSoldProduit(Long codePdt, Integer qtePdtSld) {
        Produits soldPdt = produitsRepository.findByCodePdt(codePdt).orElseThrow(()->new RuntimeException("produit non disponible en stock"));
        if(qtePdtSld>soldPdt.getQtePdt()){
            throw new RuntimeException("La Quantité demandée dépasse celle disponible en stock");
        }
        else {
        soldPdt.setQtePdt(soldPdt.getQtePdt() - qtePdtSld);
        produitsRepository.save(soldPdt);
        }
        return "success";
    }
}
