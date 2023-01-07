package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EquipeController {


    @Autowired
    EquipeService equipeService;



    //retourne tous les equipes
    /*@GetMapping("equipe")
    public List<Equipe> getEquipe()
    {

        return equipeService.getEquipe();

    }*/

    @GetMapping("/best-equipe")
    //@ResponseBody
    public String getBestEquipe() {
        Equipe bestEquipe = equipeService.getBestEquipe();
        return bestEquipe.getNomEquipe();

    }

    @GetMapping("/weakest-equipe")
    //@ResponseBody
    public String getWeakestEquipe() {
        Equipe weakestEquipe = equipeService.getWeakestEquipe();
        return weakestEquipe.getNomEquipe();
    }

    @GetMapping("/strongest-equipe")
    //@ResponseBody
    public String getStrongestEquipe(Model model) {
        Equipe strongestEquipe = equipeService.getStrongestEquipe();
        return strongestEquipe.getNomEquipe();
    }

    @GetMapping("/equipes")
    public String getEquipes(Model model) {
        model.addAttribute("equipes", equipeService.getEquipe());
        return "Equipe";
    }

    //Ajoute une equipe
    /*@PostMapping("equipes")
    public Equipe addEquipe(@RequestBody Equipe equipe)
    {
        return equipeService.addEquipe(equipe);
    }*/

    @PostMapping("/equipes")
    public String addEquipes(@ModelAttribute Equipe equipe, Model model) {
        model.addAttribute("equipes", equipeService.addEquipe(equipe));
        return "Equipe";
    }

    @DeleteMapping("/equipes/{id}")
    public String deleteEquipe(@PathVariable Long id, Model model) {
        equipeService.deleteEquipe(id);
        model.addAttribute("equipes", equipeService.getEquipe());
        return "Equipe";
    }

    @PutMapping("/equipes/{id}")
    public String updateEquipes(@PathVariable Long id, Model model, @RequestBody Equipe equipe) {
        equipeService.updateEquipe(id, equipe);
        model.addAttribute("equipes", equipeService.getEquipe());
        return "Equipe";
    }

}
