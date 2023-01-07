package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.Model.Joueur;
import be.abd.helbdemo.dao.JoueurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Configuration
public class JoueurService {
    @Autowired
    private JoueurDAO joueurDAO;


    //retourne tous les joueurs
    @GetMapping("joueurs")
    public List<Joueur> getJoueur()
    {

        return joueurDAO.findAll();

    }
    //Ajoute une joueur
    public Joueur addJoueur(@RequestBody Joueur joueur)
    {

        return joueurDAO.save(joueur);

    }


    public String deleteJoueur(@PathVariable long id)
    {
        Optional<Joueur> joueur = joueurDAO.findById(id);

        if(joueur.isPresent())
        {
            joueurDAO.delete(joueur.get());

            return "Joueur is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Joueur not found with the id "+id);
        }

    }

    public void updateJoueur(Long id, Joueur joueur) {
        Joueur existingJoueur = joueurDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entraineur not found with id " + id));

        existingJoueur.setFirstnameJoueur(joueur.getFirstnameJoueur());
        existingJoueur.setLastnameJoueur(joueur.getLastnameJoueur());
        existingJoueur.setPosteJoueur(joueur.getPosteJoueur());
        existingJoueur.setClubactuelleJoueur(joueur.getClubactuelleJoueur());
        existingJoueur.setAgeJoueur(joueur.getAgeJoueur());
        existingJoueur.setNbrbutsJoueur(joueur.getNbrbutsJoueur());

        joueurDAO.save(existingJoueur);
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


