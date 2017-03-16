package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
@Transactional(readOnly = true)
public interface IUserRepository extends JpaRepository<User, Integer> {
    List<User> findById(Integer id);

    @Query(value = "SELECT * FROM Users", nativeQuery = true)
    List<User> getAll();
}
