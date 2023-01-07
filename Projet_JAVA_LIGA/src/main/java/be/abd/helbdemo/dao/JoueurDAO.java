package be.abd.helbdemo.dao;


import be.abd.helbdemo.Model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JoueurDAO extends JpaRepository<Joueur, Long> {

    //List<Joueur> findAllByOrderBynbrbutsJoueurDesc();

    //List<Joueur> findAllByOrderByageJoueurDesc();

    //List<Joueur> findByfirstnamejoueur(String firstname);
    //List<Joueur> findBylastnamejoueur(String lastname);
    //List<Joueur> findByposte(String poste);
    //List<Joueur> findByclubactuellejoueur(String clubactuellejoueur);
    //List<Joueur> findBynbrbuts(int nbrbuts);
    //List<Joueur> findByagejoueur(int age);

    //Joueur removeByIdByJoueur(Long Id);

    













}
