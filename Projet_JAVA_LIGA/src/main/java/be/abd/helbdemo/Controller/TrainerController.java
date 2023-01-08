package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.Trainer;
import be.abd.helbdemo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;



    //retourne tous les entraineurs
    /*@GetMapping("entraineur")
    public List<Entraineur> getEntraineur()
    {

        return entraineurService.getEntraineur();

    }*/

    @GetMapping("/trainers")
    public String getTrainer(Model model) {
        model.addAttribute("trainers", trainerService.getTrainer());
        return "Trainer";
    }

    //Ajoute un entraineur
    /*@PostMapping("entraineurs")
    public Entraineur addEntraineur(@RequestBody Entraineur entraineur)
    {

        return entraineurService.addEntraineur(entraineur);

    }*/

    @PostMapping("/trainers")
    public String addTrainer(@ModelAttribute Trainer trainer, Model model) {
         model.addAttribute("trainers", trainerService.addTrainer(trainer));
         return "Trainer";
    }

    @DeleteMapping("/trainers/{id}")
    public String deleteTrainer(@PathVariable Long id, Model model) {
        trainerService.deleteTrainer(id);
        model.addAttribute("trainers", trainerService.getTrainer());
        return "Trainer";
    }

    @PutMapping("/trainers/{id}")
    public String updateTrainers(@PathVariable Long id, Model model, @RequestBody Trainer trainer) {
        trainerService.updateTrainer(id, trainer);
        model.addAttribute("trainers", trainerService.getTrainer());
        return "Trainer";
    }




}
