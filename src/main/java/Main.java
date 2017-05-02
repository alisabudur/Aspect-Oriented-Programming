import models.BaseEntity;
import models.Blog;
import models.Comment;
import models.User;
import org.apache.log4j.BasicConfigurator;
import services.BlogService;
import services.UserService;

/**
 * Created by Alisa on 3/12/2017.
 */
public class Main extends BaseEntity{
    public static void main(String[] arg){
        BasicConfigurator.configure();
        UserService userService = new UserService();
        BlogService blogService = new BlogService();

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


        blog.addObserver(user1);
        blog.addObserver(user2);

        Comment comment = new Comment();
        comment.setText("CCCCBBBBB");
        blog.addComment(comment);

        try {
            blogService.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
