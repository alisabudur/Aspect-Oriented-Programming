package services.interfaces;

import models.User;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
public interface IUserService {
    void save(User user);
    List<User> getAll();
    User findById(Integer id);
}
