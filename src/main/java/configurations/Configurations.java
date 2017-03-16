package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import services.BlogService;
import services.interfaces.IBlogService;
import services.interfaces.IUserService;
import services.UserService;

/**
 * Created by Alisa on 3/12/2017.
 */
@Configuration
@Import(JpaConfig.class)
public class Configurations {

    @Bean
    public IUserService userService() {
        return new UserService();
    }

    @Bean
    public IBlogService blogService() {
        return new BlogService();
    }
}
