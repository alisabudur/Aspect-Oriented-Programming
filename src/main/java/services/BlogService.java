package services;

import models.BaseEntity;
import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.BlogRepository;
import repositories.interfaces.IBlogRepository;
import services.interfaces.IBlogService;

import java.util.List;

/**
 * Created by Alisa on 3/13/2017.
 */
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAll() throws Exception {
        try {
            return blogRepository.getAll();
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

    public IBlogRepository getBlogRepository() {
        return blogRepository;
    }

    public void setBlogRepository(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
}
