package repositories;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repositories.interfaces.IUserRepository;

import java.util.List;

/**
 * Created by Alisa on 5/13/2017.
 */
@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {
        String sql = "select * from Users";
        return jdbcTemplate.query(sql, (rs, i) -> new User(rs.getInt("Id"), rs.getString("Name")));
    }

    @Override
    public void save(User user) {
        String sql = "insert into Users (Name) values (?)";
        jdbcTemplate.update(sql, user.getName());
    }

    @Override
    public User findOne(Integer id) {
        String sql = "select * from Users where Id=?";
        User user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
        return user;
    }
}
