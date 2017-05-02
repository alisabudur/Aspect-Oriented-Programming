package services.interfaces;

import models.Blog;

import java.util.List;

/**
 * Created by Alisa on 3/13/2017.
 */
public interface IBlogService {
    List<Blog> getAll() throws Exception;
    void save(Blog blog) throws Exception;
    Blog findById(Integer id) throws Exception;
}
