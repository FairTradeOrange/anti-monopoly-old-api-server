package se2.project.antimonopoly.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se2.project.antimonopoly.entity.UserJPA;

import java.util.List;

@Repository
public interface UserJPADAO extends JpaRepository<UserJPA,Integer> {
    List<UserJPA> findByUserName(String userName);
}
