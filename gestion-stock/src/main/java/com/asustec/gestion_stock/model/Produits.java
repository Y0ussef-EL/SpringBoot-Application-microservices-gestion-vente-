package com.asustec.gestion_stock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produits_Stock")
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long CodeStock;
    private Long CodePdt;
    private int QtePdt;


    public Produits() {
    }

    public Produits(Long CodePdt, int QtePdt) {
        this.CodePdt = CodePdt;
        this.QtePdt = QtePdt;
    }

    public Long getCodeStock() {
        return CodeStock;
    }

    public void setCodeStock(Long codeStock) {
        CodeStock = codeStock;
    }

    public Long getCodePdt() {
        return CodePdt;
    }

    public void setCodePdt(Long codePdt) {
        CodePdt = codePdt;
    }

    public int getQtePdt() {
        return QtePdt;
    }

    public void setQtePdt(int qtePdt) {
        QtePdt = qtePdt;
    }




}
