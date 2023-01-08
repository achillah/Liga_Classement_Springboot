package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Player;
import be.abd.helbdemo.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Configuration
public class PlayerService {
    @Autowired
    private PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO= playerDAO;
    }


    //retourne tous les joueurs
    @GetMapping("joueurs")
    public List<Player> getPlayer()
    {

        return playerDAO.findAll();

    }
    //Ajoute une joueur
    public Player addPlayer(@RequestBody Player player)
    {

        return playerDAO.save(player);

    }


    public String deletePlayer(@PathVariable long id)
    {
        Optional<Player> player = playerDAO.findById(id);

        if(player.isPresent())
        {
            playerDAO.delete(player.get());

            return "Player is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Player not found with the id "+id);
        }

    }

    public void updatePlayer(Long id, Player player) {
        Player existingPlayer = playerDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));

        existingPlayer.setFirstnameJoueur(player.getFirstnameJoueur());
        existingPlayer.setLastnameJoueur(player.getLastnameJoueur());
        existingPlayer.setPosteJoueur(player.getPosteJoueur());
        existingPlayer.setClubactuelleJoueur(player.getClubactuelleJoueur());
        existingPlayer.setAgeJoueur(player.getAgeJoueur());
        existingPlayer.setNbrbutsJoueur(player.getNbrbutsJoueur());

        playerDAO.save(existingPlayer);
    }

    /*public Joueur getTopScorer() {
        // Récupère tous les joueurs triés par nombre de buts décroissant
        List<Joueur> joueurs = joueurDAO.findAllByOrderBynbrbutsJoueurDesc();
        // Retourne le premier joueur de la liste (celui avec le plus de buts)
        return joueurs.get(0);
    }

    public Joueur getOldestPlayer() {
        // Récupère tous les joueurs triés par âge décroissant
        List<Joueur> joueurs = joueurDAO.findAllByOrderByageJoueurDesc();
        // Retourne le premier joueur de la liste (celui avec le plus d'années)
        return joueurs.get(0);
    }*/


    /*public void deleteJoueur(String id) {
        getJoueur().removeIf(t -> t.getId().equals(id));
    }*/

    /*public Joueur deleteJoueurByAge(@PathVariable Long Id) {

        return joueurDAO.removeByIdByJoueur(Id);
    }*/


   /* @GetMapping("joueurss/{Id}")
    public List<Joueur> findJoueur(@PathVariable Long Id)
    {
     return joueurDAO.findByIdByJoueur(Id);
    }*/

    /*@GetMapping("joueurss/{nbrbuts}")
    public List<Joueur> findJoueur(@PathVariable int nbrbuts)
    {
     return joueurDAO.findBynbrbuts(nbrbuts);
    }

    @GetMapping("joueurss/age/{age}")
    public List<Joueur> findJoueurs(@PathVariable int age)
    {
     return joueurDAO.findByagejoueur(age);
    }*/

    /*@GetMapping("joueurs/{lastnamejoueur}")
    public List<Joueur> findBenzema(@PathVariable String lastnamejoueur)
    {
     return joueurDAO.findByLastNameJoueur(lastnamejoueur);
    }*/
}


