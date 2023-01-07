package be.abd.helbdemo.dao;

import be.abd.helbdemo.Model.Entraineur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntraineurDAO extends JpaRepository<Entraineur, Long> {
}
