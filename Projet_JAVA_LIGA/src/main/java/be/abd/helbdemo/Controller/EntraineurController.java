package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.service.EntraineurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EntraineurController {

    @Autowired
    EntraineurService entraineurService;



    //retourne tous les entraineurs
    /*@GetMapping("entraineur")
    public List<Entraineur> getEntraineur()
    {

        return entraineurService.getEntraineur();

    }*/

    @GetMapping("/entraineurs")
    public String getEntraineurs(Model model) {
        model.addAttribute("entraineurs", entraineurService.getEntraineur());
        return "Entraineur";
    }

    //Ajoute un entraineur
    /*@PostMapping("entraineurs")
    public Entraineur addEntraineur(@RequestBody Entraineur entraineur)
    {

        return entraineurService.addEntraineur(entraineur);

    }*/

    @PostMapping("/entraineurs")
    public String addEntraineurs(@ModelAttribute Entraineur entraineur, Model model) {
         model.addAttribute("entraineurs", entraineurService.addEntraineur(entraineur));
         return "Entraineur";
    }

    @DeleteMapping("/entraineurs/{id}")
    public String deleteEntraineur(@PathVariable Long id, Model model) {
        entraineurService.deleteEntraineur(id);
        model.addAttribute("entraineurs", entraineurService.getEntraineur());
        return "Entraineur";
    }

    @PutMapping("/entraineurs/{id}")
    public String updateEntraineurs(@PathVariable Long id, Model model, @RequestBody Entraineur entraineur) {
        entraineurService.updateEntraineur(id, entraineur);
        model.addAttribute("entraineurs", entraineurService.getEntraineur());
        return "Entraineur";
    }




}
