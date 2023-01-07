package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.Model.Joueur;
import be.abd.helbdemo.Model.Ligue;
import be.abd.helbdemo.dao.LigueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class LigueService {

    private LigueDAO ligueDAO;

    public LigueService(LigueDAO ligueDAO) {
        this.ligueDAO = ligueDAO;
    }


    //retourne tous la ligue
    public List<Ligue> getLigue()
    {
        return ligueDAO.findAll();
    }

    public Ligue addLigue(@RequestBody Ligue ligue)
    {
        return ligueDAO.save(ligue);
    }

    public String deleteLigue(@PathVariable long id)
    {
        Optional<Ligue> ligue = ligueDAO.findById(id);

        if(ligue.isPresent())
        {
            ligueDAO.delete(ligue.get());

            return "Ligue is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Joueur not found with the id "+id);
        }

    }

    public void updateLigue(Long id, Ligue ligue) {
        Ligue existingLigue = ligueDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entraineur not found with id " + id));

        existingLigue.setNomLigue(ligue.getNomLigue());
        existingLigue.setNombreEquipe(ligue.getNombreEquipe());
        existingLigue.setNumJournee(ligue.getNumJournee());

        ligueDAO.save(existingLigue);
    }

}


