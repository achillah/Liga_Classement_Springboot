package be.abd.helbdemo.Controller;


import be.abd.helbdemo.Model.Player;
import be.abd.helbdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;



    /*@GetMapping("joueur")
    public List<Joueur> getJoueur()
    {
        return joueurService.getJoueur();
    }*/

    @GetMapping("/players")
    public String getPlayer(Model model) {
        model.addAttribute("players", playerService.getPlayer());
        return "Player";
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

    @PostMapping("/players")
    public String addPlayer(@ModelAttribute Player player, Model model) {
        model.addAttribute("players", playerService.addPlayer(player));
        return "Player";
    }

    /*@DeleteMapping("/joueur/{id}")
    public String deletePersonne(@PathVariable long id)
    {
        return joueurService.deletePersonne(id);

    }*/

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable Long id, Model model) {
        playerService.deletePlayer(id);
        model.addAttribute("players", playerService.getPlayer());
        return "Player";
    }

    @PutMapping("/players/{id}")
    public String updatePlayer(@PathVariable Long id, Model model, @RequestBody Player player) {
        playerService.updatePlayer(id, player);
        model.addAttribute("players", playerService.getPlayer());
        return "Player";
    }


}
