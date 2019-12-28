package com.vsu.by.app.common.config.root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DevelopmentConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DriverManagerDataSource dataSource) {
        LocalContainerEntityManagerFactoryBean
                entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(
                "com.vsu.by.app.people.groups",
                "com.vsu.by.app.people.pupils",
                "com.vsu.by.app.people.teacher",
                "com.vsu.by.app.people.user",
                "com.vsu.by.app.role",
                "com.vsu.by.app.education.attempt",
                "com.vsu.by.app.education.pupilattempt",
                "com.vsu.by.app.education.mistake",
                "com.vsu.by.app.education.rule",
                "com.vsu.by.app.education.subject",
                "com.vsu.by.app.education.task",
                "com.vsu.by.app.education.tasktype");
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(this.getJpaProperty());
        return entityManagerFactoryBean;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/kursach_db");
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

    private Properties getJpaProperty() {
        Properties props = new Properties();
        props.setProperty("spring.jpa.hibernate.ddl-auto", "none");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("logging.level.org.hibernate.SQL", "DEBUG");
        props.setProperty("hibernate.use_sql_comments","true");
        return props;
    }
}
