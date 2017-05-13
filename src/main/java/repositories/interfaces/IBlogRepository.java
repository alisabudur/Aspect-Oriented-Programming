package repositories.interfaces;

import models.Blog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alisa on 3/13/2017.
 */
@Transactional(readOnly = true)
public interface IBlogRepository {
    List<Blog> getAll();
    void save(Blog blog);
    Blog findOne(Integer id);
}
