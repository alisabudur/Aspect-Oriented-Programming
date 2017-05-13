package configurations;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Alisa on 5/13/2017.
 */
@Configuration
public class JdbcConfig {
    @Bean
    public DataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("localhost\\SQLEXPRESS");
        dataSource.setPortNumber(1433);
        dataSource.setDatabaseName("Blogs");
        dataSource.setUser("alisa");
        dataSource.setPassword("alisa12345");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
