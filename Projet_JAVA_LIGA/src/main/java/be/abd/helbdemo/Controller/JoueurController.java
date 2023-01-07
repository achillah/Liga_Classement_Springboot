package be.abd.helbdemo.Controller;


import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.Model.Joueur;
import be.abd.helbdemo.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class JoueurController {

    @Autowired
    JoueurService joueurService;



    /*@GetMapping("joueur")
    public List<Joueur> getJoueur()
    {
        return joueurService.getJoueur();
    }*/

    @GetMapping("/joueurs")
    public String getJoueurs(Model model) {
        model.addAttribute("joueurs", joueurService.getJoueur());
        return "Joueur";
    }

    /*@GetMapping("/top-scorer/joueurs")
    public String getTopScorer(Model model) {
        Joueur topScorer = joueurService.getTopScorer();
        model.addAttribute("topScorer", topScorer);
        //return (topScorer.getFirstnameJoueur() + " " + topScorer.getLastnameJoueur());
        return "TopScorer";
    }

    @GetMapping("/oldest-player/joueurs")
    public String showOldestPlayer(Model model) {
        Joueur oldestPlayer = joueurService.getOldestPlayer();
        model.addAttribute("oldestPlayer", oldestPlayer);
        return "OldestPlayer";
    }*/



    /*@PostMapping("joueurs")
    public Joueur addJoueur(@RequestBody Joueur joueur)
    {

        return joueurService.addJoueur(joueur);

    }*/

    @PostMapping("/joueurs")
    public String addJoueurs(@ModelAttribute Joueur joueur, Model model) {
        model.addAttribute("joueurs", joueurService.addJoueur(joueur));
        return "Joueur";
    }

    /*@DeleteMapping("/joueur/{id}")
    public String deletePersonne(@PathVariable long id)
    {
        return joueurService.deletePersonne(id);

    }*/

    @DeleteMapping("/joueurs/{id}")
    public String deleteJoueur(@PathVariable Long id, Model model) {
        joueurService.deleteJoueur(id);
        model.addAttribute("joueurs", joueurService.getJoueur());
        return "Joueur";
    }

    @PutMapping("/joueurs/{id}")
    public String updateJoueurs(@PathVariable Long id, Model model, @RequestBody Joueur joueur) {
        joueurService.updateJoueur(id, joueur);
        model.addAttribute("joueurs", joueurService.getJoueur());
        return "Joueur";
    }


}
