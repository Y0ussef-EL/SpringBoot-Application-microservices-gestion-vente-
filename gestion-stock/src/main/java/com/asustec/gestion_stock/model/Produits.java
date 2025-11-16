package com.asustec.gestion_stock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produits_Stock")
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long codeStock;
    @Column(unique = true, nullable = false)
    private Long codePdt;
    private int qtePdt;


    public Produits() {
    }

    public Produits(Long CodePdt, int qtePdt) {
        this.codePdt = CodePdt;
        this.qtePdt = qtePdt;
    }

    public Long getCodeStock() {
        return codeStock;
    }

    public void setCodeStock(Long codeStock) {
        this.codeStock = codeStock;
    }

    public Long getCodePdt() {
        return codePdt;
    }

    public void setCodePdt(Long codePdt) {
        this.codePdt = codePdt;
    }

    public int getQtePdt() {
        return qtePdt;
    }

    public void setQtePdt(int qtePdt) {
        this.qtePdt = qtePdt;
    }




}
