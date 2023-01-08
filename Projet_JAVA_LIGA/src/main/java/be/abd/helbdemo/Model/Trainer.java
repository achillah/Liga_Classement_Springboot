package be.abd.helbdemo.Model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Trainer implements Serializable {

    @Column(name="lastnameentraineur")
    private String lastnameEntraineur;

    @Column(name="firstnameentraineur")
    private String firstnameEntraineur;

    @Column(name="clubactuelleentraineur")
    private String clubActuelleEntraineur;

    @Column(name="ageentraineur")
    private int ageEntraineur;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id")
    private Team equipe;


    public Trainer() {
    }

    public Trainer(Team equipe, String firstnameEntraineur, String lastnameEntraineur, String clubActuelleEntraineur, int ageEntraineur) {
        this.firstnameEntraineur = firstnameEntraineur;
        this.lastnameEntraineur = lastnameEntraineur;
        this.clubActuelleEntraineur = clubActuelleEntraineur;
        this.ageEntraineur = ageEntraineur;
        this.equipe = equipe;
    }

    public String getFirstnameEntraineur() {
        return firstnameEntraineur;
    }

    public void setFirstnameEntraineur(String firstnameEntraineur) {
        this.firstnameEntraineur = firstnameEntraineur;
    }

    public String getLastnameEntraineur() {
        return lastnameEntraineur;
    }

    public void setLastnameEntraineur(String lastnameEntraineur) {
        this.lastnameEntraineur = lastnameEntraineur;
    }

    public String getClubActuelleEntraineur() {
        return clubActuelleEntraineur;
    }

    public void setClubActuelleEntraineur(String clubActuelleEntraineur) {
        this.clubActuelleEntraineur = clubActuelleEntraineur;
    }

    public int getAgeEntraineur() {
        return ageEntraineur;
    }

    public void setAgeEntraineur(int ageEntraineur) {ageEntraineur = ageEntraineur;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
