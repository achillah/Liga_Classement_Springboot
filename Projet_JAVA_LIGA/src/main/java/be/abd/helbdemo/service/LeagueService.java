package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.League;
import be.abd.helbdemo.dao.LeagueDAO;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class LeagueService {

    private LeagueDAO leagueDAO;

    public LeagueService(LeagueDAO leagueDAO) {
        this.leagueDAO = leagueDAO;
    }


    //retourne tous la ligue
    public List<League> getLeague()
    {
        return leagueDAO.findAll();
    }

    public League addLeague(@RequestBody League league)
    {
        return leagueDAO.save(league);
    }

    public String deleteLeague(@PathVariable long id)
    {
        Optional<League> league = leagueDAO.findById(id);

        if(league.isPresent())
        {
            leagueDAO.delete(league.get());

            return "League is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("League not found with the id "+id);
        }

    }

    public void updateLeague(Long id, League league) {
        League existingLeague = leagueDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("League not found with id " + id));

        existingLeague.setNomLigue(league.getNomLigue());
        existingLeague.setNombreEquipe(league.getNombreEquipe());
        existingLeague.setNumJournee(league.getNumJournee());

        leagueDAO.save(existingLeague);
    }

}


