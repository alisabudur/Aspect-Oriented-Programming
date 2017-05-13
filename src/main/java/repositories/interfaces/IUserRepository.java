package repositories.interfaces;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
@Transactional(readOnly = true)
public interface IUserRepository {

    List<User> getAll();
    void save(User user);
    User findOne(Integer id);
}
