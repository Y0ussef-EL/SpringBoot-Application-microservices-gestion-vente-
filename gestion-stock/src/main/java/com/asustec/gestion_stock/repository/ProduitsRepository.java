package com.asustec.gestion_stock.repository;

import com.asustec.gestion_stock.model.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitsRepository extends JpaRepository<Produits, Long> {
    public Optional<Produits> findByCodePdt(Long codePdt);

}
