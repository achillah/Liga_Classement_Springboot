package be.abd.helbdemo.dao;


import be.abd.helbdemo.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player, Long> {

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
