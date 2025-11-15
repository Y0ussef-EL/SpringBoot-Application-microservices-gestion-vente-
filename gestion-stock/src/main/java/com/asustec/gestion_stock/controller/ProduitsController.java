package com.asustec.gestion_stock.controller;

import com.asustec.gestion_stock.model.Produits;
import com.asustec.gestion_stock.service.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/produits")
public class ProduitsController {

    @Autowired
    private ProduitsService produitsService;

    @GetMapping("/allproduits")
    public List<Produits> getAllProduits() {
        return produitsService.getAllProduits();
    }
}