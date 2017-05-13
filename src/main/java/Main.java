import configurations.Configurations;
import models.BaseEntity;
import models.Blog;
import models.Comment;
import models.User;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.interfaces.IBlogService;
import services.interfaces.IUserService;

/**
 * Created by Alisa on 3/12/2017.
 */
public class Main extends BaseEntity{
    public static void main(String[] arg){
        BasicConfigurator.configure();
        ApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
        IUserService userService = context.getBean(IUserService.class);
        IBlogService blogService = context.getBean(IBlogService.class);

        User user1 = null;
        User user2 = null;
        Blog blog = null;
        try {
            user1 = userService.findById(1);
            user2 = userService.findById(2);
            blog = blogService.findById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        blog.addUser(user1);
        blog.addUser(user2);

        Comment comment = new Comment();
        comment.setText("CCCC");
        blog.addComment(comment);

        try {
            blogService.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
