package be.abd.helbdemo.dao;

import be.abd.helbdemo.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamDAO extends JpaRepository<Team, Long> {
    List<Team> findAllByOrderByNbrPointsDesc();

    List<Team> findAllByOrderByNbrPointsAsc();

    List<Team> findAllByOrderByNbrButsDesc();
}
