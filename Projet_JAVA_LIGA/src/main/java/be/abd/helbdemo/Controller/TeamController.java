package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.Team;
import be.abd.helbdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TeamController {


    @Autowired
    TeamService teamService;



    //retourne tous les equipes
    /*@GetMapping("equipe")
    public List<Equipe> getEquipe()
    {

        return equipeService.getEquipe();

    }*/

    @GetMapping("/best-team")
    //@ResponseBody
    public String getBestTeam() {
        Team bestEquipe = teamService.getBestTeam();
        return bestEquipe.getNomEquipe();

    }

    @GetMapping("/weakest-team")
    //@ResponseBody
    public String getWeakestTeam() {
        Team weakestEquipe = teamService.getWeakestTeam();
        return weakestEquipe.getNomEquipe();
    }

    @GetMapping("/strongest-team")
    //@ResponseBody
    public String getStrongestTeam(Model model) {
        Team strongestEquipe = teamService.getStrongestTeam();
        return strongestEquipe.getNomEquipe();
    }

    @GetMapping("/teams")
    public String getTeams(Model model) {
        model.addAttribute("teams", teamService.getTeam());
        return "Team";
    }

    //Ajoute une equipe
    /*@PostMapping("equipes")
    public Equipe addEquipe(@RequestBody Equipe equipe)
    {
        return equipeService.addEquipe(equipe);
    }*/

    @PostMapping("/teams")
    public String addTeams(@ModelAttribute Team team, Model model) {
        model.addAttribute("teams", teamService.addTeam(team));
        return "Team";
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeams(@PathVariable Long id, Model model) {
        teamService.deleteTeam(id);
        model.addAttribute("teams", teamService.getTeam());
        return "Team";
    }

    @PutMapping("/teams/{id}")
    public String updateTeams(@PathVariable Long id, Model model, @RequestBody Team team) {
        teamService.updateTeam(id, team);
        model.addAttribute("teams", teamService.getTeam());
        return "Team";
    }

}
