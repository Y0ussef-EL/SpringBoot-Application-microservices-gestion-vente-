package com.asustec.gestion_stock.controller;

import com.asustec.gestion_stock.model.Produits;
import com.asustec.gestion_stock.service.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buyproduit/{codePdt}")
    public ResponseEntity<String> buyproduit(@PathVariable Long codePdt, @RequestParam Integer qteCmd) {
        try {
            String result = produitsService.removeSoldProduit(codePdt, qteCmd);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("produit non disponible en stock")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            if (e.getMessage().equals("La Quantité demandée dépasse celle disponible en stock")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
            return ResponseEntity.internalServerError().body("Erreur interne du serveur");
        }
    }
}