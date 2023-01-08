package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Team;
import be.abd.helbdemo.dao.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class TeamService {
    @Autowired
    private TeamDAO teamDAO;

    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }


    public List<Team> getTeam()
    {
        return teamDAO.findAll();
    }


    public Team addTeam(@RequestBody Team team)
    {
        return teamDAO.save(team);
    }

    public String deleteTeam(@PathVariable long id)
    {
        Optional<Team> team = teamDAO.findById(id);

        if(team.isPresent())
        {
            teamDAO.delete(team.get());

            return "Team is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Team not found with the id "+id);
        }

    }

    public void updateTeam(Long id, Team team) {
        Team existingTeam = teamDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team not found with id " + id));

        existingTeam.setNomEquipe(team.getNomEquipe());
        existingTeam.setNbrTitres(team.getNbrTitres());
        existingTeam.setNbrPoints(team.getNbrPoints());
        existingTeam.setNbrButs(team.getNbrButs());

        teamDAO.save(existingTeam);
    }

    public Team getBestTeam() {
        // Récupère toutes les équipes triées par nombre de points décroissant
        List<Team> teams = teamDAO.findAllByOrderByNbrPointsDesc();
        // Retourne la première équipe de la liste (celle avec le plus de points)
        return teams.get(0);
    }


    public Team getWeakestTeam() {
        // Récupère toutes les équipes triées par nombre de points croissant
        List<Team> teams = teamDAO.findAllByOrderByNbrPointsAsc();
        // Retourne la première équipe de la liste (celle avec le moins de points)
        return teams.get(0);
    }

    public Team getStrongestTeam() {
        // Récupère toutes les équipes triées par nombre de buts décroissant
        List<Team> teams = teamDAO.findAllByOrderByNbrButsDesc();
        // Retourne la première équipe de la liste (celle avec le plus de buts)
        return teams.get(0);
    }
}


