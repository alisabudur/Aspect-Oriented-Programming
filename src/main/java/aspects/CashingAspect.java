package aspects;

import models.Blog;
import models.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alisa on 5/13/2017.
 */
@Aspect
public class CashingAspect {
//    private Logger logger = Logger.getLogger("Caching");
//    private Map<Integer, User> cacheUser;
//    private Map<Integer, Blog> cacheBlog;
//
//    public CashingAspect() {
//        cacheUser = new HashMap<>();
//        cacheBlog = new HashMap<>();
//    }
//
//    @Pointcut("execution(public models.User repositories..*Repository+.findOne(*))&&args(id)")
//    public void cachedOperationUser(Integer id){}
//
//    @Pointcut("execution(public models.Blog repositories..*Repository+.findOne(*))&&args(id)")
//    public void cachedOperationBlog(Integer id){}
//
//    @Around("cachedOperationUser(id)")
//    public User getUser(Integer id, ProceedingJoinPoint jp) throws Throwable {
//        User user = cacheUser.get(id);
//        if (user == null) {
//            logger.info("Caching user with id = " + id);
//            user = (User)jp.proceed();
//            cacheUser.put(id, user);
//        }
//        return user;
//    }
//
//    @Around("cachedOperationBlog(id)")
//    public Blog getBlog(Integer id, ProceedingJoinPoint jp) throws Throwable {
//        Blog blog = cacheBlog.get(id);
//        if (blog == null) {
//            logger.info("Caching blog with id = " + id);
//            blog = (Blog)jp.proceed();
//            cacheBlog.put(id, blog);
//        }
//        return blog;
//    }
}
