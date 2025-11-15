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
}
