package com.vsu.by.app.common.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

public class PostgreSqlDbConfiguration implements DbConfiguration {
    @Bean
    @Override
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/ku");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setConnectionProperties(this.getConnectionProperties());
        return dataSource;
    }

    private Properties getConnectionProperties() {
        Properties properties = new Properties();
        properties.setProperty("spring.datasource.hikari.connectionTimeout", "1740");
        properties.setProperty("spring.jpa.properties.hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }
}
