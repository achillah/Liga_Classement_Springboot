package be.abd.helbdemo.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.dao.EntraineurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class EntraineurService {
    @Autowired
    private EntraineurDAO entraineurDAO;

    //retourne tous les entraineurs
    public List<Entraineur> getEntraineur()
    {
        return entraineurDAO.findAll();
    }

    //Ajoute un entraineur
    public Entraineur addEntraineur(@RequestBody Entraineur entraineur)
    {
        return entraineurDAO.save(entraineur);
    }

    public String deleteEntraineur(@PathVariable long id)
    {
        Optional<Entraineur> entraineur = entraineurDAO.findById(id);

        if(entraineur.isPresent())
        {
            entraineurDAO.delete(entraineur.get());

            return "Entraineur is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Joueur not found with the id "+id);
        }

    }

    public void updateEntraineur(Long id, Entraineur entraineur) {
        Entraineur existingEntraineur = entraineurDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entraineur not found with id " + id));

        existingEntraineur.setFirstnameEntraineur(entraineur.getFirstnameEntraineur());
        existingEntraineur.setLastnameEntraineur(entraineur.getLastnameEntraineur());
        existingEntraineur.setClubActuelleEntraineur(entraineur.getClubActuelleEntraineur());
        existingEntraineur.setAgeEntraineur(entraineur.getAgeEntraineur());

        entraineurDAO.save(existingEntraineur);
    }


}


