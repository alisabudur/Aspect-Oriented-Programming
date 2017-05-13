package aspects;

import models.Blog;
import models.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alisa on 5/13/2017.
 */
public aspect CashingAspect {
    private Logger logger = Logger.getLogger("Caching");
    private Map<Integer, User> cacheUser;
    private Map<Integer, Blog> cacheBlog;

    public CashingAspect() {
        cacheUser = new HashMap<>();
        cacheBlog = new HashMap<>();
    }

    pointcut cachedOperationUser(Integer id):execution(public User repositories..*Repository+.findOne(*))&&args(id);
    pointcut cachedOperationBlog(Integer id):execution(public Blog repositories..*Repository+.findOne(*))&&args(id);

    User around(Integer id) : cachedOperationUser(id){
        User user = cacheUser.get(id);
        if (user == null) {
            logger.info("Caching user with id = " + id);
            user = proceed(id);
            cacheUser.put(id, user);
        }
        return user;
    }

    Blog around(Integer id) : cachedOperationBlog(id){
        Blog blog = cacheBlog.get(id);
        if (blog == null) {
            logger.info("Caching blog with id = " + id);
            blog = proceed(id);
            cacheBlog.put(id, blog);
        }
        return blog;
    }
}
