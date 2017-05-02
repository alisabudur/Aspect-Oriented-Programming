package services;

import models.BaseEntity;
import models.Blog;
import repositories.BlogRepository;
import services.interfaces.IBlogService;

import java.util.List;

/**
 * Created by Alisa on 3/13/2017.
 */
public class BlogService extends BaseEntity implements IBlogService {

    private BlogRepository blogRepository;

    public BlogService() {
        this.blogRepository = new BlogRepository();
    }

    @Override
    public List<Blog> getAll() throws Exception {
        try {
            return blogRepository.findAll();
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public void save(Blog blog) throws Exception {
        try {
            blogRepository.save(blog);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public Blog findById(Integer id) throws Exception {
        try {
            return blogRepository.findOne(id);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }
}
