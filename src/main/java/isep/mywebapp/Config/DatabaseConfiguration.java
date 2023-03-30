package isep.mywebapp.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @Scope("singleton")
    public Connection connection() throws SQLException {

        String url = "jdbc:oracle:thin:@localhost:49161:xe";
        String user = "system";
        String pass = "oracle";

        return DriverManager.getConnection(url, user, pass);
    }


}


