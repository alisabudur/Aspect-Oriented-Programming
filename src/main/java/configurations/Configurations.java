package configurations;

import aspects.CashingAspect;
import aspects.PerformanceMonitoringAspect;
import aspects.security.AuthenticationSupport;
import aspects.security.IAuthenticationSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import repositories.BlogRepository;
import repositories.UserRepository;
import repositories.interfaces.IBlogRepository;
import repositories.interfaces.IUserRepository;
import services.BlogService;
import services.LoginService;
import services.interfaces.IBlogService;
import services.interfaces.ILoginService;
import services.interfaces.IUserService;
import services.UserService;

/**
 * Created by Alisa on 3/12/2017.
 */
@Configuration
@Import({JdbcConfig.class, SecurityConfig.class})
@EnableAspectJAutoProxy
public class Configurations {

    @Bean
    public IUserService userService() {
        return new UserService();
    }

    @Bean
    public IBlogService blogService() {
        return new BlogService();
    }

    @Bean
    public IBlogRepository blogRepository() {
        return new BlogRepository();
    }

    @Bean
    public IUserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public ILoginService loginService() {
        return new LoginService();
    }

    @Bean
    public IAuthenticationSupport authenticationSupport() {
        return new AuthenticationSupport();
    }

    @Bean
    public CashingAspect cashingAspect() {
        return new CashingAspect();
    }

    @Bean
    public PerformanceMonitoringAspect performanceMonitoringAspect() {
        return new PerformanceMonitoringAspect();
    }
}
