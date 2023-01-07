package be.abd.helbdemo.dao;


import be.abd.helbdemo.Model.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigueDAO extends JpaRepository<Ligue, Long> {

}
