package be.abd.helbdemo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Joueur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="firstnamejoueur")
    private String firstnameJoueur ;
    @Column(name="lastnamejoueur")
    private String lastnameJoueur;
    @Column(name="postejoueur")
    private String posteJoueur;
    @Column(name="clubactuellejoueur")
    private String clubactuelleJoueur;
    @Column(name="nbrbutsjoueur")
    private int nbrbutsJoueur;
    @Column(name="agejoueur")
    private int ageJoueur;

    @ManyToOne
    @JoinColumn(name = "equipe_id", nullable = false)
    private Equipe equipe;


    public Joueur() {
    }

    public Joueur(Long id, String firstnameJoueur, String lastnameJoueur, String posteJoueur, String clubactuelleJoueur, int nbrbutsJoueur, int ageJoueur, Equipe equipe) {
        Id = id;
        this.firstnameJoueur = firstnameJoueur;
        this.lastnameJoueur = lastnameJoueur;
        this.posteJoueur = posteJoueur;
        this.clubactuelleJoueur = clubactuelleJoueur;
        this.nbrbutsJoueur = nbrbutsJoueur;
        this.ageJoueur = ageJoueur;
        this.equipe = equipe;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstnameJoueur() {
        return firstnameJoueur;
    }

    public void setFirstnameJoueur(String firstnameJoueur) {
        this.firstnameJoueur = firstnameJoueur;
    }

    public String getLastnameJoueur() {
        return lastnameJoueur;
    }

    public void setLastnameJoueur(String lastnameJoueur) {
        this.lastnameJoueur = lastnameJoueur;
    }

    public String getPosteJoueur() {
        return posteJoueur;
    }

    public void setPosteJoueur(String posteJoueur) {
        this.posteJoueur = posteJoueur;
    }

    public String getClubactuelleJoueur() {
        return clubactuelleJoueur;
    }

    public void setClubactuelleJoueur(String clubactuelleJoueur) {
        this.clubactuelleJoueur = clubactuelleJoueur;
    }

    public int getNbrbutsJoueur() {
        return nbrbutsJoueur;
    }

    public void setNbrbutsJoueur(int nbrbutsJoueur) {
        this.nbrbutsJoueur = nbrbutsJoueur;
    }

    public int getAgeJoueur() {
        return ageJoueur;
    }

    public void setAgeJoueur(int ageJoueur) {
        this.ageJoueur = ageJoueur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
