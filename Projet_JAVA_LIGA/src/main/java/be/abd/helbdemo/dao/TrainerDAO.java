package be.abd.helbdemo.dao;

import be.abd.helbdemo.Model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerDAO extends JpaRepository<Trainer, Long> {
}
