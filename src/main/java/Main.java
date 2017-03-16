import configurations.Configurations;
import models.BaseEntity;
import models.Blog;
import models.Comment;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.interfaces.IBlogService;
import services.interfaces.IUserService;

/**
 * Created by Alisa on 3/12/2017.
 */
public class Main extends BaseEntity{
    public static void main(String[] arg){
        ApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
        IUserService userService = context.getBean(IUserService.class);
        IBlogService blogService = context.getBean(IBlogService.class);

        User user1 = userService.findById(1);
        User user2 = userService.findById(2);

        Blog blog = blogService.findById(2);

        blog.addObserver(user1);
        blog.addObserver(user2);

        Comment comment = new Comment();
        comment.setText("CCCC");
        blog.addComment(comment);

        blogService.save(blog);
    }
}
