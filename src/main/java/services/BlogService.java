package services;

import models.BaseEntity;
import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repositories.IBlogRepository;
import repositories.ICommentRepository;
import services.interfaces.IBlogService;

import java.util.List;

/**
 * Created by Alisa on 3/13/2017.
 */
@Repository
@Transactional(readOnly = true)
public class BlogService extends BaseEntity implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAll() {
        try {
            logger.info("started.");
            return blogRepository.findAll();
        } catch (Exception e) {
            logger.info("failed" + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended.");
        }
    }

    @Override
    public void save(Blog blog) {
        try {
            logger.info("started for blog " + blog.getName() + ".");
            blogRepository.save(blog);
        } catch (Exception e) {
            logger.info("failed for blog " + blog.getName() + " " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended for blog " + blog.getName() + ".");
        }
    }

    @Override
    public Blog findById(Integer id) {
        try {
            logger.info("started for blog " + id + ".");
            return blogRepository.findOne(id);
        } catch (Exception e) {
            logger.info("failed for blog " + id + " " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended for blog " + id + ".");
        }
    }
}
