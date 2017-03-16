package repositories;

import models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alisa on 3/14/2017.
 */
public interface ICommentRepository extends JpaRepository<Comment, Integer>{
}
