package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.League;
import be.abd.helbdemo.dao.LeagueDAO;
import be.abd.helbdemo.service.LeagueService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LeagueController {

    @Autowired
    LeagueService leagueService;


    @GetMapping("/leagues")
    public String getLeague(Model model) {
        model.addAttribute("leagues", leagueService.getLeague());
        return "League";
    }

    @PostMapping("/leagues")
    public String addLeague(@ModelAttribute League league, Model model) {
        model.addAttribute("leagues", leagueService.addLeague(league));
        return "League";
    }

    @DeleteMapping("/leagues/{id}")
    public String deleteLeague(@PathVariable Long id, Model model) {
        leagueService.deleteLeague(id);
        model.addAttribute("leagues", leagueService.getLeague());
        return "League";
    }

    @PutMapping("/leagues/{id}")
    public String updateLeague(@PathVariable Long id, Model model, @RequestBody League league) {
        leagueService.updateLeague(id, league);
        model.addAttribute("leagues", leagueService.getLeague());
        return "League";
    }


    @GetMapping("/")
    public String index()
    {
        return "Home";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}
