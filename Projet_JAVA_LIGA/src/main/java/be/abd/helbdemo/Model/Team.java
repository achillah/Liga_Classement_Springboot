package be.abd.helbdemo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Team implements Serializable {

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
    private League ligue;

    @OneToOne(mappedBy = "equipe")
    private Trainer entraineur;

    @OneToMany(mappedBy = "equipe")
    private List<Player> joueurs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public Team() {
    }

    public Team(String nomEquipe, int nbrButs, int nbrPoints, int nbrTitres, String logo, League ligue, int id) {
        this.nomEquipe = nomEquipe;
        this.nbrButs = nbrButs;
        this.nbrPoints = nbrPoints;
        this.nbrTitres = nbrTitres;
        Id = id;
        this.logo= logo;
        this.ligue = ligue;
    }

    public Team(String nomEquipe, int nbrButs, int nbrPoints, int nbrTitres, String logo, int i, int id) {
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public League getLigue() {
        return ligue;
    }

    public void setLigue(League ligue) {
        this.ligue = ligue;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
