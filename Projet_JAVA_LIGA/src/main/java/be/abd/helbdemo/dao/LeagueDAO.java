package be.abd.helbdemo.dao;


import be.abd.helbdemo.Model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueDAO extends JpaRepository<League, Long> {

}
