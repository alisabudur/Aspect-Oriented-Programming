package services;

import models.BaseEntity;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repositories.IUserRepository;
import services.interfaces.IUserService;

import java.util.List;

/**
 * Created by Alisa on 3/12/2017.
 */
@Repository
@Transactional(readOnly = true)
public class UserService extends BaseEntity implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    @Transactional
    public void save(User user) {
        try {
            logger.info("started for user" + user.getName() + ".");
            userRepository.save(user);
        } catch (Exception e) {
            logger.info("failed for user" + user.getName() + " " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended for user" + user.getName() + ".");
        }
    }

    @Override
    public List<User> getAll() {
        try {
            logger.info("started.");
            return userRepository.getAll();
        } catch (Exception e) {
            logger.info("failed  " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended.");
        }
    }

    @Override
    public User findById(Integer id) {
        try {
            logger.info("started for id " + id + ".");
            return userRepository.findOne(id);
        } catch (Exception e) {
            logger.info("failed for id " + id + " " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended for id " + id + ".");
        }
    }
}
