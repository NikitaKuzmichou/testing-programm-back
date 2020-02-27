package com.vsu.by.app.common.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

public class H2DbConfiguration implements DbConfiguration {

    @Bean
    @Override
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setUrl("jdbc:h2:mem:/~/testing-program");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/testing-program");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setConnectionProperties(getConnectionProperties());
        return dataSource;
    }

    private Properties getConnectionProperties(){
        Properties props = new Properties();
        props.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.H2Dialect");
        props.setProperty("spring.h2.console.enabled", "true");
        props.setProperty("spring.h2.console.path", "/h2");
        props.setProperty("spring.h2.console.settings.web-allow-others", "false");
        return props;
    }
}
