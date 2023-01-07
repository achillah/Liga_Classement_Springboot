package be.abd.helbdemo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ligue implements Serializable {

    @Column(name="nomligue")
    private String nomLigue;
    @Column(name="nombreequipe")
    private int nombreEquipe;

    @Column(name="numjournee")
    private int numJournee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Ligue() {
    }

    public Ligue(String nomLigue, int nombreEquipe, int numJournee) {
        this.nomLigue = nomLigue;
        this.nombreEquipe = nombreEquipe;
        this.numJournee = numJournee;
    }

    public String getNomLigue() {
        return nomLigue;
    }

    public void setNomLigue(String nomLigue) {
        this.nomLigue = nomLigue;
    }

    public int getNombreEquipe() {
        return nombreEquipe;
    }

    public void setNombreEquipe(int nombreEquipe) {
        this.nombreEquipe = nombreEquipe;
    }

    public int getNumJournee() {
        return numJournee;
    }

    public void setNumJournee(int numJournee) {
        this.numJournee = numJournee;
    }
}
