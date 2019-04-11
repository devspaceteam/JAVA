/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.MProduit;

import java.util.Date;

/**
 *
 * @author mahjoub
 */
public class Produit {
    private int id;
    private int user_id;
    private String nom;
    private String description;
    private Double prix;
    private int quantite;
    private String devis_name1;
    private String devis_name2;
    private String devis_name3;
    private Date updated_at;
    private int categorie_id;

    public Produit(int id, int user_id, String nom, String description, Double prix, int quantite, String devis_name1, String devis_name2, String devis_name3, Date updated_at, int categorie_id) {
        this.id = id;
        this.user_id = user_id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.devis_name1 = devis_name1;
        this.devis_name2 = devis_name2;
        this.devis_name3 = devis_name3;
        this.updated_at = updated_at;
        this.categorie_id = categorie_id;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDevis_name1() {
        return devis_name1;
    }

    public void setDevis_name1(String devis_name1) {
        this.devis_name1 = devis_name1;
    }

    public String getDevis_name2() {
        return devis_name2;
    }

    public void setDevis_name2(String devis_name2) {
        this.devis_name2 = devis_name2;
    }

    public String getDevis_name3() {
        return devis_name3;
    }

    public void setDevis_name3(String devis_name3) {
        this.devis_name3 = devis_name3;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }
    
}
