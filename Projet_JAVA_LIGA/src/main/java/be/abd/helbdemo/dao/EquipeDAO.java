package be.abd.helbdemo.dao;

import be.abd.helbdemo.Model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeDAO extends JpaRepository<Equipe, Long> {
    List<Equipe> findAllByOrderByNbrPointsDesc();

    List<Equipe> findAllByOrderByNbrPointsAsc();

    List<Equipe> findAllByOrderByNbrButsDesc();
}
