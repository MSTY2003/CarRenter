package config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"dao","service"})
@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound = true)
public class SpringJDBCConfig {
    @Value("${jdbc.url}")
    private  String jdbcUrl;
    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        //数据库驱动
        myDataSource.setDriverClassName(jdbcDriverClassName);
        //相应驱动的jdbcUrl
        myDataSource.setUrl(jdbcUrl);
        myDataSource.setUsername(jdbcUsername);
        myDataSource.setPassword(jdbcPassword);

        return myDataSource;
    }

    @Bean(value = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
