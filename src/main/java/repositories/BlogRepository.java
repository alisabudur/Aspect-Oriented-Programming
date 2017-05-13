package repositories;

import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repositories.interfaces.IBlogRepository;

import java.util.List;

/**
 * Created by Alisa on 5/13/2017.
 */

@Repository
public class BlogRepository implements IBlogRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Blog> getAll() {
        String sql = "select * from Blogs";
        return jdbcTemplate.query(sql, (rs, i) -> new Blog(rs.getInt("Id"), rs.getString("Name")));
    }

    @Override
    public void save(Blog blog) {
        String sql = "insert into Blogs (Name) values (?)";
        jdbcTemplate.update(sql, blog.getName());
    }

    @Override
    public Blog findOne(Integer id) {
        String sql = "select * from Users where Id=?";
        Blog user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Blog.class), id);
        return user;
    }
}
