package services;

import models.BaseEntity;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) throws Exception {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        try {
            return userRepository.getAll();
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public User findById(Integer id) throws Exception {
        try {
            return userRepository.findOne(id);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }
}
