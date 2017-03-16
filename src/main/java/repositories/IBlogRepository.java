package repositories;

import models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alisa on 3/13/2017.
 */
@Transactional(readOnly = true)
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
