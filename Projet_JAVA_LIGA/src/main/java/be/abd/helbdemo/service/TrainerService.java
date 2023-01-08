package be.abd.helbdemo.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import be.abd.helbdemo.Model.Trainer;
import be.abd.helbdemo.dao.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Configuration
public class TrainerService {
    @Autowired
    private TrainerDAO trainerDAO;

    //retourne tous les entraineurs
    public List<Trainer> getTrainer()
    {
        return trainerDAO.findAll();
    }

    //Ajoute un entraineur
    public Trainer addTrainer(@RequestBody Trainer trainer)
    {
        return trainerDAO.save(trainer);
    }

    public String deleteTrainer(@PathVariable long id)
    {
        Optional<Trainer> trainer = trainerDAO.findById(id);

        if(trainer.isPresent())
        {
            trainerDAO.delete(trainer.get());

            return "Trainer is deleted with id "+id;
        }
        else
        {
            throw new RuntimeException("Trainer not found with the id "+id);
        }

    }

    public void updateTrainer(Long id, Trainer trainer) {
        Trainer existingTrainer = trainerDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trainer not found with id " + id));

        existingTrainer.setFirstnameEntraineur(trainer.getFirstnameEntraineur());
        existingTrainer.setLastnameEntraineur(trainer.getLastnameEntraineur());
        existingTrainer.setClubActuelleEntraineur(trainer.getClubActuelleEntraineur());
        existingTrainer.setAgeEntraineur(trainer.getAgeEntraineur());

        trainerDAO.save(existingTrainer);
    }


}


