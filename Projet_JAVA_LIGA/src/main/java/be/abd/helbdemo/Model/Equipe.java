package be.abd.helbdemo.Model;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipe implements Serializable {

    @Column(name="nomequipe")
    private String nomEquipe;
    @Column(name="nbrtitres")
    private int nbrTitres;
    @Column(name="nbrpoints")
    private int nbrPoints;
    @Column(name="nbrbuts")
    private int nbrButs;

    private String logo;


    @ManyToOne
    @JoinColumn(name = "ligue_id", nullable = false)
    private Ligue ligue;

    @OneToOne(mappedBy = "equipe")
    private Entraineur entraineur;

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Equipe() {
    }

    public Equipe(String nomEquipe, int nbrButs, int nbrPoints, int nbrTitres, String logo, Ligue ligue, Long id) {
        this.nomEquipe = nomEquipe;
        this.nbrButs = nbrButs;
        this.nbrPoints = nbrPoints;
        this.nbrTitres = nbrTitres;
        Id = id;
        this.logo= logo;
        this.ligue = ligue;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getNbrButs() {
        return nbrButs;
    }

    public void setNbrButs(int nbrButs) {
        this.nbrButs = nbrButs;
    }

    public int getNbrPoints() {
        return nbrPoints;
    }

    public void setNbrPoints(int nbrPoints) {
        this.nbrPoints = nbrPoints;
    }

    public int getNbrTitres() {
        return nbrTitres;
    }

    public void setNbrTitres(int nbrTitres) {
        this.nbrTitres = nbrTitres;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
