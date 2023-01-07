package be.abd.helbdemo.service;

import be.abd.helbdemo.Model.Entraineur;
import be.abd.helbdemo.Model.Equipe;
import be.abd.helbdemo.Model.Joueur;
import be.abd.helbdemo.dao.EquipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class EquipeService {
    @Autowired
    private EquipeDAO equipeDAO;


    public List<Equipe> getEquipe()
    {
        return equipeDAO.findAll();
    }


    public Equipe addEquipe(@RequestBody Equipe equipe)
    {
        return equipeDAO.save(equipe);
    }

    public String deleteEquipe(@PathVariable long id)
    {
        Optional<Equipe> equipe = equipeDAO.findById(id);

        if(equipe.isPresent())
        {
            equipeDAO.delete(equipe.get());

            return "Equipe is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Joueur not found with the id "+id);
        }

    }

    public void updateEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = equipeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entraineur not found with id " + id));

        existingEquipe.setNomEquipe(equipe.getNomEquipe());
        existingEquipe.setNbrTitres(equipe.getNbrTitres());
        existingEquipe.setNbrPoints(equipe.getNbrPoints());
        existingEquipe.setNbrButs(equipe.getNbrButs());

        equipeDAO.save(existingEquipe);
    }

    public Equipe getBestEquipe() {
        // Récupère toutes les équipes triées par nombre de points décroissant
        List<Equipe> equipes = equipeDAO.findAllByOrderByNbrPointsDesc();
        // Retourne la première équipe de la liste (celle avec le plus de points)
        return equipes.get(0);
    }


    public Equipe getWeakestEquipe() {
        // Récupère toutes les équipes triées par nombre de points croissant
        List<Equipe> equipes = equipeDAO.findAllByOrderByNbrPointsAsc();
        // Retourne la première équipe de la liste (celle avec le moins de points)
        return equipes.get(0);
    }

    public Equipe getStrongestEquipe() {
        // Récupère toutes les équipes triées par nombre de buts décroissant
        List<Equipe> equipes = equipeDAO.findAllByOrderByNbrButsDesc();
        // Retourne la première équipe de la liste (celle avec le plus de buts)
        return equipes.get(0);
    }
}


