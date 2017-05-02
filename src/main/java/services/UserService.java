package services;

import models.BaseEntity;
import models.User;
import repositories.UserRepository;
import services.interfaces.IUserService;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
public class UserService extends BaseEntity implements IUserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

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
            return userRepository.findAll();
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
