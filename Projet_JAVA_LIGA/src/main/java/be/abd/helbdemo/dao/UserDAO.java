package be.abd.helbdemo.dao;

import be.abd.helbdemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
