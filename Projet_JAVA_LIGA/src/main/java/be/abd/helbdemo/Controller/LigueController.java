package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.Model.Ligue;
import be.abd.helbdemo.dao.LigueDAO;
import be.abd.helbdemo.service.LigueService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LigueController {

    @Autowired
    LigueService ligueService;

    @Autowired
    private LigueDAO ligueDAO;

    /*@GetMapping("ligue")
    public List<Ligue> getLigue()
    {

        return ;

    }*/

    @GetMapping("/ligues")
    public String getLigues(Model model) {
        model.addAttribute("ligues", ligueService.getLigue());
        return "Ligue";
    }

    @PostMapping("/ligues")
    public String addLigue(@ModelAttribute Ligue ligue, Model model) {
        model.addAttribute("ligues", ligueService.addLigue(ligue));
        return "Ligue";
    }

    @DeleteMapping("/ligues/{id}")
    public String deleteLigue(@PathVariable Long id, Model model) {
        ligueService.deleteLigue(id);
        model.addAttribute("ligues", ligueService.getLigue());
        return "Ligue";
    }

    @PutMapping("/ligues/{id}")
    public String updateLigues(@PathVariable Long id, Model model, @RequestBody Ligue ligue) {
        ligueService.updateLigue(id, ligue);
        model.addAttribute("ligues", ligueService.getLigue());
        return "Ligue";
    }


    @GetMapping("/")
    public String index()
    {
        return "Home";
    }

    @GetMapping("/logins")public String login(){    return "Login";}








}
